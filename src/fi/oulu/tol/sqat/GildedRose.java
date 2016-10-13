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
            // Sell-in value is decreased beforehand to simplify the code
            item.decreaseSellIn();

            String itemName = item.getName();
            int itemSellIn = item.getSellIn();

            // Legendary item, the quality never changes
            if (itemName.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            if (itemName.equals("Aged Brie")) {
                item.increaseQuality();

                // Old brie's quality increases twice as fast
                if (itemSellIn < 0) {
                    item.increaseQuality();
                }

                continue;
            }

            if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                // Old concert
                if (itemSellIn <= 0) {
                    item.setQuality(0);
                    continue;
                }

                item.increaseQuality();

                // 10 days or less -> double speed
                if (itemSellIn <= 9) {
                    item.increaseQuality();
                }

                // 5 days or less -> triple speed!
                if (itemSellIn <= 4) {
                    item.increaseQuality();
                }

                continue;
            }

            // Generic handling for all other items
            item.decreaseQuality();

            if (itemSellIn < 0) {
                item.decreaseQuality();
            }
        }
    }

}
