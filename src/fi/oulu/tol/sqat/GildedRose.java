package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	private static List<ItemDecorator> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("OMGHAI!");

		items = new ArrayList<ItemDecorator>();
		items.add(new NormalItemDecorator("+5 Dexterity Vest", 10, 20));
		items.add(new BrieDecorator(2,0));
		items.add(new NormalItemDecorator("Elixir of the Mongoose",5,7));
		items.add(new SulfurasDecorator(0,80));
		items.add(new BackstageDecorator(15,20));
		items.add(new ConjuredDecorator(3,6));
		
		updateQuality();

		for (ItemDecorator item : items) {
			System.out.println(item.getName() + "\t" + item.getSellIn() + "\t"
					+ item.getQuality());
		}
	}

	public static void updateQuality() {
		for (ItemDecorator item : items) {
			updateItem(item);
		}
	}

	public static void updateItem(ItemDecorator item) {
		item.updateQuality();
	}
}
