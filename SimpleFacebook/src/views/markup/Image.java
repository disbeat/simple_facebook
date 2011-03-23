package views.markup;

import clients.web.InterfaceTranslator;

public class Image extends Element {
	protected String url = null;
	protected int width = -1;
	protected int height = -1;
	
	public Image(String url, int width, int height) {
		this.url = url;
		this.width = width;
		this.height = height;
	}
	
	public Image(String url) {
		this(url, -1, -1);
	}
	
	public String getUrl() {
		return url;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	@Override
	public void accept(InterfaceTranslator visitor) {
		visitor.translate(this);
	}
}
