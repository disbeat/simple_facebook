package views.wall;

import java.util.ArrayList;
import java.util.List;

import models.item.Item;

public abstract class OrderStrategy {
	ArrayList<Item> items = null;

	public void setItems(List<Item> original) {
		items = new ArrayList<Item>(original);
		order();
	}

	public int count() {
		return items.size();
	}

	public Item get(int pos) {
		return items.get(pos);
	}

	public abstract void order();
}
