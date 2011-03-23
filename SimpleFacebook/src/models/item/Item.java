package models.item;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import models.entities.User;
import models.entities.managers.ItemManager;
import utils.HumanTime;

public class Item {
	public int id;
	protected User createdBy;
	protected long createdOn;

	List<Comment> comments = null;

	public Item(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id == ((Item) obj).id;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public long getCreatedOn() {
		return createdOn;
	}

	public String getCreatedOnFormatted() {
		long delta = new Date().getTime() - new Date(createdOn).getTime();
		return new HumanTime(delta).getApproximately() + " ago";
	}

	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}

	public boolean addComment(String content, User u) throws SQLException {
		if (comments == null)
			comments = ItemManager.getInstance().getComments(this.id);

		Comment c = ItemManager.getInstance().createComment(content, u, this);

		if (c != null)
			comments.add(c);

		return c != null;
	}

	public List<Comment> getComments() {
		if (comments == null)
			comments = ItemManager.getInstance().getComments(this.id);
		return comments;
	}
}
