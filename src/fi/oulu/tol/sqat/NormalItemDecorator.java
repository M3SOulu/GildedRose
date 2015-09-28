package fi.oulu.tol.sqat;

public class NormalItemDecorator extends ItemDecorator {

	public NormalItemDecorator(String name,int sellIn, int quality) {
		this.item = new Item(name, sellIn, quality);
	}

	@Override
	void updateQuality() {
		//quality can't be < 0
		item.setSellIn((item.getSellIn()-1));
		decreaseQuality();
		if (item.getSellIn() < 0)
		{
			decreaseQuality();
		}
	}
}
