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
	public void testUpdateEndOfDay_Elixir_Negative() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir", 2, 0) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(0, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Cake_PastSellBy() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Cake", 0, 4) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(2, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Cake_PastSellBy_LessThanZero() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Cake", 0, 1) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(0, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_MaxQuality() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("FooBar", 10, 54) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(50, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_MoreThanMaxQuality_Sulfuras() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 84) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(80, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_LessThanMaxQuality_Sulfuras() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 65) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(80, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_SellIn_Sulfuras() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 10, 80) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(0, item.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(80, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BriePastSellIn() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", -2, 30) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(32, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_MoreThan10DaySellIn() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 12, 30) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(31, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_SellIn10() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(32, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_SellIn5() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(33, item.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_PastSellIn() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(0, item.getQuality());
	}
}
