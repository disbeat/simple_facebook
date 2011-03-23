package models.entities.relationship;

import models.entities.Relationship;
import models.entities.managers.UserManager;
import clients.builder.InterfaceBuilder;
import clients.builder.Style;

public class FriendRelationship extends RelationshipStatus {

    @Override
    public void buildInterface(Relationship r, InterfaceBuilder b, int parent) {
        if (r.getUser1().equals(r.getUser2()))
            return;
        
        int p = b.createParagraph(parent, new Style());
        
        b.createButton(p, "Remove friend", "ChangeRelationship?user="+r.getUser2().id, 
                true, new Style());
        
    }

    @Override
    public void changeState(Relationship r) {
        try {
            UserManager.getInstance().updateRelationshipStatus(r.getUser1(), r.getUser2(), RelationshipType.NO_RELATION.getNum());
            UserManager.getInstance().updateRelationshipStatus(r.getUser2(), r.getUser1(), RelationshipType.NO_RELATION.getNum());
            r.getUser1().removeFriend(r.getUser2());
            r.getUser2().removeFriend(r.getUser1());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
