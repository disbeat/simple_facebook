package models.entities.relationship;


public enum RelationshipType {
    
    NO_RELATION(0, NoRelationship.class),
    FRIEND_RELATION(1, FriendRelationship.class),
    INVITED_RELATION(2, InvitedRelationship.class),
    PENDING_RELATION(3, PendingRelationship.class);
    
    private int num;
    private Class<? extends RelationshipStatus> type;
    
    private static ReverseEnumMap map =
        new ReverseEnumMap();
    
    private RelationshipType(int num, Class<? extends RelationshipStatus> type){
        this.num = num;
        this.type = type;
    }
    
    public int getNum() {
        return num;
    }
    
    public Class<? extends RelationshipStatus> getType() {
        return type;
    }

    public static RelationshipType get(int num) {
        return map.get(num);
    }
    
}
