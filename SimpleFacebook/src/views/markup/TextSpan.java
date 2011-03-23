package views.markup;

import java.awt.Color;

import clients.web.InterfaceTranslator;

public class TextSpan extends Element {
	String text = null;
	Color color = Color.black;
	boolean bold = false;

	public TextSpan(String text, Color color) {
		this.text = text;
		this.color = color;
	}

	public TextSpan(String text, Color color, boolean bold) {
		this.text = text;
		this.color = color;
		this.bold = bold;
	}

	public TextSpan(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public Color getColor() {
		return color;
	}

	public boolean getBold() {
		return bold;
	}
	
	@Override
	public void accept(InterfaceTranslator visitor) {
		visitor.translate(this);
	}
}

