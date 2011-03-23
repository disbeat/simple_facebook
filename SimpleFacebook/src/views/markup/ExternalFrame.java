package views.markup;

import clients.web.InterfaceTranslator;

public class ExternalFrame extends HierarchicalElement {
	protected String action = null;
	protected boolean scrolling = true;

	public ExternalFrame(String action, boolean scrolling) {
		this.action = action;
		this.scrolling = scrolling;
	}

	public String getAction() {
		return action;
	}

	public void setScrolling(boolean scrolling) {
		this.scrolling = scrolling;
	}

	public boolean getScrolling() {
		return scrolling;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	@Override
	public void accept(InterfaceTranslator visitor) {
		visitor.translate(this);
	}

}
