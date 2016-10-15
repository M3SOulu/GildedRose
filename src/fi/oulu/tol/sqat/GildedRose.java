package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
	public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	public static final String BRIE = "Aged Brie";
	
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
        	item.updateQuality();
            item.updateSellIn();
            item.ensureBounds();
        }
    }
}
