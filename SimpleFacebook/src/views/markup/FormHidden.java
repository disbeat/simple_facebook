package views.markup;

import clients.web.InterfaceTranslator;

public class FormHidden extends HierarchicalElement {
	String name;
	String value;

	public FormHidden(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	@Override
	public void accept(InterfaceTranslator visitor) {
		visitor.translate(this);
	}
}
