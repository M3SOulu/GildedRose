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
            updateItem(item);
        }
    }

    /**
     * Update an item's quality and sell-in value
     */
    private void updateItem(Item item) {
        String itemName = item.getName();

        // Legendary item, do nothing
        if (itemName.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }


        // Sell-in value is decreased already here to simplify the code,
        // but the current value is used in calculations for clarity
        int itemSellIn = item.getSellIn();
        item.decreaseSellIn();


        if (itemName.equals("Aged Brie")) {
            item.increaseQuality();

            // Old brie's quality increases twice as fast
            if (itemSellIn <= 0) {
                item.increaseQuality();
            }

            return;
        }


        if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
            // Old concert
            if (itemSellIn <= 1) {
                item.setQuality(0);
                return;
            }

            item.increaseQuality();

            // 10 days or less -> double speed
            if (itemSellIn <= 10) {
                item.increaseQuality();
            }

            // 5 days or less -> triple speed!
            if (itemSellIn <= 5) {
                item.increaseQuality();
            }

            return;
        }


        // Generic handling for all other items.
        // Quality drops twice as fast for old items
        item.decreaseQuality();
        if (itemSellIn <= 0) {
            item.decreaseQuality();
        }
    }

}
