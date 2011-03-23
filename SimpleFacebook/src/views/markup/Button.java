package views.markup;

import clients.web.InterfaceTranslator;

public class Button extends Element {
	protected String name;
	protected String action;
	protected boolean forRoot;
	
	public Button(String name, String action, boolean forRoot) {
		this.name = name;
		this.action = action;
		this.forRoot = forRoot;
	}
	
	public String getAction() {
		return action;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isForRoot() {
		return forRoot;
	}
	
	@Override
	public void accept(InterfaceTranslator visitor) {
		visitor.translate(this);
	}
}
