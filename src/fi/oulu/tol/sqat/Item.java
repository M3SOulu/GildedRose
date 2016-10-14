package fi.oulu.tol.sqat;


public class Item {
    String name;
    int sellIn; 
    int quality;
    boolean developsNormally;
    boolean decaysNormally;
    
    public Item(String name, int sellIn, int quality) {
		this.setName(name);
		this.setSellIn(sellIn);
		this.setQuality(quality);
		setFlags(name);
	}
    
    private void setFlags(String name) {
    	decaysNormally = true;
    	developsNormally = true;
    	if(name.equals("Aged Brie") || name.equals("Backstage passes to a TAFKAL80ETC concert")) {
    		developsNormally = false;
    	} else if(name.equals("Sulfuras, Hand of Ragnaros")) {
    		decaysNormally = false;
    	} 
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
	
	public void decreaseQuality() {
		this.quality--;
    }
	
	public void increaseQuality() {
		this.quality++;
	}
	
	public void decreaseSellin() {
		if(name == "Sulfuras, Hand of Ragnaros") {
			return;
		}
		this.sellIn--;
	}
	
	public boolean isExpired() {
		if(sellIn < 0) {
			return true;
		}
		return false;
	}
	
	public boolean hasReachedMaximumQuality() {
		if(name == "Sulfuras, Hand of Ragnaros") {
			return true;
		} else {
			if(quality == 50) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasZeroQuality() {
		if(quality == 0) {
			return true;
		}
		return false;
	}
	
	public boolean decaysNormally() {
		return decaysNormally;
	}
	
	public boolean developsNormally() {
		return developsNormally;
	}
	
}

