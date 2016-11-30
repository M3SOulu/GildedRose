package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {
	
	@Before
	public void setUp(){
		
		GildedRose gild= new GildedRose();
		
		GildedRose.items.add(new Item("+5 Dexterity Vest", 10, 20));	     
        GildedRose.items.add(new Item("Aged Brie", 2, 0));
        GildedRose.items.add(new Item("Elixir of the Mongoose", 5, 7));
        GildedRose.items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        GildedRose.items.add(new Item("Conjured Mana Cake", 3, 6));
	}

	@Test
	public void testFirstDay() {
		
	GildedRose.updateQuality();
	
	assertEquals(9,GildedRose.items.get(0).getSellIn());
	assertEquals(19,GildedRose.items.get(0).getQuality());
	
	assertEquals(1,GildedRose.items.get(1).getSellIn());
	assertEquals(1,GildedRose.items.get(1).getQuality());
	
	assertEquals(4,GildedRose.items.get(2).getSellIn());
	assertEquals(6,GildedRose.items.get(2).getQuality());
	
	assertEquals(0,GildedRose.items.get(3).getSellIn());
	assertEquals(80,GildedRose.items.get(3).getQuality());
    
	assertEquals(14,GildedRose.items.get(4).getSellIn());
	assertEquals(21,GildedRose.items.get(4).getQuality());
	
	}
	
	@Test
	public void testSellInTwice() {
		
	for(int i=0;i<11;i++){GildedRose.updateQuality();}
		
	assertEquals(-1,GildedRose.items.get(0).getSellIn());
	assertEquals(8,GildedRose.items.get(0).getQuality());
	
	}
	
	@Test
	public void testNeverNegative(){
		
		for(int i=0;i<21;i++){GildedRose.updateQuality();}
		
		assertEquals(-11,GildedRose.items.get(0).getSellIn());
		assertEquals(0,GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testBackstage(){
		
		for(int i=0;i<4;i++){GildedRose.updateQuality();}
		
		assertEquals(11,GildedRose.items.get(4).getSellIn());
		assertEquals(24,GildedRose.items.get(4).getQuality());
	}
}
