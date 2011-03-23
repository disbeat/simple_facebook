package views.markup;

import clients.web.InterfaceTranslator;

public class Form extends HierarchicalElement {
	String name;
	String action;

	public Form(String name, String action) {
		this.name = name;
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public void accept(InterfaceTranslator visitor) {
		visitor.translate(this);
	}
}
