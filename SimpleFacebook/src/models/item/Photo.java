package models.item;

public class Photo extends Item {

    String url;
    
    public Photo(int id, String url) {
        super(id);
        this.url = url;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
}
