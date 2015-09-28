package fi.oulu.tol.sqat;


public class BrieDecorator extends ItemDecorator {
	public static final String ITEM_NAME = "Aged Brie";
	
	public BrieDecorator(int sellIn,int quality) {
		this.item = new Item(ITEM_NAME,sellIn,quality);
	}
	
	@Override
	void updateQuality() {
		item.setSellIn((item.getSellIn() - 1));
		increaseQuality();
	}

}
