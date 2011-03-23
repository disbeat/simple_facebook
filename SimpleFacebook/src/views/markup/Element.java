package views.markup;

import java.util.ArrayList;

import clients.builder.Style;
import clients.web.InterfaceTranslator;

public abstract class Element {
	protected Style style;

	public Element style(Style style) {
		this.style = style;
		return this;
	}

	public void add(Element ele) {
		throw new UnsupportedOperationException("Element object doen't have children.");
	}

	public Element get(int pos) {
		throw new UnsupportedOperationException("Element object doen't have children.");
	}
	
	public ArrayList<Element> getElements() {
		throw new UnsupportedOperationException("Element object doen't have children.");
	}
	
	public abstract void accept(InterfaceTranslator visitor);
	
	public Style style() {
		return style;
	}
	
}
