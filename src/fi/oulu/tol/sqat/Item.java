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
		if (!hasReachedMaximumQuality())
			++this.quality;
	}

	public void decreaseQuality() {
		if (!hasZeroQuality())
			--this.quality;
	}

	public boolean isExpired() {
		return getSellIn() < 0;
	}

	public void update() {
		// This could be used to derive classes but
		// I try to keep the implementation and file management
		// as simple as possible for now.
		switch (getName()) {
		case AGED_BRIE:
			handleAgedBrie();
			break;
		case BACKSTAGE_PASSES:
			handleBackstagePasses();
			break;
		case SULFURAS:
			handleSulfuras();
			break;
		default:
			handleDefault();
		}
	}

	private void handleAgedBrie() {
		decreaseSellIn();
		increaseQuality();
		
		if (isExpired()) {
        	increaseQuality();
		}
	}

	private void handleBackstagePasses() {
		increaseQuality();
		
        if (getSellIn() < 11) {
        	increaseQuality();
        }

        if (getSellIn() < 6) {
        	increaseQuality();
        }
        
        decreaseSellIn();
        
        if (isExpired()) {
        	resetQuality();
        }
	}

	private void handleSulfuras() {
		increaseQuality();
	}

	private void handleDefault() {
		decreaseSellIn();
		decreaseQuality();
        
        if (isExpired()) {
        	decreaseQuality();
        }
	}
}

