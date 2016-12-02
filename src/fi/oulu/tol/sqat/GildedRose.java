package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	public static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("OMGHAI!");

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		updateQuality();
	}

	private static void incrementQuality(int i){

		if(checkQualityMoreThan50(items.get(i).getQuality()))

			items.get(i).setQuality(items.get(i).getQuality() + 1);

	}

	private static void decrementQuality(int i){

		if(items.get(i).getQuality() - 1 >= 0 ){

			items.get(i).setQuality(items.get(i).getQuality() - 1);

			if(items.get(i).getSellIn() <= 0 && items.get(i).getQuality() - 1 >= 0)

				items.get(i).setQuality(items.get(i).getQuality() - 1);
		}
	}

	private static void decrementSellIn(int i){

		items.get(i).setSellIn(items.get(i).getSellIn() - 1);
	}
	
	private static void setUpdateQaulityConjured(int i){
		
		decrementQuality(i);
		decrementQuality(i);
		
	}

	private static void setUpdateQaulityBackstage(int i){

		if (items.get(i).getSellIn() <= 0)
			{
				items.get(i).setQuality(0);
			}

			else if (items.get(i).getSellIn() < 6)
			{

				incrementQuality(i);
				incrementQuality(i);
				incrementQuality(i);
			}
			
			else if(items.get(i).getSellIn() < 11)
			{   
				incrementQuality(i);
				incrementQuality(i);
			}

			else{

				incrementQuality(i);
			}
		}


	

	private static void setUpdateQaulityAgedBrie(int i){

		incrementQuality(i);

		if(items.get(i).getSellIn() < 0)

			incrementQuality(i);
		}


	private static boolean checkQualityMoreThan50(int quality){
		return (quality < 50) ? true : false;

	}
	
	public static void updateQuality()
	{
		for (int i = 0; i < items.size(); i++)
		{
			if ((!"Conjured".equals(items.get(i).getName())) &&(!"Aged Brie".equals(items.get(i).getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()) && !"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) 
			{
				decrementQuality(i);

			}


			else if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName()))
			{
				setUpdateQaulityBackstage(i);

			}
			
			else if("Aged Brie".equals(items.get(i).getName()))
			{

				setUpdateQaulityAgedBrie(i);

			} 
			else if("Conjured".equals(items.get(i).getName()))
			{
				setUpdateQaulityConjured(i);
			}

			
			if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName()))
			{
				
				decrementSellIn(i);
			
			}


		}
	}

}
