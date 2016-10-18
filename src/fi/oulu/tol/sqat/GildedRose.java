package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";
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
        	updateItem(item); 
        }
    }

	private static void updateItem(Item item) {
		switch(item.getName()) 
		{
			case AGED_BRIE:
		 		updateSpecialProductQuality(item);
		 		decreaseProductSellIn(item);
		 		break;
		 	case BACKSTAGE_PASSES:
		 		updateSpecialProductQuality(item);
		 		decreaseProductSellIn(item);
		 		break;
		 	case SULFURAS:
		 		break;
		 	default:
		 		item.decreaseQuality();
		 		decreaseProductSellIn(item);
		 		break;
		 }
	}

	private static boolean itemNameEquals(Item item, String string) {
		return string.equals(item.getName());
	}

	private static void decreaseProductSellIn(Item item) {
		
		item.decreaseSellIn();
	}

	private static void updateSpecialProductQuality(Item item) {
	    item.increaseQuality();
	    if (itemNameEquals(item, BACKSTAGE_PASSES))
	    {
	        backstagePassesUpdate(item);
	    }
	    if(item.isExpired()) {
	    	switch(item.getName()) {
				case AGED_BRIE:
					 item.increaseQuality();
					 break;
				case BACKSTAGE_PASSES: 
					 item.setQuality(0);
					 break;
				default:
					break;
	    	}
	    }
	}

	private static void backstagePassesUpdate(Item item) {
		if (item.getSellIn() < 11)
		{
			item.increaseQuality();
		}

		if (item.getSellIn() < 6)
		{
			item.increaseQuality();
		}
	}  
}
