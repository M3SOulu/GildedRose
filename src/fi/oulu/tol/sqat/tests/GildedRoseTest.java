package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

// Example scenarios for testing
//   Item("+5 Dexterity Vest", 10, 20));
//   Item("Aged Brie", 2, 0));
//   Item("Elixir of the Mongoose", 5, 7));
//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}
    
	@Test
	public void testUpdateEndOfDay_DexterityVest_Quality_20_19() {
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item dexterityVest = items.get(0);
		assertEquals("Aging does not work with day values over 1, should decrease by 1", 19, dexterityVest.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_RustySword_Quality_Day0Start_5_3(){
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Rusty Sword", 0, 5));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item rustySword = items.get(0);
		assertEquals("Aging does not work from day0 to one day over, should decrease by 2", 3, rustySword.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_SulfurasHandOfRagnarok_Quality_80_80(){
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item sulfuras = items.get(0);
		assertEquals("Sulfura's value shouldn't decrease", 80, sulfuras.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDay_Mushroom_Quality_0_0(){
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Mushroom", 4, 0));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item mushroom = items.get(0);
		assertEquals("An item's quality can't deteriorate to a negative number", 0, mushroom.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_50_50(){
		//Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 4, 50));
		
		//Act
		store.updateEndOfDay();
		
		//Assert
		List<Item> items = store.getItems();
		Item brie = items.get(0);
		assertEquals("An item's quality can't increase over 50", 50, brie.getQuality());
		
	}
	/*
	 * 
	 * Just a reminder to memorize to insert this fail always as the first thing in a test
	@Test
	public void testUpdateEndOfDay() {
		fail("Test not implemented");
	}
	*/
}
