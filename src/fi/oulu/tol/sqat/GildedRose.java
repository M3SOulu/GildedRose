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

	private static boolean isQualityLessThanFiftyOne(Item item) {
		return item.getQuality() < 50;
	}
	
	private static void qualityToZero(Item item) {
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

    public static void updateEndOfDay(){
    	for(Item item:items)
        {
    		if (BACKSTAGE.equals(item.getName()))
    			caseBackstagePass(item);
    		else if (BRIE.equals(item.getName()))
    			caseAgedBrie(item);
    		else if (SULFURAS.equals(item.getName()))
    			caseSulfuras(item);
    		else {
    			caseNormalItem(item);
    		}
        }
    }

	private static void caseBackstagePass(Item item) {
		if (isSellInLessThanSixDays(item) && isQualityLessThanFiftyOne(item))
			     increaseQuality(item);
	
		if (isSellInLessThanElevenDays(item) && isQualityLessThanFiftyOne(item))
			     increaseQuality(item);
		
		if (isQualityLessThanFiftyOne(item))
		     increaseQuality(item);
		decreaseSellIn(item);
		
		if (isSellInUnderZero(item))
			qualityToZero(item);
		}

	private static void caseNormalItem(Item item) {
		decreaseSellIn(item);
		if (isQualityLessThanFiftyOne(item))
            decreaseQuality(item);
		}

	private static void caseAgedBrie(Item item) {
		decreaseSellIn(item);
		
		if (isQualityLessThanFiftyOne(item))
			increaseQuality(item);
		
		if (isSellInUnderZero(item) && isQualityLessThanFiftyOne(item))
				increaseQuality(item);
		}
	
	private static void caseSulfuras(Item item) {
	}
}

