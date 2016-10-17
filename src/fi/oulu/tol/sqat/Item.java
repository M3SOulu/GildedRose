package fi.oulu.tol.sqat;

public class Item {
	String name;

	int sellIn;
	int quality;

	public static final String AGED_BRIE = "Aged Brie";
	public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

	public Item(String name, int sellIn, int quality) {
		this.setName(name);
		this.setSellIn(sellIn);
		this.setQuality(quality);
	}

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

	public void increaseSellIn() {
		++this.sellIn;
	}

	public void decreaseSellIn() {
		--this.sellIn;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public void resetQuality() {
		this.quality = 0;
	}

	public boolean hasZeroQuality() {
		return this.quality == 0;
	}

	public boolean hasReachedMaximumQuality(){
		return this.quality >= 50;
	}

	public void increaseQuality() {
		if (!hasReachedMaximumQuality()) ++this.quality;
	}

	public void decreaseQuality() {
		if (!hasZeroQuality()) --this.quality;
	}

	public boolean isExpired() {
		return getSellIn() < 0;
	}

	public void update() {
		// This could be used to derive classes but
		// I try to keep the implementation and file management
		// as simple as possible for now.
		switch (getName()) {
		case AGED_BRIE:        handleAgedBrie();        break;
		case BACKSTAGE_PASSES: handleBackstagePasses(); break;
		case SULFURAS:         handleSulfuras();        break;
		default:               handleDefault();
		}
	}

	private void handleAgedBrie() {
		decreaseSellIn();  // Aged Brie increases in quality
		increaseQuality(); // the older it gets
		
		// x2 Quality increase when expired (not sure if this is
		// correct behavior (?)).
		if (isExpired()) increaseQuality();
	}

	private void handleBackstagePasses() {
		decreaseSellIn();  // Backstage passes increase in quality
		increaseQuality(); // as the SellIn value approaches 0 by default
		
		// x2 Quality increase
		if (getSellIn() < 10) increaseQuality();
		
		// x3 Quality increase
		if (getSellIn() < 5) increaseQuality();
		
		// No more parties, reset quality to zero
		if (isExpired()) resetQuality();
	}

	private void handleSulfuras() {
		// Legendary item, quality is a constant (80) and it
		// is never sold
	}

	private void handleDefault() {
		decreaseSellIn();  // Normal items decrease in quality
		decreaseQuality(); // the older they get
		
		// x2 Quality loss when expired
		if (isExpired()) decreaseQuality();
	}
}
