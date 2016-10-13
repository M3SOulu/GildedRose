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
    public static void updateEndOfDay()
    {
    	for(Item item:items)
        {
			if ((!"Aged Brie".equals(item.getName())) && 
            		!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) 
            {
                if (isQualityMoreThanZero(item))
                {
                    if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
                    {
                        decreaseQuality(item);
                    }
                }
            }
            else
            {
                if (isQualityAboveFifty(item))
                {
                    increaseQuality(item);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                    {
                        if (item.getSellIn() < 11)
                        {
                            if (isQualityAboveFifty(item))
                            {
                                increaseQuality(item);
                            }
                        }

                        if (item.getSellIn() < 6)
                        {
                            if (isQualityAboveFifty(item))
                            {
                                increaseQuality(item);
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
            {
                decreaseSellIn(item);
            }

            if (item.getSellIn() < 0)
            {
                if (!"Aged Brie".equals(item.getName()))
                {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                    {
                        if (isQualityMoreThanZero(item))
                        {
                            if (!"Sulfuras, Hand of Ragnaros".equals(item.getName()))
                            {
                                decreaseQuality(item);
                            }
                        }
                    }
                    else
                    {
                    	updateQuality(item);
                    }
                }
                else
                {
                    if (isQualityAboveFifty(item))
                    {
                        increaseQuality(item);
                    }
                }
            }
        }
    }

	private static boolean isQualityAboveFifty(Item item) {
		return item.getQuality() < 50;
	}

	private static boolean isQualityMoreThanZero(Item item) {
		return item.getQuality() > 0;
	}

	private static void updateQuality(Item item) {
		item.setQuality(item.getQuality() - item.getQuality());
	}

	private static void decreaseQuality(Item item) {
		item.setQuality(item.getQuality() - 1);
	}

	private static void decreaseSellIn(Item item) {
		item.setSellIn(item.getSellIn() - 1);
	}

	private static void increaseQuality(Item item) {
		item.setQuality(item.getQuality() + 1);
	}

}
