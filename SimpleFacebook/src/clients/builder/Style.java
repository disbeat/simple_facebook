package clients.builder;

import java.awt.Color;

public class Style {
	public enum Align {
		LEFT, CENTER, RIGHT
	};
	
	public enum VAlign {
		TOP, MIDDLE, BOTTOM
	}

	public Color textColor = null;
	public Color bgColor = null;
	public Color borderColor = null;

	public int padding = -1;
	public int margin = -1;
	public int border = -1;

	public Align align = null;
	public VAlign valign = null;
	public boolean vertical = false, center = false;
	
	public String fontName = "Tahoma";
	public int fontSize = 14;
	public boolean fontBold = false;

	public int width = -1;
	public int height = -1;
	public int maxwidth = -1;
	public int maxheight = -1;

	public Style align(Align align) {
		this.align = align;
		return this;
	}
	
	public Style valign(VAlign valign) {
		this.valign = valign;
		return this;
	}

	public Style bgcolor(int r, int g, int b) {
		this.bgColor = new Color(r, g, b);
		return this;
	}

	public Style bgcolor(Color bgColor) {
		this.bgColor = bgColor;
		return this;
	}

	public Style border(int borderSize) {
		this.border = borderSize;
		return this;
	}

	public Style border(int borderSize, int r, int g, int b) {
		this.border = borderSize;
		this.borderColor = new Color(r, g, b);
		return this;
	}

	public Style border(int borderSize, Color borderColor) {
		this.border = borderSize;
		this.borderColor = borderColor;
		return this;
	}

	public Style font(String name) {
		this.fontName = name;
		return this;
	}

	public Style font(int size) {
		this.fontSize = size;
		return this;
	}

	public Style font(String name, int size) {
		this.fontName = name;
		this.fontSize = size;
		return this;
	}

	public Style font(String name, int size, boolean bold) {
		this.fontName = name;
		this.fontSize = size;
		this.fontBold = bold;
		return this;
	}

	public Style fullheight() {
		this.height = Integer.MAX_VALUE;
		return this;
	}

	public Style fullwidth() {
		this.width = Integer.MAX_VALUE;
		return this;
	}

	public Style height(int height) {
		this.height = height;
		return this;
	}

	public Style margin(int marginSize) {
		this.margin = marginSize;
		return this;
	}

	public Style padding(int paddingSize) {
		this.padding = paddingSize;
		return this;
	}

	public Style text(Color textColor) {
		this.textColor = textColor;
		return this;
	}

	public Style text(int r, int g, int b) {
		this.textColor = new Color(r, g, b);
		return this;
	}

	public Style width(int width) {
		this.width = width;
		return this;
	}
	
	public Style maxwidth(int width) {
		this.maxwidth = width;
		return this;
	}
	
	public Style maxheight(int height) {
		this.maxheight = height;
		return this;
	}
	
	public Style vertical() {
		this.vertical = true;
		return this;
	}
	
	public Style center() {
		this.center = true;
		return this;
	}
}
