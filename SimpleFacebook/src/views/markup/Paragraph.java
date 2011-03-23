package views.markup;

import clients.web.InterfaceTranslator;

public class Paragraph extends HierarchicalElement {
	@Override
	public void accept(InterfaceTranslator visitor) {
		visitor.translate(this);
	}
}
