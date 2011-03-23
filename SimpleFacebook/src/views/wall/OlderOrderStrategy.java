package views.wall;

import java.util.Collections;
import java.util.Comparator;

import models.item.Item;

public class OlderOrderStrategy extends OrderStrategy implements Comparator<Item> {

	@Override
	public void order() {
		Collections.sort(items, this);
	}

	@Override
	public int compare(Item o1, Item o2) {
		return Long.valueOf(o1.getCreatedOn()).compareTo(o2.getCreatedOn());
	}

}
