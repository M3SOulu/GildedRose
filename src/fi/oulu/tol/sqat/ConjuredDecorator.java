package fi.oulu.tol.sqat;

public class ConjuredDecorator extends ItemDecorator {
	public static final String ITEM_NAME = "Conjured Mana Cake";
	
	public ConjuredDecorator(int sellIn,int quality) {
		this.item = new Item(ITEM_NAME,sellIn,quality);
	}
	
	@Override
	void updateQuality() {
		item.setSellIn(item.getSellIn()-1);
		decreaseQuality();
		decreaseQuality();
		if(item.getSellIn() < 0) {
			decreaseQuality();
			decreaseQuality();
		}
	}

}
