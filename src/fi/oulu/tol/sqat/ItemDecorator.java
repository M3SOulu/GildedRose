package fi.oulu.tol.sqat;

public abstract class ItemDecorator {
	protected Item item;
	
	protected static final int MAX_QUALITY = 50;
	protected static final int MIN_QUALITY = 0;

	/* Generated getter and setter code */
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
	
	abstract void updateQuality();
}
