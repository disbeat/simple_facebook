package models.entities.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import models.entities.User;
import models.item.Comment;
import models.item.Item;
import models.item.ItemType;
import models.item.Photo;
import models.item.Text;
import models.item.Video;
import db.DatabaseInterface;

public class ItemManager {

	private static ItemManager manager;

	private HashMap<Integer, Item> items = new HashMap<Integer, Item>();

	private ItemManager() {
	}

	public static ItemManager getInstance() {
		if (manager == null) {
			manager = new ItemManager();
		}
		return manager;
	}

	public Item getItem(int id) throws SQLException {

		if (items.containsKey(id))
			return items.get(id);

		String sql = "select id, content, created_on, url, type, user_id from items where id = ?";
		PreparedStatement ps = DatabaseInterface.getInstance().prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = null;
		try {
			rs = ps.executeQuery();

			if (rs.next()) {

				Item i;

				int type = rs.getInt("type");

				if (type == ItemType.PHOTO.value()) {
					i = new Photo(id, rs.getString("url"));
				} else if (type == ItemType.VIDEO.value()) {
					i = new Video(id, rs.getString("url"));
				} else if (type == ItemType.TEXT.value()) {
					i = new Text(id, rs.getString("content"));
				} else
					return null;

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

				try {
					i.setCreatedOn(sdf.parse(rs.getString("created_on")).getTime());
				} catch (ParseException e) {
					e.printStackTrace();
				}

				i.setCreatedBy(UserManager.getInstance().getUser(rs.getInt("user_id")));
				items.put(i.id, i);
				return i;
			} else
				return null;
		} finally {
			if (rs != null)
				rs.close();
		}

	}

	public List<Item> getLastItems(int user_id, int n, boolean showFriends) throws SQLException {
		PreparedStatement ps = null;
		if (showFriends) {
			List<User> friends = UserManager.getInstance().getFriends(user_id);

			StringBuffer sb = new StringBuffer();
			sb.append("select * from items where user_id in ( ? ");
			for (int i = 0; i < friends.size(); i++)
				sb.append(", ?");
			sb.append(" ) order by created_on desc limit ").append(n);
			ps = DatabaseInterface.getInstance().prepareStatement(sb.toString());

			ps.setInt(1, user_id);

			for (int i = 0; i < friends.size(); i++)
				ps.setInt(i + 2, friends.get(i).id);

		} else {
			String sql = "select id, type, content, created_on, user_id, url from items where user_id = ? order by created_on desc limit ?";
			ps = DatabaseInterface.getInstance().prepareStatement(sql);

			ps.setInt(1, user_id);
			ps.setInt(2, n);
		}
		ResultSet rs = null;

		try {
			rs = ps.executeQuery();

			List<Item> result = new ArrayList<Item>();

			while (rs.next()) {

				Item i;

				int type = rs.getInt("type");
				int id = rs.getInt("id");

				if (items.containsKey(id)) {
					result.add(items.get(id));
					continue;
				}

				if (type == ItemType.PHOTO.value()) {
					i = new Photo(id, rs.getString("url"));
				} else if (type == ItemType.VIDEO.value()) {
					i = new Video(id, rs.getString("url"));
				} else if (type == ItemType.TEXT.value()) {
					i = new Text(id, rs.getString("content"));
				} else
					i = new Item(id);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

				try {
					i.setCreatedOn(sdf.parse(rs.getString("created_on")).getTime());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				i.setCreatedBy(UserManager.getInstance().getUser(rs.getInt("user_id")));
				items.put(i.id, i);
				result.add(i);
			}

			return result;
		} finally {
			if (rs != null)
				rs.close();
		}
	}

	public List<Comment> getComments(int item_id) {
		ArrayList<Comment> result = new ArrayList<Comment>();

		try {
			String sql = "select id, content, user_id, item_id, created_on from comments where item_id = ?";
			PreparedStatement ps = DatabaseInterface.getInstance().prepareStatement(sql);

			ps.setInt(1, item_id);

			ResultSet rs = null;

			try {
				rs = ps.executeQuery();
				while (rs.next()) {
					Comment c = new Comment(rs.getInt("id"));
					c.setContent(rs.getString("content"));

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					try {
						c.setCreatedOn(sdf.parse(rs.getString("created_on")).getTime());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					c.setCreatedBy(UserManager.getInstance().getUser(rs.getInt("user_id")));
					result.add(c);
				}
			} finally {
				if (rs != null)
					rs.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Comment getComment(int id) throws SQLException {
		ResultSet rs = null;
		try {
			String sql = "select id, content, user_id, item_id, created_on from comments where id = ?";
			PreparedStatement ps = DatabaseInterface.getInstance().prepareStatement(sql);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				Comment c = new Comment(rs.getInt("id"));
				c.setContent(rs.getString("content"));

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				try {
					c.setCreatedOn(sdf.parse(rs.getString("created_on")).getTime());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				c.setCreatedBy(UserManager.getInstance().getUser(rs.getInt("user_id")));

				return c;
			}
			return null;
		} finally {
			if (rs != null)
				rs.close();
		}
	}

	public boolean persistItem(Item item) throws SQLException {
		String sql = "insert into items (content, created_on, url, type, user_id) values ( ?, datetime('now'), ?, ?, ? )";

		PreparedStatement ps = DatabaseInterface.getInstance().prepareStatement(sql);
		if (item instanceof Text) {
			ps.setString(1, ((Text) item).getContent());
			ps.setString(2, null);
			ps.setInt(3, ItemType.TEXT.value());
		} else if (item instanceof Video) {
			ps.setString(1, null);
			ps.setString(2, ((Video) item).getUrl());
			ps.setInt(3, ItemType.VIDEO.value());
		} else if (item instanceof Photo) {
			ps.setString(1, null);
			ps.setString(2, ((Photo) item).getUrl());
			ps.setInt(3, ItemType.PHOTO.value());
		}

		ps.setInt(4, item.getCreatedBy().id);

		int added = ps.executeUpdate();

		item.id = ps.getGeneratedKeys().getInt(1);
		return added > 0;
	}

	public boolean persistComment(Comment comment) throws SQLException {
		String sql = "insert into comments (content, created_on, user_id, item_id) values ( ?, datetime('now'), ?, ? )";

		PreparedStatement ps = DatabaseInterface.getInstance().prepareStatement(sql);
		ps.setString(1, comment.getContent());
		ps.setInt(2, comment.getCreatedBy().id);
		ps.setInt(3, comment.getRelatedTo().id);
		int added = ps.executeUpdate();

		comment.id = ps.getGeneratedKeys().getInt(1);

		return added > 0;
	}

	public Comment createComment(String content, User u, Item i) throws SQLException {
		String sql = "insert into comments (content, created_on, user_id, item_id) values ( ?, datetime('now'), ?, ? )";

		PreparedStatement ps = DatabaseInterface.getInstance().prepareStatement(sql);
		ps.setString(1, content);
		ps.setInt(2, u.id);
		ps.setInt(3, i.id);
		int added = ps.executeUpdate();
		assert (added > 0);

		return getComment(ps.getGeneratedKeys().getInt(1));
	}
	
	public List<Item> searchItem(String text, int n, User u) throws SQLException {
	    PreparedStatement ps = null;
	    String sql = null;
	    if (u != null) {
            sql = "select id, type, content, items.created_on, user_id, user1, user2, url from items, relationships where type = 1 and content LIKE ? ";
            sql += " and user2 = user_id and user1 = ? ";
            sql += "order by items.created_on desc limit ?";
	    }else {
	        sql = "select id, type, content, created_on, user_id, url from items where type = 1 and content LIKE ? ";
            sql += "order by created_on desc limit ?";
	    }
            
        ps = DatabaseInterface.getInstance().prepareStatement(sql);

        text = "%"+text.replace(" ", "%")+"%";
    
        ps.setString(1, text);
        if (u != null) {
            ps.setInt(2, u.id);
            ps.setInt(3, n);
        }else
            ps.setInt(2, n);
            
        ResultSet rs = null;

        try {
            rs = ps.executeQuery();

            List<Item> result = new ArrayList<Item>();

            while (rs.next()) {

                Item i;

                int type = rs.getInt("type");
                int id = rs.getInt("id");

                if (items.containsKey(id)) {
                    result.add(items.get(id));
                    continue;
                }

                if (type == ItemType.PHOTO.value()) {
                    i = new Photo(id, rs.getString("url"));
                } else if (type == ItemType.VIDEO.value()) {
                    i = new Video(id, rs.getString("url"));
                } else if (type == ItemType.TEXT.value()) {
                    i = new Text(id, rs.getString("content"));
                } else
                    i = new Item(id);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

                try {
                    i.setCreatedOn(sdf.parse(rs.getString("created_on")).getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                i.setCreatedBy(UserManager.getInstance().getUser(rs.getInt("user_id")));
                items.put(i.id, i);
                result.add(i);
            }

            return result;
        } finally {
            if (rs != null)
                rs.close();
        }
	    
	}
}
