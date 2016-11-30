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
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		for (Item i : items)
			System.out.println(i.getName() + ", " + i.getSellIn() + ", "
					+ i.getQuality());
		System.out.println();

		updateQuality();

		for (Item i : items)
			System.out.println(i.getName() + ", " + i.getSellIn() + ", "
					+ i.getQuality());
		System.out.println();

	}

	public static void updateQuality() {
		for (int i = 0; i < items.size(); i++) {
			updateItem(items.get(i));
		}
	}

	public static void updateItem(Item item) {
		if (item.getName().equals("Sulfuras, Hand of Ragnaros"))
			return;

		item.setSellIn(item.getSellIn() - 1);

		if (item.getName().equals("Aged Brie") && item.getQuality() < 50) {
			item.setQuality(item.getQuality() + 1);
			return;
		}

		if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
			if (item.getQuality() < 50) {
				item.setQuality(item.getQuality() + 1);
			}

			if (item.getSellIn() < 11 && item.getQuality() < 50) {
				item.setQuality(item.getQuality() + 1);
			}

			if (item.getSellIn() < 6 && item.getQuality() < 50) {
				item.setQuality(item.getQuality() + 1);
			}

			if (item.getSellIn() < 0) {
				item.setQuality(0);
			}

			return;
		}

		if (item.getName().length() >= 8
				&& item.getName().substring(0, 8).equals("Conjured")) {
			if (item.getQuality() > 0) {
				item.setQuality(item.getQuality() - 1);
			}

			if (item.getQuality() > 0) {
				item.setQuality(item.getQuality() - 1);
			}

			if (item.getSellIn() < 0) {
				if (item.getQuality() > 0) {
					item.setQuality(item.getQuality() - 1);
				}

				if (item.getQuality() > 0) {
					item.setQuality(item.getQuality() - 1);
				}
			}

			return;
		}

		if (item.getQuality() > 0) {
			item.setQuality(item.getQuality() - 1);

			if (item.getSellIn() < 0 && item.getQuality() > 0) {
				item.setQuality(item.getQuality() - 1);
			}
		}

	}

}