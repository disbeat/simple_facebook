package views.wall;

import java.util.Collections;
import java.util.Comparator;

import models.item.Item;

public class TypeOrderStrategy extends OrderStrategy implements Comparator<Item> {
	@Override
	public void order() {
		Collections.sort(items, this);
	}

	@Override
	public int compare(Item o1, Item o2) {
		Class<? extends Item> c1 = o1.getClass(), c2 = o2.getClass();
		if (c1.equals(c2)) {
			return -1 * Long.valueOf(o1.getCreatedOn()).compareTo(o2.getCreatedOn());
		} else {
			return c1.getSimpleName().compareTo(c2.getSimpleName());
		}
	}
}
