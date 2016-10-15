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
//   Item("Backstage passes to a TAFKAL80ETC concert to a TAFKAL80ETC concert", 15, 20));
//   Item("Conjured Mana Cake", 3, 6));
	
	@Test
	// Basic brie aging test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		GildedRose.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(11, item.getQuality());
	}
    
	// Test for negative quality
	@Test
	public void testUpdateEndOfDay_NeverNegative_Quality_1_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Never negative", 1, 0) );
		
		// Act
		GildedRose.updateEndOfDay();
		GildedRose.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(0, item.getQuality());
	}

	// Quality maximum reached
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_49_50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 1, 49) );
		
		// Act
		GildedRose.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(50, item.getQuality());
	}

	// Quality increased by two
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_15() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 1, 10) );
		
		// Act
		GildedRose.updateEndOfDay();
		GildedRose.updateEndOfDay();
		GildedRose.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(15, item.getQuality());
	}
	
	// Sulfuras never sellIn test
	@Test
	public void testUpdateEndOfDay_Sulfuras_SellIn_1_1() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 1, 1) );
		
		// Act; two days
		GildedRose.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(1, item.getSellIn());
	}

	// Backstage pass +2 quality test
	@Test
	public void testUpdateEndOfDay_BP_Quality_1_3() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 1) );
		
		// Act; two days
		GildedRose.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(9, item.getSellIn());
	}

	// Backstage pass +3 quality test
	@Test
	public void testUpdateEndOfDay_BP_Quality_1_4() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 1) );
		
		// Act; two days
		GildedRose.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(4, item.getSellIn());
	}

	// Backstage pass 0 quality test
	@Test
	public void testUpdateEndOfDay_Sulfuras_Quality_0_10() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 10) );
		
		// Act; two days
		GildedRose.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(10, item.getQuality());
	}

	@Test
	public void testUpdateEndOfDay() {
		fail("Test not implemented");
	}
}
