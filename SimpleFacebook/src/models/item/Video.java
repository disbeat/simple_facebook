package models.item;

public class Video extends Item {

	String url;

	public Video(int id, String url) {
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
