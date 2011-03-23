package views.wall;

import models.item.Item;

public class WallIterator implements BaseIterator{
	OrderStrategy strategy = null;
	int currPos = 0;

	public WallIterator(OrderStrategy strategy) {
		this.strategy = strategy;
	}

	public void first() {
		currPos = 0;
	}

	public void next() {
		currPos++;
	}

	public boolean done() {
		return (currPos >= strategy.count());
	}

	public Item item() {
		return strategy.get(currPos);
	}
}
