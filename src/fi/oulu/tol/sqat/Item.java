package fi.oulu.tol.sqat;


public class Item {
	
	public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
	public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	public static final String BRIE = "Aged Brie";
	
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
	
	public void updateQuality() {
		int update = 1;
		if (isExpired())
			update = 2;
		
		if (BRIE.equals(name)) {
			quality += update;
		} else if (BACKSTAGE.equals(name)) {
			if (isExpired())
				quality = 0;
			else {
				if (sellIn <= 5)
					update = 3;
				else if (sellIn <= 10)
					update = 2;
				else
					update = 1;
				
				quality += update;
			}
		} else {
			quality -= update;
		}
	}
	
	public void updateSellIn() {
		sellIn--;
	}
	
	public void ensureBounds() {
		if (SULFURAS.equals(name)) {
			quality = 80;
			sellIn = 0;
		} else {
			if (quality < 0)
				quality = 0;
			else if (quality > 50)
				quality = 50;
		}
	}
	
	private boolean isExpired() {
		return (sellIn <= 0);
	}
}

