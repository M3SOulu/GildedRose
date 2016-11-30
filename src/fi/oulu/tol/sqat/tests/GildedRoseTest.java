package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {
	int count=0;
	GildedRose gr = new GildedRose();
	Item it1=new Item("Elixir of the Mongoose", 5, 25);
	Item it2 = new Item("Elixir of the Mongoose", 1, 2);
	Item it3=new Item("Aged Brie", 2, 0);
	Item it4 = new Item ("Aged Brie",8,49);
	Item it5 = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
	Item it6 = new Item("Backstage passes to a TAFKAL80ETC concert", 13, 22);
	Item it7 = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 49);
	Item it8 = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 49);
	Item it9 = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49);
	Item it10 = new Item ("Aged Brie",0,49);
	Item it11 = new Item("Sulfuras, Hand of Ragnaros", -1, 80);

	
	

	@Before
	public void setup(){
		gr.items.add(it1);
		gr.items.add(it2);
		gr.items.add(it3);
		gr.items.add(it4);
		gr.items.add(it5);
		gr.items.add(it6);
		gr.items.add(it7);
		gr.items.add(it8);
		gr.items.add(it9);
		gr.items.add(it10);
		gr.items.add(it11);
	}

	@Test
	public void testDegraseTwiceAsFastWhenSellInHasPassed() {
		gr.updateQuality();
		gr.updateQuality();
		gr.updateQuality();
		gr.updateQuality();
		gr.updateQuality();
		gr.updateQuality();
		assertEquals(gr.items.get(0).getQuality(), 18);
		assertEquals(gr.items.get(0).getSellIn(), -1);
	}
	
	@Test
	public void testQualityDontDegresetWhenSellInHasPassed() {
		gr.updateQuality();
		gr.updateQuality();
		gr.updateQuality();
		assertEquals(gr.items.get(1).getQuality(), 0);
		assertEquals(gr.items.get(1).getSellIn(), -2);
	}
	
	@Test
	public void testBrieIncreasesItsQuality() {
		gr.updateQuality();
		assertEquals(gr.items.get(2).getQuality(), 1);
		assertEquals(gr.items.get(2).getSellIn(), 1);
	}
	
	@Test
	public void testQaulityNeverMoreThanFifty() {
		gr.updateQuality();	
		assertEquals(gr.items.get(3).getQuality(), 50);
		assertEquals(gr.items.get(3).getSellIn(), 7);
	}
	
	@Test
	public void testDulfurasIsLegendary() {
		gr.updateQuality();
		assertEquals(gr.items.get(4).getQuality(), 80);
		assertEquals(gr.items.get(4).getSellIn(), 0);
	}
	
	@Test
	public void testConcertPass1() {
		
		gr.updateQuality();
		assertEquals(gr.items.get(5).getQuality(), 23);
		assertEquals(gr.items.get(5).getSellIn(), 12);
		
	}
	
	@Test
	public void testConcertPass2() {
		
		gr.updateQuality();
		assertEquals(gr.items.get(6).getQuality(), 50);
		assertEquals(gr.items.get(6).getSellIn(), 7);
		
	}
	
	@Test
	public void testConcertPass3() {
		
		gr.updateQuality();
		assertEquals(gr.items.get(7).getQuality(), 50);
		assertEquals(gr.items.get(7).getSellIn(), 2);
		
	}
	
	@Test
	public void testConcertPass4() {
		
		gr.updateQuality();
		assertEquals(gr.items.get(8).getQuality(), 50);
		assertEquals(gr.items.get(8).getSellIn(), 0);
		
	}
	
	@Test
	public void testConcertPass5() {
		
		gr.updateQuality();
		gr.updateQuality();
		assertEquals(gr.items.get(8).getQuality(), 0);
		assertEquals(gr.items.get(8).getSellIn(), -1);
		
	}
	
	@Test
	public void testBrie2() {
		
		gr.updateQuality();
		gr.updateQuality();
		assertEquals(gr.items.get(9).getQuality(), 50);
		assertEquals(gr.items.get(9).getSellIn(), -2);
		
	}
	
	@Test
	public void testSulfurasWithSellInNegative() {
		
		gr.updateQuality();
		assertEquals(gr.items.get(10).getQuality(), 80);
		assertEquals(gr.items.get(10).getSellIn(), -1);
		
	}
}
