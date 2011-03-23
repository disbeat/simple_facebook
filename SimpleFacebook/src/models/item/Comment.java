package models.item;

import java.util.Date;

import utils.HumanTime;
import models.entities.User;

public class Comment {
    
    public int id;
    
    private String content;
    private User createdBy;
    private long createdOn;
    private Item relatedTo;
    
    public Comment(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Item getRelatedTo() {
        return relatedTo;
    }

    public void setRelatedTo(Item relatedTo) {
        this.relatedTo = relatedTo;
    }
    
    

}
