package models.entities;

import models.entities.relationship.RelationshipStatus;
import clients.builder.InterfaceBuilder;

public class Relationship {
    
    User user1, user2;
    
    RelationshipStatus state;
    
    public Relationship(User user1, User user2, RelationshipStatus state) {
        this.user1 = user1;
        this.user2 = user2;
        this.state = state;
    }

    public void buildInterface(InterfaceBuilder b, int parent) {
        state.buildInterface(this, b, parent);
    }
    
    public void changeState() {
        state.changeState(this);
    }
    
    public User getUser1() {
        return user1;
    }
    
    public User getUser2() {
        return user2;
    }
    
    public RelationshipStatus getState() {
        return state;
    }
}
