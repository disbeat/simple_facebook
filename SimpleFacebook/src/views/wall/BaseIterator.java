package views.wall;

import models.item.Item;

public interface BaseIterator {

    public void first();
    public void next();
    public boolean done();
    public Item item();

}
