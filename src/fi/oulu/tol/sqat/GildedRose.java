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
	
	private static boolean isSellInLessThanSix(Item item) {
		return item.getSellIn() < 6;
	}

	private static boolean isSellInLessThanEleven(Item item) {
		return item.getSellIn() < 11;
	}

	private static boolean isSellInUnderZero(Item item) {
		return item.getSellIn() < 0;
	}

	private static boolean isQualityAboveFifty(Item item) {
		return item.getQuality() < 50;
	}

	private static boolean isQualityAboveZero(Item item) {
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
	
    public static void updateEndOfDay()
    {
    	for(Item item:items)
        {
			if ((!"Aged Brie".equals(item.getName())) && 
            		!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) 
            {
                if (isQualityAboveZero(item))
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
                        if (isSellInLessThanEleven(item))
                        {
                            if (isQualityAboveFifty(item))
                            {
                                increaseQuality(item);
                            }
                        }

                        if (isSellInLessThanSix(item))
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

            if (isSellInUnderZero(item))
            {
                if (!"Aged Brie".equals(item.getName()))
                {
                    if (!"Backstage passes to a TAFKAL80ETC concert".equals(item.getName()))
                    {
                        if (isQualityAboveZero(item))
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
}

