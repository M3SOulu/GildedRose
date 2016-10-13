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

            if ((!"Aged Brie".equals(itemName)) && !"Backstage passes to a TAFKAL80ETC concert".equals(itemName))
            {
                if (item.getQuality() > 0)
                {
                    item.decreaseQuality();
                }
            }
            else
            {
                if (item.getQuality() < 50)
                {
                    item.increaseQuality();

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(itemName))
                    {
                        if (item.getSellIn() < 11)
                        {
                            if (item.getQuality() < 50)
                            {
                                item.increaseQuality();
                            }
                        }

                        if (item.getSellIn() < 6)
                        {
                            if (item.getQuality() < 50)
                            {
                                item.increaseQuality();
                            }
                        }
                    }
                }
            }

            item.decreaseSellIn();

            if (item.getSellIn() < 0) {
                if (itemName.equals("Aged Brie"))
                {
                    if (item.getQuality() < 50) {
                        item.increaseQuality();
                    }
                    continue;
                }

                if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")
                    && item.getQuality() > 0)
                {
                    item.setQuality(0);
                    continue;
                }

                if (item.getQuality() > 0) {
                    item.decreaseQuality();
                }
            }
        }
    }

}
