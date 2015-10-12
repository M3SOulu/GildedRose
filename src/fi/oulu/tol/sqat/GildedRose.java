package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	private List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("OMGHAI!");
		System.out.println("OMGHAI!");

		List<Item> items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		new GildedRose(items, 1);
	}
	
	public GildedRose(List<Item> items, int qualityUpdateDays) {
		this.items = items;
		updateQuality(qualityUpdateDays);
	}

	public void updateQuality(int days) {
		while (days > 0) {
			System.out.println("Good morning Hero! Days left to survive: " + days);
			for (Item item : items) {

				System.out.println("Before update: Item is " + item.getName() + ". Sell date " + item.getSellIn()
						+ ". Quality " + item.getQuality());

				String name = item.getName();
				int quality = item.getQuality();
				int sellIn = item.getSellIn();

				if (item.getQuality() > 0 || item.getSellIn() > 0) {
					if (name.contains("Sulfuras")) {
					} else if (name.contains("Conjured") && quality > 0) {
						if (sellIn == 0) {
							item.setQuality(quality - 4);
						} else {
							item.setQuality(quality - 2);
							item.setSellIn(sellIn - 1);
						}
					} else if (name.contains("Backstage") && quality < 50) {
						if (sellIn <= 10 && sellIn > 5) {
							item.setQuality(quality + 2);
							item.setSellIn(sellIn - 1);
						} else if (sellIn <= 5 && sellIn > 0) {
							item.setQuality(quality + 3);
							item.setSellIn(sellIn - 1);
						} else if (sellIn == 0) {
							item.setQuality(0);
						} else {
							item.setQuality(quality + 1);
							item.setSellIn(sellIn - 1);
						}
					} else if (name.contains("Aged")) {
						if (quality < 50 && quality > 0) {
							item.setQuality(quality + 1);
							item.setSellIn(sellIn - 1);
						}
					} else {
						if (sellIn == 0 && quality > 0) {
							item.setQuality(quality - 2);
						} else {
							item.setQuality(quality - 1);
							item.setSellIn(sellIn - 1);
						}
					}
				}
				if (quality == 0 && sellIn > 0) {
					item.setSellIn(sellIn - 1);
				}

				System.out.println("After update: Item is " + item.getName() + ". Sell date " + item.getSellIn()
						+ ". Quality " + item.getQuality());
			}
			days = days - 1;
		}
	}
	
	public List<Item> getItems() {
		return this.items;
	}
	
	public Item getItemByName(String name) {
		for (Item item : items) {
			if (item.getName().contains(name)) {
				return item;
			}
		}
		return null;
	}
}
