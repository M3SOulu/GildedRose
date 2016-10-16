package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {
	private List<Item> items = null;

	public List<Item> getItems() {
		return items;
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public GildedRose() {
		items = new ArrayList<Item>();
	}

	public void updateEndOfDay() {
        for (Item item : items) {
        	item.update();
        }
    }
}
