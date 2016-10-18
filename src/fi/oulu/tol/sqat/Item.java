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
	
	public void decreaseQuality(int quality){
		this.quality = quality - 1;
	}
	
	public void increaseQuality(int quality){
		this.quality = quality + 1;
	}
	
	public void decreaseSellIn(int sellIn){
		this.sellIn = sellIn - 1;
	}
	
	public static boolean notMaxQuality(int quality) {
		return quality < 50;
	}
	
	public static boolean isExpired(Item item) {
		if (item.getSellIn() < 0){
			return true; }
		else{
			return false;
		}
	}
}
