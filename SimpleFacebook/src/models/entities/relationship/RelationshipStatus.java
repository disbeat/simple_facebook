package models.entities.relationship;

import models.entities.Relationship;
import clients.builder.InterfaceBuilder;

public abstract class RelationshipStatus {
    
    public abstract void buildInterface(Relationship r, InterfaceBuilder b, int parent);
    
    public abstract void changeState(Relationship r);

}
