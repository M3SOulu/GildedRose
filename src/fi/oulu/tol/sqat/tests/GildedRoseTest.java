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
	
	assertEquals(2,GildedRose.items.get(5).getSellIn());
	assertEquals(4,GildedRose.items.get(5).getQuality());
	
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
		
		GildedRose.updateQuality();
		
		assertEquals(10,GildedRose.items.get(4).getSellIn());
		assertEquals(26,GildedRose.items.get(4).getQuality());
		
		for(int i=0;i<5;i++){GildedRose.updateQuality();}
		
		assertEquals(5,GildedRose.items.get(4).getSellIn());
		assertEquals(37,GildedRose.items.get(4).getQuality());
		
		for(int i=0;i<6;i++){GildedRose.updateQuality();}
		
		assertEquals(-1,GildedRose.items.get(4).getSellIn());
		assertEquals(0,GildedRose.items.get(4).getQuality());
	}
	
	@Test
	public void testOver50(){
		
		for(int i=0;i<51;i++){GildedRose.updateQuality();}
		
		assertEquals(-49,GildedRose.items.get(1).getSellIn());
		assertEquals(50,GildedRose.items.get(1).getQuality());
		
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80E3 concert", 15, 50));
		
		GildedRose.updateQuality();
		
		assertEquals(14,GildedRose.items.get(6).getSellIn());
		assertEquals(50,GildedRose.items.get(6).getQuality());
	}
}
