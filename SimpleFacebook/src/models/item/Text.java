package models.item;

public class Text extends Item {
    
    String content;
    
    public Text( int id, String content ) {
        super(id);
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
}
