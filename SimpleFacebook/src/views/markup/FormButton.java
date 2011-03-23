package views.markup;

import clients.web.InterfaceTranslator;

public class FormButton extends Element {
	protected String text;

	public FormButton(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	@Override
	public void accept(InterfaceTranslator visitor) {
		visitor.translate(this);
	}
}
