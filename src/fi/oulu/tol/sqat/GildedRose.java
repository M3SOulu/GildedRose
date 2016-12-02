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

	/*
	 * Incrementa la qualità di 1 se questa è minore di 50
	 */
	private static void incrementQuality(int i){

		if(checkQualityMoreThan50(items.get(i).getQuality()))

			items.get(i).setQuality(items.get(i).getQuality() + 1);

	}
	
	/*
	 * Decrementa la qualità di 1 se questa decementandola la qualità non scende al d sotto 
	 * del valore 0.
	 * Decrementa la qualità di 2, non facendola scendere mai al di sotto di 0 se il valore SellIn è uguale a 0.
	 */
	private static void decrementQuality(int i){

		if(items.get(i).getQuality() - 1 >= 0 ){

			items.get(i).setQuality(items.get(i).getQuality() - 1);

			if(items.get(i).getSellIn() <= 0 && items.get(i).getQuality() - 1 >= 0)

				items.get(i).setQuality(items.get(i).getQuality() - 1);
		}
	}
	
	/*
	 * Decrementa il valore SellIn di 1
	 */
	private static void decrementSellIn(int i){

		items.get(i).setSellIn(items.get(i).getSellIn() - 1);
	}

	/*
	 * Aggiorna la qualità dell'item "Conjured."
	 * La qualità di quest'Item decrementa 2 volte più velocemente rispetto agli altri Item.
	 */
	private static void setUpdateQaulityConjured(int i){

		decrementQuality(i);
		decrementQuality(i);

	}
	
	/*
	 * Aggiorna la qualità dell'Item BackStage.
	 * La qualità di quest'Item viene impostata a 0 se il valore SellIn è minore o uguale a 0,
	 * viene incrementata di 2 se il valore SellIn è minore di 6,
	 * viene incrementata di 3 se il valore SellIn è minore di 11,
	 * viene incrementata di 1 in tutti gli altri casi.
	 */
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



	/*
	 * Aggiorna la qualità dell'Item "Aged Brie"
	 * La qualità di quest'Item viene incrementata di 1 se il valore SellIn è maggiore o uguale a 0,
	 * viene incrementata di 2 negli altri casi.
	 * 
	 * 
	 */
	private static void setUpdateQaulityAgedBrie(int i){

		incrementQuality(i);

		if(items.get(i).getSellIn() < 0)

			incrementQuality(i);
	}

	/*
	 * Controlla se la qualità di un oggetto è minore di 50 o meno,
	 * restituisce true se è minore di 50, false in tutti gli altri casi.
	 */
	private static boolean checkQualityMoreThan50(int quality){
		return (quality < 50) ? true : false;

	}
	/**
	 * Aggiorna la qualità di una lista di Item. 
	 * La qualità viene decrementata di un'unità ad ogni chiamata di questa funzione per gli Item
	 * diversi da "Aged Brie", "Conjured", "Backstage" e Sulfuras.
	 * Per l'Item "Aged Brie" la qualità viene incrementata di 1 se il valore SellIn è maggiore o uguale a 0,
	 * viene incrementata di 2 negli altri casi.
	 * Per l'Item "Conjured" la qualità viene decrementata di 2.
	 * Per l'Item "Backstage" la qualità viene impostata a 0 se il valore SellIn è minore o uguale a 0,
	 * viene incrementata di 2 se il valore SellIn è minore di 6,
	 * viene incrementata di 3 se il valore SellIn è minore di 11,
	 * viene incrementata di 1 in tutti gli altri casi.
	 * Per l'Item "Sulfuras" la qualità rimane tale.
	 * Per tutti gli Item il valore SellIn viene decrementato di 1 ad ogni chiamata ad eccezzione dell'Item
	 * "Sulfuras" che rimane tale.
	 * La qualità sarà sempre compresa tra 0 e 50 inclusi.
	 */
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
