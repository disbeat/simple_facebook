package views.markup;

import clients.web.InterfaceTranslator;

public class Input extends Element {
	String name = null;
	Boolean isPasswordInput = false;

	public Input(String name, boolean isPasswordInput) {
		this.name = name;
		this.isPasswordInput = isPasswordInput;
	}

	public Input(String name) {
		this(name, false);
	}

	public Boolean isPasswordInput() {
		return isPasswordInput;
	}

	public String getName() {
		return name;
	}

	@Override
	public void accept(InterfaceTranslator visitor) {
		visitor.translate(this);
	}
}
