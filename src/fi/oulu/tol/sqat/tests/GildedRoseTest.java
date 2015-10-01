package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.*;
import org.junit.runners.Parameterized.Parameters;

//import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;




@RunWith(Parameterized.class)
public class GildedRoseTest 
{

	Item item;
	String expectedName;
	int expectedSellIn;
	int expectedQuality;
	
	
	public GildedRoseTest(Item item,int expectedSellIn,int expectedQuality) 
	{
		this.item=item;
		this.expectedSellIn = expectedSellIn;
		this.expectedQuality = expectedQuality;
				
	}
	
	@Parameters (name = "{index} SellIn:{1} Quality:{2} ")
	public static List<Object[]> myData(){
		return Arrays.asList(new Object[][]{
				{new Item("Aged Brie", 2, 0), 1, 1},
				{new Item("+5 Dexterity Vest", 10, 20), 9, 19},
				{new Item("Elixir of the Mongoose", 5, 7), 4, 6},
				{new Item("Sulfuras, Hand of Ragnaros", 0, 80), 0, 80},
				{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20), 14, 20},
				{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20), 3, 23},
				{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20), 0, 0},
				{new Item("Conjured Mana Cake", 3, 6), 2, 4},
				
				
		});
	}
	
	
	@Test
	public void testItemInitialState(){
		
		Item item = initializeItem();
		
		assertEquals("test", item.getName());
		assertEquals(5, item.getSellIn());
		assertEquals(25, item.getQuality());
	}
	
	@Test
	public void testQualityUpdatedOnce(){
		Item item = initializeItem();
		
		item.setQuality(item.getQuality()-1);
		assertEquals(24, item.getQuality());
	}
	
	@Test
	public void testSellInUpdatedOnce(){
		
		Item item = initializeItem();
		
		item.setSellIn(item.getSellIn()-1);
		assertEquals(4, item.getSellIn());
	}
	

	private Item initializeItem(){
		return new Item("test", 5, 25);
		
	}
	
	
	
	
}
