package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {
	public List<Item> items = null;
	private static List<String> specialItems;

	private static final String LEGENDARY_ITEM = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_ITEM = "Backstage passes to a TAFKAL80ETC concert";
	private static final String BRIE_ITEM = "Aged Brie";
	private static final String CONJURED_ITEM = "Conjured Mana Cake";

	private static final int QUALITY_MAX = 50;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("OMGHAI!");

		GildedRose gr = new GildedRose();	
		gr.add(new Item("+5 Dexterity Vest", 10, 20));
		gr.add(new Item("Aged Brie", 2, 0));
		gr.add(new Item("Elixir of the Mongoose", 5, 7));
		gr.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		gr.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		gr.add(new Item("Conjured Mana Cake", 3, 6));

		gr.updateQuality();
	}

	public GildedRose(){
		items = new ArrayList<Item>();

		specialItems = new ArrayList<>();
		specialItems.add( LEGENDARY_ITEM );
		specialItems.add( BACKSTAGE_ITEM );
		specialItems.add( BRIE_ITEM );
		specialItems.add( CONJURED_ITEM );
	}

	public void add( Item item ){
		items.add( item );
	}

	public Item get( int index ){
		return items.get( index );
	}

	/**
	 * increment of 1 item quality n times
	 * @param item
	 * @param n
	 */
	private void incrementQuality( Item item, int n )
	{
		for( int i = 0; i < n; i++ ){
			if( item.getQuality() < QUALITY_MAX )
				item.setQuality( item.getQuality() + 1 );
		}
	}

	/**
	 * decrement of 1 item quality n times
	 * @param item
	 * @param n
	 */
	private void decrementQuality( Item item, int n )
	{
		for( int i = 0; i < n; i++ ){
			if( item.getQuality() > 0 )
				item.setQuality( item.getQuality() - 1 );
		}
	}

	/**
	 * decrement of 1 sellIn
	 * @param item
	 */
	private void decrementSellIn( Item item ){
		if (! item.getName().equals( LEGENDARY_ITEM ) )
			item.setSellIn( item.getSellIn() - 1 );
	}

	/**
	 * 
	 * @param item
	 * @return true if item is a "special" item
	 */
	private boolean isSpecialItem( Item item ){
		if( specialItems.contains( item.getName() ) )
			return true;
		else
			return false;
	}

	/**
	 * increment quality of Backstage passes item
	 * @param backstageItem
	 */
	private void incrementBackstageItemQuality( Item backstageItem ){
		if( backstageItem.getSellIn() >= 11 ){
			incrementQuality(backstageItem, 1);
		}
		else if (backstageItem.getSellIn() < 11 && backstageItem.getSellIn() >= 6)
		{
			incrementQuality(backstageItem, 2);
		}
		else if (backstageItem.getSellIn() < 6 && backstageItem.getSellIn() >= 0)
		{
			incrementQuality(backstageItem, 3);
		}
		else{
			backstageItem.setQuality( 0 );
		}
	}

	/**
	 * increment quality of Aged Brie item
	 * @param item
	 */
	private void incrementAgedBrieItemQuality( Item item ){
		if( item.getSellIn() < 0 ){
			incrementQuality( item, 2 );
		}
		else{
			incrementQuality( item, 1 );
		}
	}

	/**
	 * decrement quality of not special item
	 * @param item
	 */
	private void decrementNormalItemQuality( Item item ){
		if( item.getSellIn() > 0 ){
			decrementQuality( item, 1 );
		}
		else{
			decrementQuality( item, 2 );
		}
	}

	/**
	 * decrement quality of Conjured item
	 * Conjured items degrade in Quality twice as fast as normal items.
	 * @param item
	 */
	private void decrementConjuredItemQuality( Item item ){
		if( item.getSellIn() > 0 ){
			decrementQuality( item, 2 );
		}
		else{
			decrementQuality( item, 4 );
		}
	}

	/**
	 * update quality of all items
	 * @param item
	 */
	private void updateQualityItem( Item item ){
		if ( ! isSpecialItem( item ) ) {
			decrementNormalItemQuality( item );
		}
		else if( item.getName().equals( BACKSTAGE_ITEM ) ){
			incrementBackstageItemQuality( item );
		}
		else if( item.getName().equals( BRIE_ITEM ) ){
			incrementAgedBrieItemQuality( item );
		}
		else if( item.getName().equals( CONJURED_ITEM ) ){
			decrementConjuredItemQuality( item );
		}
		else{
			incrementQuality(item, 1);
		}
	}

	/**
	 * update quality items at the end of each day
	 */
	public void updateQuality()
	{
		for (Item item : items)
		{		
			decrementSellIn( item );
			updateQualityItem( item );
		}
	}

}
