package views.markup;

import java.util.ArrayList;

import clients.web.InterfaceTranslator;

public abstract class HierarchicalElement extends Element {
	protected ArrayList<Element> elements = new ArrayList<Element>();

	@Override
	public void add(Element ele) {
		elements.add(ele);
	}

	@Override
	public Element get(int pos) {
		return elements.get(pos);
	}

	@Override
	public ArrayList<Element> getElements() {
		return elements;
	}

    public void accept(InterfaceTranslator visitor) {
        // TODO Auto-generated method stub
        
    }
}
