package fi.oulu.tol.sqat;

public class SulfurasDecorator extends ItemDecorator {
	public static final String ITEM_NAME = "Sulfuras, Hand of Ragnaros";
	
	public SulfurasDecorator(int sellIn,int quality) {
		this.item = new Item(ITEM_NAME,sellIn,quality);
	}
	
	@Override
	void updateQuality() {
		return;
	}

}
