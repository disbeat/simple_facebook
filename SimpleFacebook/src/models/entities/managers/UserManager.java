package models.entities.managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import models.entities.Relationship;
import models.entities.User;
import models.entities.relationship.RelationshipType;
import db.DatabaseInterface;

public class UserManager {

	private static UserManager manager;

	private HashMap<Integer, User> users = new HashMap<Integer, User>();

	private UserManager() {}

	public static UserManager getInstance() {
		if (manager == null) {
			manager = new UserManager();
		}
		return manager;
	}

	public User getUser(int id) throws SQLException {
	    
	    if (users.containsKey(id))
	        return users.get(id);
	    
	    String sql = "select first_name, last_name, photo from users where id = ?";
	    PreparedStatement ps = DatabaseInterface.getInstance().prepareStatement(sql);
		ps.setInt(1, id);
	    
		ResultSet rs = null;
		try{
		    rs =ps.executeQuery();
		
    		if (rs.next()) {
    		    User u = new User(id);
    		    
    		    u.putAttribute("first_name", rs.getString("first_name"));
    		    u.putAttribute("last_name", rs.getString("last_name"));
    		    u.putAttribute("photo", rs.getString("photo"));
    		    users.put(u.id, u);
    		    return u;
    		}else
    		    return null;
		}finally {
		    if (rs != null)
		        rs.close();
		}
		
	}
	
	public User loadUser(User u) throws SQLException {
	    String sql = "select email, sex, phone, password, photo, birthday from users where id = ?";
	        
        PreparedStatement ps = DatabaseInterface.getInstance().prepareStatement(sql);
        ps.setInt(1, u.id);
        
        ResultSet rs = null;
	    try {   
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            u.putAttribute("email", rs.getString("email"));
	            u.putAttribute("sex", rs.getString("sex"));
	            u.putAttribute("phone", rs.getString("phone"));
	            u.putAttribute("password", rs.getString("password"));
	            
	            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            //u.putAttribute("birthday", sdf.format( rs.getDate("birthday") ));
	            
	            u.putAttribute("birthday", rs.getString("birthday") );
	            u.setLoaded(true);
	        }
    	} finally {
            if (rs != null) 
                rs.close();
        }
	    return u;
	}

	public User validateCredentials(String email, String password) throws SQLException {
	    String sql = "select id from users where email = ? and password = ?";
        PreparedStatement ps = DatabaseInterface.getInstance().prepareStatement(sql);
        
        ps.setString(1, email);
        ps.setString(2, password);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
        
            if (rs.next()) 
                return getUser(rs.getInt("id"));
            else
                return null;
        } finally {
            if (rs != null) 
                rs.close();
        }
	}

	public List<User> getFriends(int id) throws SQLException {

	    String sql = "select distinct id, first_name, last_name, photo, user1, user2, status from users, relationships where " +
	    		"(user1 = ? and user2 = id)  and status = 1 order by first_name, last_name";

	    PreparedStatement ps = DatabaseInterface.getInstance().prepareStatement(sql);
	    ps.setInt(1, id);

	    ResultSet rs = null;
	    try {
	        rs = ps.executeQuery();
	        ArrayList <User> result = new ArrayList<User>();
	        
	        while (rs.next()) {
	            if (users.containsKey(rs.getInt("id")))
	                result.add(users.get(rs.getInt("id")));
	            else {
    	            User u = new User(rs.getInt("id"));
    	            u.putAttribute("first_name", rs.getString("first_name"));
    	            u.putAttribute("last_name", rs.getString("last_name"));
    	            u.putAttribute("photo", rs.getString("photo"));
    	            users.put(u.id, u);
    	            result.add(u);
	            }
	        }
	        return result;
	    } finally {
	        rs.close();
	    }
	}
	
	public boolean addRelationship(User u1, User u2, int status) throws SQLException {
	    String sql = "insert into relationships (user1, user2, status, created_on) values (?, ?, ?, datetime('now'))";
        PreparedStatement ps = DatabaseInterface.getInstance().prepareStatement(sql);
        
        ps.setInt(1, u1.id);
        ps.setInt(2, u2.id);
        ps.setInt(3, status);
        
        
        boolean result = ps.executeUpdate() > 0;
        ps.close();
        return result;
	}
	
	public boolean updateRelationshipStatus(User u1, User u2, int status) throws Exception {
	    getRelationship(u1, u2); 
	    
        String sql = "update relationships set status = ? where user1 = ? and user2 = ?";
        PreparedStatement ps = DatabaseInterface.getInstance().prepareStatement(sql);
        
        ps.setInt(1, status);
        ps.setInt(2, u1.id);
        ps.setInt(3, u2.id);
        
        boolean result =  ps.executeUpdate() > 0;
        ps.close();
        
        return result;
    }
	
	public boolean removeRelationship(User u1, User u2) throws SQLException {
        String sql = "delete from relationships where user1 = ? and user2 = ?";
        PreparedStatement ps = DatabaseInterface.getInstance().prepareStatement(sql);
        
        ps.setInt(1, u1.id);
        ps.setInt(2, u2.id);
        
        boolean bool = ps.executeUpdate() > 0;
        ps.close();
        ps = DatabaseInterface.getInstance().prepareStatement(sql);
        
        ps.setInt(1, u1.id);
        ps.setInt(2, u2.id);
        
        bool |= ps.executeUpdate() > 0;
        
        ps.close();
        return bool;
        
        
    }
	
	public boolean persistUser( User u ) throws SQLException {
	    String sql = "insert into users (birthday, first_name, last_name, sex, email, phone, password, photo) values ( ?, ?, ?, ?, ?, ?, ?, ? )";
	    
	    PreparedStatement ps = DatabaseInterface.getInstance().prepareStatement(sql);
	    
	    String[] colValues = { u.getAttribute("birthday"), u.getAttribute("first_name"), u.getAttribute("last_name"), 
                u.getAttribute("sex"), u.getAttribute("email"), u.getAttribute("phone"), u.getAttribute("password"), u.getAttribute("photo") };
	    for (int i = 1; i <= colValues.length; i++)
	        ps.setString(i, colValues[i-1]);
	    
	    return ps.executeUpdate() > 0;
	}
	
	public List<User> searchUser(String query, int limit, User user) throws SQLException {

        String sql = null;
        
        if (user != null) {
            sql = "select id, first_name, last_name, photo, user1, user2 from users, relationships where ";
            sql += " (first_name like ? or last_name like ?) ";
            sql += " and user2 = id and user1 = ? ";
            sql += " order by first_name, last_name limit ?";
        }else {
            sql = "select id, first_name, last_name, photo from users where ";
            sql += " (first_name like ? or last_name like ?) ";
            sql += " order by first_name, last_name limit ?";
        }

        PreparedStatement ps = DatabaseInterface.getInstance().prepareStatement(sql);
        
        query = "%"+query.replace(" ", "%")+"%";
        ps.setString(1, query);
        ps.setString(2, query);
        if (user != null) {
            ps.setInt(3, user.id);
            ps.setInt(4, limit);
        }else
            ps.setInt(3, limit);

        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            ArrayList <User> result = new ArrayList<User>();
            
            while (rs.next()) {
                if (users.containsKey(rs.getInt("id")))
                    result.add(users.get(rs.getInt("id")));
                else {
                    User u = new User(rs.getInt("id"));
                    u.putAttribute("first_name", rs.getString("first_name"));
                    u.putAttribute("last_name", rs.getString("last_name"));
                    u.putAttribute("photo", rs.getString("photo"));
                    users.put(u.id, u);
                    result.add(u);
                }
            }
            return result;
        } finally {
            rs.close();
        }
    }
	
	
	public Relationship getRelationship(User u1, User u2) throws Exception {
	    String sql = "select status from relationships where user1 = ? and user2 = ?";
        PreparedStatement ps = DatabaseInterface.getInstance().prepareStatement(sql);
        
        ps.setInt(1, u1.id);
        ps.setInt(2, u2.id);
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            int status = rs.getInt("status");
            rs.close();
            return new Relationship(u1, u2, RelationshipType.get(status).getType().newInstance() );
        }
        
        rs.close();
        addRelationship(u1, u2, 0);
        return new Relationship(u1, u2, RelationshipType.get(0).getType().newInstance() );
	}

}


