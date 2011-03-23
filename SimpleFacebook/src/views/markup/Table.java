package views.markup;

import clients.web.InterfaceTranslator;

public class Table extends HierarchicalElement {
	protected int cols = 1;
	protected int rows = 1;

	public Table(int rows, int cols) {
		this.cols = cols;
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public int getRows() {
		return rows;
	}

	@Override
	public void accept(InterfaceTranslator visitor) {
		visitor.translate(this);
	}
}
