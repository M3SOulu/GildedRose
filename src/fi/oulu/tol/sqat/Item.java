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
	
	public void decreaseQuality(int amount) {
		while (amount > 0 && this.quality > 0) {
			this.quality--;
			amount--;
		}
	}
	
	public void increaseQuality(int amount) {
		while (amount > 0 && this.quality < 50) {
			this.quality++;
			amount--;
		}
	}
	
	public void decreaseSellIn() {
		this.sellIn--;
	}
	
	public boolean sellInPassed() {
		return this.getSellIn() < 0;
	}
}

