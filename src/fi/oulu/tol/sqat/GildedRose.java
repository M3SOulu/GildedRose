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
            if (item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            if ((!"Aged Brie".equals(item.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
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

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
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

            if (item.getSellIn() < 0)
            {
                if (!"Aged Brie".equals(item.getName()))
                {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                    {
                        if (item.getQuality() > 0)
                        {
                            item.decreaseQuality();
                        }
                    }
                    else
                    {
                        item.setQuality(0);
                    }
                }
                else
                {
                    if (item.getQuality() < 50)
                    {
                        item.increaseQuality();
                    }
                }
            }
        }
    }

}
