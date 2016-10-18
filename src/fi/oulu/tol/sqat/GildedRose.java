package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
	
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
        for (int i = 0; i < items.size(); i++)
        {
            Item item = items.get(i);
			int quality = item.getQuality();
			String name = item.getName();
			int sellIn = item.getSellIn();
			
     		if (AGED_BRIE.equals(name)) {
       			if (Item.notMaxQuality(quality)){
       				item.increaseQuality(quality); }
       		}
			
	       	else if (BACKSTAGE.equals(name)){
       			if (item.getSellIn() < 11 && Item.notMaxQuality(quality)) {
           			item.increaseQuality(quality); }
           		else if (item.getSellIn() < 6 && Item.notMaxQuality(quality)) {
           			item.increaseQuality(quality); }
           		else if (Item.notMaxQuality(quality)){
           			item.increaseQuality(quality);
           		}
           	}
      
           	else if (!SULFURAS.equals(name)) {
           			if (quality > 0){
           				item.decreaseQuality(quality); }
            	}

         	if (!SULFURAS.equals(name)) {
        	        item.decreaseSellIn(sellIn);}

     	     	if (Item.isExpired(item)) {
            		if (AGED_BRIE.equals(name) && Item.notMaxQuality(quality)) {
            			item.increaseQuality(quality);
            		            	
               	else if (BACKSTAGE.equals(name)) {
               		item.setQuality(0); }
            	
               	else if (quality > 0 && !AGED_BRIE.equals(name) && !BACKSTAGE.equals(name)){
               			item.decreaseQuality(quality); }
                	}
                }
            
            }
        }
