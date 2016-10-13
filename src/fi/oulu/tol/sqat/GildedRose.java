package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;
	private static String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
	private static String BRIE = "Aged Brie";

	public List<Item> getItems() {
		return items;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}

	public GildedRose() {
		items = new ArrayList<Item>();
	}
	
	private static boolean isSellInLessThanSixDays(Item item) {
		return item.getSellIn() < 6;
	}

	private static boolean isSellInLessThanElevenDays(Item item) {
		return item.getSellIn() < 11;
	}

	private static boolean isSellInUnderZero(Item item) {
		return item.getSellIn() < 0;
	}

	private static boolean isQualityLessThanFifty(Item item) {
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

	private static void qualityWhenSellInLessThanSixDaysAndQualityUnderFifty(Item item) {
		if (isSellInLessThanSixDays(item))
		     if (isQualityLessThanFifty(item))
		         increaseQuality(item);
	}

	private static void qualityWhenSellInLessThanElevenDaysAndQualityUnderFifty(Item item) {
		if (isSellInLessThanElevenDays(item))
		     if (isQualityLessThanFifty(item))
		         increaseQuality(item);
	}
	
    public static void updateEndOfDay()
    {
    	for(Item item:items)
        {
    		 if (BACKSTAGE.equals(item.getName()))
             {
    			 qualityWhenSellInLessThanElevenDaysAndQualityUnderFifty(item);
                 qualityWhenSellInLessThanSixDaysAndQualityUnderFifty(item);
             }
    		 
    		 
			if ((!BRIE.equals(item.getName())) && !BACKSTAGE.equals(item.getName())) 
            {
                if (isQualityAboveZero(item))
                {
                    if (!SULFURAS.equals(item.getName()))
                    {
                        decreaseQuality(item);
                    }
                }
            }
            else
            {
                if (isQualityLessThanFifty(item))
                {
                    increaseQuality(item);
                }
            }

            if (!SULFURAS.equals(item.getName()))
            {
                decreaseSellIn(item);
            }

            if (isSellInUnderZero(item))
            {
                if (!BRIE.equals(item.getName()))
                {
                    if (!BACKSTAGE.equals(item.getName()))
                    {
                        if (isQualityAboveZero(item))
                        {
                            if (!SULFURAS.equals(item.getName()))
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
                    if (isQualityLessThanFifty(item))
                    {
                        increaseQuality(item);
                    }
                }
            }
        }
    }
}

