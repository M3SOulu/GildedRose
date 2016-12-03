package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GildedRose {

	public static List<Item> items = null;
	
	private static final String[] SPECIAL_ITEM={"Normal","Aged Brie","Sulfuras","Backstage passes"," Conjured"};

	public GildedRose(){
		
		items= new ArrayList<Item>();
	}
	
	public static void updateQuality() {
		
		Iterator<Item> it=	items.iterator();
		
		while(it.hasNext()){
			
			Item item=it.next();
			
			String type=specialItemDetector(item);
			
			if(type.equals(SPECIAL_ITEM[0])){
				
				updateNormalItem(item);
		
			}else if(type.equals(SPECIAL_ITEM[1])){
				
				updateAgedBrieItem(item);
			}
			
			
		}
	}

/**
 * get the item type	
 * @param item not null
 * @return one value from SPECIAL_ITEM vector
 */
 static String specialItemDetector(Item item){
		
		String type="";
		
		int index=1;
		
		while(!item.getName().contains(SPECIAL_ITEM[index]) && index<SPECIAL_ITEM.length-1){
			
			index++;
		}
		
		if(index==SPECIAL_ITEM.length-1){
			
			type=SPECIAL_ITEM[0];
			
		}else{
			
			type=SPECIAL_ITEM[index];
			
		}
		return type;
	}
	
 	/**
 	 * update quality of an item
 	 * @param item not null
 	 * @param type , elements of SPECIAL_ITEM list of types
 	 */
	private static void updateNormalItem(Item item){
		
			item.setSellIn(item.getSellIn()-1);
		
			if(item.getSellIn()>=0){
				
				if(item.getQuality()>0)
					item.setQuality(item.getQuality()-1);
				
			}else{
				
				item.setQuality(item.getQuality()-2);
			}
			
			if(item.getQuality()<0)
				item.setQuality(0);
	}
	
	/**
	 * update quality of an Aged Brie item
	 * @param item
	 */
	private static void updateAgedBrieItem(Item item){
		
		item.setSellIn(item.getSellIn()-1);
		item.setQuality(item.getQuality()+1);
	}	

}
