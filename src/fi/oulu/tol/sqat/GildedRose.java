package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;
	
	private static final String AGED_BRIE = "Aged Brie";
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    public static void updateEndOfDay()
    {
        for (Item item: items) {
        	if ((AGED_BRIE.equals(item.getName())) || BACKSTAGE_PASSES.equals(item.getName())) {
        		if (!hasReachedMaximumQuality(item)) {
                    item.increaseQuality();

                    if (BACKSTAGE_PASSES.equals(item.getName())) {
                        if (sellInDateIsLessThanReferencedInteger(item, 11)) {
                            if (!hasReachedMaximumQuality(item)) {
                                item.increaseQuality();
                            }
                        }
                        if (sellInDateIsLessThanReferencedInteger(item, 6)) {
                            if (!hasReachedMaximumQuality(item)) {
                                item.increaseQuality();
                            }
                        }
                    }
                }
        	}
        	else {
                if (!hasZeroQuality(item)) {
                    if (!SULFURAS.equals(item.getName())) {
                        item.decreaseQuality();
                    }
                }
            }

            if (!SULFURAS.equals(item.getName())) {
            	item.decreaseSellIn();
            }

            if (item.getSellIn() < 0) {
                if (!AGED_BRIE.equals(item.getName())) {
                    if (!BACKSTAGE_PASSES.equals(item.getName())) {
                        if (!hasZeroQuality(item)) {
                            if (!SULFURAS.equals(item.getName())) {
                                item.decreaseQuality();
                            }
                        }
                    }
                    else {
                        item.setQuality(item.getQuality() - item.getQuality());
                    }
                }
                else {
                    if (!hasReachedMaximumQuality(item)) {
                        item.increaseQuality();
                    }
                }
            }
        }
    }

    private static boolean sellInDateIsLessThanReferencedInteger(Item item, int i) {
		return item.getSellIn() < i;
	}

	private static boolean hasReachedMaximumQuality(Item item) {
    	return item.getQuality() == 50;
	}

	public static boolean hasZeroQuality(Item item) {
    	return item.getQuality() == 0;
    }

	public void addItem(Item item) {
		items = new ArrayList<Item>();
		items.add(item);
	}

	public List<Item> getItems() {
		return items;
	}
}