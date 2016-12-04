package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GildedRose {

	public static List<Item> items = null;
	
	private static final String[] SPECIAL_ITEM={"Normal","Aged Brie","Sulfuras","Backstage passes","Conjured"};

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
			
			//SPECIAL_ITEM[2]="Sulfuras" nothing happen
			}else if(type.equals(SPECIAL_ITEM[3])){
				
				updateBackStageItem(item);
				
			}else if(type.equals(SPECIAL_ITEM[4])){
				
				updateConjuredItem(item);
			}
			
			
		}
	}

/**
 * get the item type	
 * @param item not null
 * @return one value from SPECIAL_ITEM vector
 */
 static String specialItemDetector(Item item){
		
		String type=SPECIAL_ITEM[0];
		
		for(int i=0;i<SPECIAL_ITEM.length;i++){
			
			if(item.getName().contains(SPECIAL_ITEM[i])){
				
				type=SPECIAL_ITEM[i];
				break;
			}
				
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
		
		if(item.getQuality()<50){
			
			item.setQuality(item.getQuality()+1);
		}
		

	}
	
	/**
	 * update quality of a Backstage item
	 * @param item
	 */
	private static void updateBackStageItem(Item item){
		
		item.setSellIn(item.getSellIn()-1);
		
		if(item.getSellIn()<=0){
			
			item.setQuality(0);		
			
		}else if(item.getSellIn()<=5){
			
			item.setQuality(item.getQuality()+3);
			
		}else if(item.getSellIn()<=10){
			
			item.setQuality(item.getQuality()+2);
			
		}else{
			
			item.setQuality(item.getQuality()+1);
		}
		
		if(item.getQuality()>50)
			item.setQuality(50);
			
		
	}
	
	private static void updateConjuredItem(Item item){
		
		item.setSellIn(item.getSellIn()-1);
		
		if(item.getSellIn()>=0){
			
			if(item.getQuality()>0)
				item.setQuality(item.getQuality()-2);
			
		}else{
			
			item.setQuality(item.getQuality()-4);
		}
		
		if(item.getQuality()<0)
			item.setQuality(0);
	}

}
