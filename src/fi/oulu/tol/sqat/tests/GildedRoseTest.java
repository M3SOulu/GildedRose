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

	// Once the sell by date has passed, Quality degrades twice as fast
	// The Quality of an item is never negative
	// The Quality of an item is never more than 50
	// "Aged Brie" actually increases in Quality the older it gets
	// "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
	// "Backstage passes", like aged brie, increases in Quality as it's SellIn value approaches; 
	// Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but 
	// Quality drops to 0 after the concert.
	
	// Comments placed above the test method just for the clarity of the practise
	
	@Test
	// Basic brie aging test
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
    
	// Test for negative quality
	@Test
	public void testUpdateEndOfDay_NeverNegative_Quality_1_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Never negative", 1, 0) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(0, itemBrie.getQuality());
	}

	// Quality maximum reached
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_49_50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 1, 49) );
		
		// Act
		store.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
	}

	// Quality increased by two
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_15() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 1, 10) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(15, itemBrie.getQuality());
	}
	
	// Sulfuras never sellIn test
	@Test
	public void testUpdateEndOfDay_Sulfuras_SellIn_1_1() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras", 1, 1) );
		
		// Act; two days
		store.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(1, itemBrie.getSellIn());
	}

	// Backstage pass +2 quality test
	@Test
	public void testUpdateEndOfDay_BP_Quality_1_3() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes", 10, 1) );
		
		// Act; two days
		store.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(3, itemBrie.getSellIn());
	}

	// Backstage pass +3 quality test
	@Test
	public void testUpdateEndOfDay_BP_Quality_1_4() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes", 5, 1) );
		
		// Act; two days
		store.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(4, itemBrie.getSellIn());
	}

	// Backstage pass 0 quality test
	@Test
	public void testUpdateEndOfDay_Sulfuras_Quality_1_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes", 0, 10) );
		
		// Act; two days
		store.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(0, itemBrie.getSellIn());
	}

	@Test
	public void testUpdateEndOfDay() {
		fail("Test not implemented");
	}
}
