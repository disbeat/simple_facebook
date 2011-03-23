package models.item;

public enum ItemType {
    
    TEXT (1),
    PHOTO (2),
    VIDEO (3);
    
    private int value;
    ItemType(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
