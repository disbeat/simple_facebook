package views.wall;

import java.util.Collections;
import java.util.Comparator;

import models.item.Item;

public class ActivityOrderStrategy extends OrderStrategy implements Comparator<Item> {

	@Override
	public void order() {
		Collections.sort(items, this);
	}

	@Override
	public int compare(Item o1, Item o2) {
		return -1 * new Integer(o1.getComments().size()).compareTo(o2.getComments().size());
	}

}
