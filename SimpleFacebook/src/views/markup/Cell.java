package views.markup;

import clients.web.InterfaceTranslator;

public class Cell extends HierarchicalElement {
	public int row, col, span;

	public Cell(int row, int col, int span) {
		super();
		this.row = row;
		this.col = col;
		this.span = span;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int getSpan() {
		return span;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setSpan(int span) {
		this.span = span;
	}

	@Override
	public void accept(InterfaceTranslator visitor) {
		visitor.translate(this);
	}
}
