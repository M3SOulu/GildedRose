package fi.oulu.tol.sqat;


public class Item {
    String name;
    int sellIn;
    int quality;

    public Item(String name, int sellIn, int quality) {
		this.setName(name);
		this.setSellIn(sellIn);
		this.setQuality(quality);
	}

	/* Generated getter and setter code */
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSellIn() {
		return sellIn;
	}
	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}

	/**
	 * Increase quality by one, max is 50.
	 */
	public void increaseQuality() {
		if (this.quality < 50) {
			this.setQuality(++this.quality);
		}
	}

	/**
	 * Decrease quality by one, min is 0.
	 */
	public void decreaseQuality() {
		if (this.quality > 0) {
			this.setQuality(--this.quality);
		}
	}

	/**
	 * Decrease sell-in value by one.
	 */
	public void decreaseSellIn() {
		this.setSellIn(--this.sellIn);
	}
}

