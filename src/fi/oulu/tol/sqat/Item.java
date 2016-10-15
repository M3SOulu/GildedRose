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
	
	public boolean canDecreaseQuality() {
        if ((!"Aged Brie".equals(name)) && !"Backstage passes to a TAFKAL80ETC concert".equals(name)) {
        	return true;
        }
        return false;
	}
	
	public void decreaseQuality() {
        if (quality > 0)
        {
            if (!"Sulfuras, Hand of Ragnaros".equals(name))
            {
                quality--;
            }
        }
	}

	public void decreaseSellIn() {
        if (!"Sulfuras, Hand of Ragnaros".equals(name)) {
            sellIn--;
        }

        if (sellIn < 0)
        {
            if (!"Aged Brie".equals(name))
            {
                if (!"Backstage passes to a TAFKAL80ETC concert".equals(name))
                {
                    if (quality > 0)
                    {
                        if (!"Sulfuras, Hand of Ragnaros".equals(name))
                        {
                            quality--;
                        }
                    }
                }
                else
                {
                    quality -= quality;
                }
            }
            else
            {
                if (quality < 50) {
                    quality++;
                }
            }
        }
	}

	public void increaseQuality() {
        if (quality < 50)
        {
            quality++;

            if ("Backstage passes to a TAFKAL80ETC concert".equals(name))
            {
                if (quality < 50) {
                    if (sellIn < 11) {
                    	quality++;
                    }

                    if (sellIn < 6) {
                    	quality++;
                    }
                }
            }
        }
	}
}

