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
	 * Incrementa la qualit� di 1 se questa � minore di 50
	 */
	private static void incrementQuality(int i){

		if(checkQualityMoreThan50(items.get(i).getQuality()))

			items.get(i).setQuality(items.get(i).getQuality() + 1);

	}
	
	/*
	 * Decrementa la qualit� di 1 se questa decementandola la qualit� non scende al d sotto 
	 * del valore 0.
	 * Decrementa la qualit� di 2, non facendola scendere mai al di sotto di 0 se il valore SellIn � uguale a 0.
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
	 * Aggiorna la qualit� dell'item "Conjured."
	 * La qualit� di quest'Item decrementa 2 volte pi� velocemente rispetto agli altri Item.
	 */
	private static void setUpdateQaulityConjured(int i){

		decrementQuality(i);
		decrementQuality(i);

	}
	
	/*
	 * Aggiorna la qualit� dell'Item BackStage.
	 * La qualit� di quest'Item viene impostata a 0 se il valore SellIn � minore o uguale a 0,
	 * viene incrementata di 2 se il valore SellIn � minore di 6,
	 * viene incrementata di 3 se il valore SellIn � minore di 11,
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
	 * Aggiorna la qualit� dell'Item "Aged Brie"
	 * La qualit� di quest'Item viene incrementata di 1 se il valore SellIn � maggiore o uguale a 0,
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
	 * Controlla se la qualit� di un oggetto � minore di 50 o meno,
	 * restituisce true se � minore di 50, false in tutti gli altri casi.
	 */
	private static boolean checkQualityMoreThan50(int quality){
		return (quality < 50) ? true : false;

	}
	/**
	 * Aggiorna la qualit� di una lista di Item. 
	 * La qualit� viene decrementata di un'unit� ad ogni chiamata di questa funzione per gli Item
	 * diversi da "Aged Brie", "Conjured", "Backstage" e Sulfuras.
	 * Per l'Item "Aged Brie" la qualit� viene incrementata di 1 se il valore SellIn � maggiore o uguale a 0,
	 * viene incrementata di 2 negli altri casi.
	 * Per l'Item "Conjured" la qualit� viene decrementata di 2.
	 * Per l'Item "Backstage" la qualit� viene impostata a 0 se il valore SellIn � minore o uguale a 0,
	 * viene incrementata di 2 se il valore SellIn � minore di 6,
	 * viene incrementata di 3 se il valore SellIn � minore di 11,
	 * viene incrementata di 1 in tutti gli altri casi.
	 * Per l'Item "Sulfuras" la qualit� rimane tale.
	 * Per tutti gli Item il valore SellIn viene decrementato di 1 ad ogni chiamata ad eccezzione dell'Item
	 * "Sulfuras" che rimane tale.
	 * La qualit� sar� sempre compresa tra 0 e 50 inclusi.
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
