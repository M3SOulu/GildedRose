package fi.oulu.tol.sqat;

/**
 * an abstract class for Decorating items with a method for updating their quality
 * @author matias
 */
public abstract class ItemDecorator {
	//item to use
	protected Item item;
	
	//maximum and minimum quality
	protected static final int MAX_QUALITY = 50;
	protected static final int MIN_QUALITY = 0;
	
    public String getName() {
    	return item.getName();
	}
	public void setName(String name) {
		item.setName(name);
	}
	public int getSellIn() {
		return item.getSellIn();
	}
	public void setSellIn(int sellIn) {
		item.setSellIn(sellIn);
	}
	public int getQuality() {
		return item.getQuality();
	}
	public void setQuality(int quality) {
		item.setQuality(quality);
	}
	
	/*
	 * helper methods for safely updating quality
	 */
	public void decreaseQuality() {
		if (item.getQuality() > MIN_QUALITY) {
			item.setQuality(item.getQuality() - 1);
		}
	}
	
	public void increaseQuality() {
		if (item.getQuality() < MAX_QUALITY) {
			item.setQuality(item.getQuality() + 1);
		}
	}
	
	/*
	 * each individual item type overrides this
	 */
	abstract void updateQuality();
}
