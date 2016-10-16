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
		++this.quality;
	}
	
	public void decreaseQuality() {
		--this.quality;
	}
	
	public boolean isExpired() {
		return getSellIn() < 0;
	}
	
	public void update() {
        if ((!AGED_BRIE.equals(getName())) &&
        		!BACKSTAGE_PASSES.equals(getName())) {
            if (!hasZeroQuality()) {
                if (!SULFURAS.equals(getName())) {
                	decreaseQuality();
                }
            }
        } else if (!hasReachedMaximumQuality()) {
        	increaseQuality();
        }

        if (BACKSTAGE_PASSES.equals(getName())) {
            if (getSellIn() < 11 && !hasReachedMaximumQuality()) {
            	increaseQuality();
            }

            if (getSellIn() < 6 && !hasReachedMaximumQuality()) {
            	increaseQuality();
            }
        }
        
        if (!SULFURAS.equals(getName())) {
        	decreaseSellIn();
        }

        if (isExpired()) {
            if (AGED_BRIE.equals(getName())) {
                if (!hasReachedMaximumQuality()) {
                	increaseQuality();
                }
            } else {
                if (BACKSTAGE_PASSES.equals(getName())) {
                	resetQuality();
                } else {
                    if (!hasZeroQuality()) {
                        if (!SULFURAS.equals(getName())) {
                        	decreaseQuality();
                        }
                    }
                }
            }
        }
	}
}

