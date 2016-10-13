package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;

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
            String itemName = item.getName();

            if (itemName.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            if (itemName.equals("Aged Brie")) {
                item.increaseQuality();
            } else if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.getSellIn() <= 1) {
                    item.setQuality(0);
                    continue;
                }

                item.increaseQuality();

                if (item.getSellIn() <= 10) {
                    item.increaseQuality();
                }

                if (item.getSellIn() <= 5) {
                    item.increaseQuality();
                }
            } else {
                item.decreaseQuality();
            }

            item.decreaseSellIn();

            if (item.getSellIn() < 0) {
                if (itemName.equals("Aged Brie"))
                {
                    item.increaseQuality();
                    continue;
                }

                item.decreaseQuality();
            }
        }
    }

}
