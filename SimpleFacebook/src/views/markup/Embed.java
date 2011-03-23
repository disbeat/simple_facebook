package views.markup;

import clients.web.InterfaceTranslator;

public class Embed extends Element {
	String src = null;
	
	public Embed(String src) {
		this.src = src;
	}
	
	public String getSrc() {
		return src;
	}
	
	@Override
	public void accept(InterfaceTranslator visitor) {
		visitor.translate(this);
	}
}
