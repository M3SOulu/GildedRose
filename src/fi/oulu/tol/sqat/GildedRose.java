package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {
	
	private static final String AGED_BRIE = "Aged Brie";
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

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
	
    public static void updateEndOfDay()
    {
        for (Item item : items)
        {
            decreaseItemSellIn(item);
            updateItemQuality(item);
        }
    }

	private static void updateItemQuality(Item item) {
		switch(item.getName()) {
			case BACKSTAGE_PASS:
				updateBackstagePassQuality(item);
				break;
			case AGED_BRIE:
				updateAgedBrieQuality(item);
				break;
			case SULFURAS:
				break;
			default:
				decreaseItemQuality(item, false);
				break;
		}
	}

	private static void decreaseItemSellIn(Item item) {
		if (item.getName() != SULFURAS) {
		    item.decreaseSellIn();
		}
	}

	private static void updateAgedBrieQuality(Item item) {
	    item.increaseQuality(1);
	    if (item.sellInPassed()) {
	    	item.increaseQuality(1);
	    }
	}

	private static void updateBackstagePassQuality(Item item) {
		item.increaseQuality(1);
		if (item.sellInPassed()) {
			item.setQuality(0);
		}
		else if (item.getSellIn() < 5) {
			item.increaseQuality(2);
		}
		else if (item.getSellIn() < 10) {
			item.increaseQuality(1);
		}
	}

	private static void decreaseItemQuality(Item item, boolean rot) {
        item.decreaseQuality(1);
    	if (item.sellInPassed() && !rot) {
    		decreaseItemQuality(item, true);
    	}
	}

}
