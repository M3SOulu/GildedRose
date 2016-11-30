package fi.oulu.tol.sqat;

/**
 * ItemDecorator implementstion for Backstage pass items
 * @author matias
 */
public class BackstageDecorator extends ItemDecorator {
	public static final String ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";

	public BackstageDecorator(int sellIn, int quality) {
		this.item = new Item(ITEM_NAME, sellIn, quality);
	}

	@Override
	void updateQuality() {
		item.setSellIn((item.getSellIn() - 1));
		increaseQuality();

		if (item.getSellIn() < 10) {
			increaseQuality();
		}

		if (item.getSellIn() < 5) {
			increaseQuality();
		}

		if (item.getSellIn() < 0) {
			item.setQuality(0);
		}
	}
}
