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
	
    public static void updateEndOfDay() {
        for (Item item : items) {
            if (item.developsNormally()) { 
        		if (!item.hasZeroQuality()) {
                    if (item.decaysNormally()){
                    	item.decreaseQuality(); 
                    }
                }            	
            } else {
                if (!item.hasReachedMaximumQuality() && item.decaysNormally()) {
                    item.increaseQuality();                            
                    if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {                    
                        if (item.getSellIn() < 11 && !item.hasReachedMaximumQuality()) {
                                item.increaseQuality();      
                                if (item.getSellIn() < 6 && !item.hasReachedMaximumQuality()) {                                                  
                                	item.increaseQuality();                            
                                }                                                         
                        }           
                   }
               }
            }
            item.decreaseSellin();

            if (item.isExpired()) {
                if (!"Aged Brie".equals(item.getName())) {                  
                        if (!item.hasZeroQuality()) {
                            item.decreaseQuality();
                        }
                     if("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                        item.setQuality(0);
                    }
                } else {
                    if (!item.hasReachedMaximumQuality()) {
                        item.increaseQuality();
                    }
                }
            }
        }
    }
        
}
    


    


            
            
            
        
        
                
           
    


    
