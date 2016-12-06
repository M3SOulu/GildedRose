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

	public static void updateQuality() {
		for (int i = 0; i < items.size(); i++) {

			if (!(items.get(i) instanceof ConjuredItem)) {
				
				if ((!"Aged Brie".equals(items.get(i).getName()))
						&& !"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
					if (items.get(i).getQuality() > 0) {
						if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
							// Decrementa qualit� di 1 se non si tratta di aged
							// brie o backstage, se la qualit� � >0 e se non si
							// tratta di sulfuras
							items.get(i).setQuality(items.get(i).getQuality() - 1);
						}
					}
				} else // Se � uno tra brie e backstage passes...
				{
					// ...se la qualit� � minore di 50...
					if (items.get(i).getQuality() < 50) {
						// ...incrementa la qualit�.
						items.get(i).setQuality(items.get(i).getQuality() + 1);

						// Se si tratta di backstage...
						if ("Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
							// ...incrementa ancora la qualit� se mancano meno
							// di 11 giorni...
							if (items.get(i).getSellIn() < 11) {
								if (items.get(i).getQuality() < 50) {
									items.get(i).setQuality(items.get(i).getQuality() + 1);
								}
							}

							// ...e ancora se mancano meno di 6 giorni.
							if (items.get(i).getSellIn() < 6) {
								if (items.get(i).getQuality() < 50) {
									items.get(i).setQuality(items.get(i).getQuality() + 1);
								}
							}
						}
					}
				}
				// Decremento del sellin di qualsiasi item che non sia sulfuras
				if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
					items.get(i).setSellIn(items.get(i).getSellIn() - 1);
				}
				if (items.get(i).getSellIn() < 0) {
					if (!"Aged Brie".equals(items.get(i).getName())) {
						if (!"Backstage passes to a TAFKAL80ETC concert".equals(items.get(i).getName())) {
							if (items.get(i).getQuality() > 0) {
								if (!"Sulfuras, Hand of Ragnaros".equals(items.get(i).getName())) {
									// Se il prodotto � scaduto e non si tratta
									// n� di brie, n� di backstage,n� di
									// sulfuras, decrementa ancora la qualit�
									items.get(i).setQuality(items.get(i).getQuality() - 1);
								}
							}
						} else {
							items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
						}
					} else {
						if (items.get(i).getQuality() < 50) {
							items.get(i).setQuality(items.get(i).getQuality() + 1);
						}
					}
				}
			} else {
				((ConjuredItem) items.get(i)).updateQuality();
			}
		}
	}

}
