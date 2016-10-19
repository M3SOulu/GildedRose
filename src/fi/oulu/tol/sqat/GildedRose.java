package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	private static final String AGEDBRIE = "Aged Brie";
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String BSTAGEPASS = "Backstage passes to a TAFKAL80ETC concert";
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

       
}
	
	
	
	public void updateEndOfDay() 
    {
        for (Item item : items)
        {
        	String itemName = item.getName();

        	System.out.println(item.getQuality());
        	
        	if (itemName.equals(SULFURAS)){
        		return;
        	}
        	
        	
        	int itemSellIn = item.getSellIn();
        	
            if ((itemName.equals(AGEDBRIE)) || itemName.equals(BSTAGEPASS)) 
            {
            	increaseQuality(item);
            	System.out.println(item.getQuality());

            }

            if (itemName.equals(BSTAGEPASS))
            {
            	System.out.println(itemName + "GETS " + item.getQuality());
                if (itemSellIn <= 10)
                {
                	 
                   item.increaseQuality();
                }

                if (itemSellIn <= 5)
                {
                   item.increaseQuality();
                }
                
        		item.increaseQuality();
            }

            if (!itemName.equals(AGEDBRIE))
            {
            	item.decreaseQuality();
            }
            
            
            if (itemSellIn <= 0)
            {
                if (AGEDBRIE.equals(itemName))
                {
                    increaseQuality(item);
                    
                }
                else
                {
                    if (BSTAGEPASS.equals(itemName))
                    {
                    	
                    	item.setQuality(0);
                    	
                    }
                    else
                    {
                    	
                        if (!hasNoQuality(item))
                        {
                        	
                           item.decreaseQuality();
                        }
                    	
                    }
                }
            }
            item.decreaseSellIn();

        }
    }


	public void increaseQuality(Item item){
		
	        if (!hasMaxQuality(item))
	        {
	            item.increaseQuality();
	        }


	}


	public static boolean hasNoQuality(Item item) {

			return item.getQuality() == 0;
	}
	
	public static boolean hasMaxQuality(Item item) {
		return item.getQuality() == 50;
}

 	public void addItem(Item item) {
 		items = new ArrayList<Item>();
		items.add(item);
	}
 	
 	public List<Item> getItems() {
 		return items;
 	}
 	

}
