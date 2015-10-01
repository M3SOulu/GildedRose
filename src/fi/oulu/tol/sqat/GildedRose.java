package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;



public class GildedRose {

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        items = new ArrayList<Item>();
        
        //name, sellIn, quality;
        
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();
        /*
        for(int i = 0; i < items.size(); i++){
        	
        	System.out.println("Name: " + items.get(i).getName());
        	System.out.println("SellIn: " + items.get(i).getSellIn());
        	System.out.println("Quality: " + items.get(i).getQuality());
        	System.out.println("**************\n");
        }*/
        
        
        for(Item item: items)
        {	
        	System.out.println(item.getName()+"\t"+item.getSellIn()+"\t"+item.getQuality());
        }
}


	
    public static void updateQuality()
    {
    	/*
        for (int i = 0; i < items.size(); i++)
        {
            Item item = items.get(i);
			updateItem(item);
        }*/
    	for (Item item : items)
        {
    		updateItem(item);
        }
    	
    }
    
    public static void updateItem(Item item) {
    			
    			if ("Sulfuras, Hand of Ragnaros".equals(item.getName())){
    	           return;
    	        }
    			
    			if ("Aged Brie".equals(item.getName() )) {
    				
    			    updateBrie(item);
    			}
    			else if("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())){
    				
    				updateBackStageItem(item);
    			}
    			else if("Conjured Mana Cake".equals(item.getName())){
    				updateConjured(item);
    				
    			}
    			else {
    				updateNormalItem(item);
    			}
    	
    				
    }
    
    private static void updateConjured(Item item) {
		item.setSellIn(item.getSellIn() -1);
		decreaseQuality(item);
		decreaseQuality(item);
		
		if(item.getSellIn() < 0 ){
			decreaseQuality(item);
			decreaseQuality(item);
		}
	}




private static void updateBackStageItem(Item item) {
	
	item.setSellIn(item.getSellIn() - 1);
	
	if(item.getSellIn() == 0){
		item.setQuality(0);
	}
	else{
	
		if (item.getSellIn() < 11)
		{
		    increaseQuality(item);
		}

		if (item.getSellIn() < 6)
		{
		    increaseQuality(item);
		    increaseQuality(item);
		}
		
		if(item.getSellIn() == 0){
			item.setQuality(0);
		}
	}
}



private static void updateBrie(Item item) {
	
	item.setSellIn(item.getSellIn() - 1);
	
	increaseQuality(item);
	if(item.getSellIn() < 0){
		increaseQuality(item);
	}
}

private static void updateNormalItem(Item item){
	
	item.setSellIn(item.getSellIn() -1);
	decreaseQuality(item);
	
	if(item.getSellIn() < 0){
		decreaseQuality(item);
	}
}


private static void decreaseQuality(Item item) {
	if (item.getQuality() > 0)
	{
		item.setQuality(item.getQuality() - 1); //update a normal item's quality
	}
}





private static void increaseQuality(Item item) {
	if (item.getQuality() < 50)
	{
	    item.setQuality(item.getQuality() + 1);

	}
}
    
    
    



	
}
