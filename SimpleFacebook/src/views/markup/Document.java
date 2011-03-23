package views.markup;

import clients.web.InterfaceTranslator;

public class Document extends HierarchicalElement {
	protected String title = null;

	public Document(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public void accept(InterfaceTranslator visitor) {
		visitor.translate(this);
	}
}
