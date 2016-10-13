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

            item.decreaseSellIn();

            // Legendary item, do nothing
            if (itemName.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            if (itemName.equals("Aged Brie")) {
                item.increaseQuality();

                if (item.getSellIn() < 0) {
                    item.increaseQuality();
                }

                continue;
            }

            if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.getSellIn() <= 0) {
                    item.setQuality(0);
                    continue;
                }

                item.increaseQuality();

                if (item.getSellIn() <= 9) {
                    item.increaseQuality();
                }

                if (item.getSellIn() <= 4) {
                    item.increaseQuality();
                }

                continue;
            }

            // Generic handling for all other items

            item.decreaseQuality();

            if (item.getSellIn() < 0) {
                item.decreaseQuality();
            }
        }
    }

}
