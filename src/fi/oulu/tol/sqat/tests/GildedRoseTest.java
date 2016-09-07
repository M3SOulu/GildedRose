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
	public void testUpdateEndOfDay_EmptyList() {
		// Arrange
		GildedRose store = new GildedRose();
		// Act
		store.updateEndOfDay();
		// Assert
		List<Item> items = store.getItems();
		assertEquals("Empty store doesnt return empty list", 0, items.size());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_0_1() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 0) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(1, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_50_50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 50) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_nonSpecialTwoDayItem_DecreaseOneDay_Quality_10_9() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("SomeItem", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item someItem = items.get(0);
		assertEquals(9, someItem.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_nonSpecialTwoDayItem_DecreaseToZero_Quality_5_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("SomeItem", 2, 5) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item someItem = items.get(0);
		assertEquals("Non special item quality goes under zero", 0, someItem.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_nonSpecialTwoDayItem_DecreaseTwoDays_Quality_10_8() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("SomeItem", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item someItem = items.get(0);
		assertEquals(8, someItem.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_nonSpecialTwoDayItem_DecreaseThreeDays_Quality_10_6() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("SomeItem", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item someItem = items.get(0);
		assertEquals(6, someItem.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_nonSpecialZeroDayItem_DecreaseOneDay_Quality_10_8() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("SomeItem", 0, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item someItem = items.get(0);
		assertEquals(8, someItem.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_addMultipleNonSpecialItems() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("SomeItem", 2, 10) );
		store.addItem(new Item("SomeItem2", 2, 15) );
		
		// Act
		
		// Assert
		List<Item> items = store.getItems();
		Item someItem = items.get(0);
		Item someItem2 = items.get(1);
		assertEquals("first non special item is not returned correctly", "SomeItem", someItem.getName());
		assertEquals("second non special item is not returned correctly", "SomeItem2", someItem2.getName());
		assertEquals("store return invalid amount of items", 2, items.size());
	}
	
	@Test
	public void testUpdateEndOfDay_sulfuras_decreaseOneDay() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 1, 80));
		
		// Act
		for (int i = 0; i < 100; i++) {
			store.updateEndOfDay();
		}

		// Assert
		List<Item> items = store.getItems();
		Item sulfuras = items.get(0);
		assertEquals("Sulfuras quality decreases", 80, sulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePassDecreaseOneDay_11days_q30_31() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 30));
		
		// Act
		store.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item pass = items.get(0);
		assertEquals("Pass quality increases incorrectly when over than 10 days", 31, pass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePassDecreaseTwoDays_11days_q30_33() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 30));
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item pass = items.get(0);
		assertEquals("Pass quality increases incorrectly when 10 or less days", 33, pass.getQuality());
	}
	
	
	@Test
	public void testUpdateEndOfDay_BackstagePassDecrease11Days_11days_q30_50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 30));
		
		// Act
		for (int i = 0; i < 11; i++) {
			store.updateEndOfDay();
		}

		// Assert
		List<Item> items = store.getItems();
		Item pass = items.get(0);
		assertEquals("Pass quality increases incorrectly for 11 days", 50, pass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePassUpdateTwoDays_1Day_q30() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 30));
		
		// Act
		for (int i = 0; i < 2; i++) {
			store.updateEndOfDay();
		}

		// Assert
		List<Item> items = store.getItems();
		Item pass = items.get(0);
		assertEquals("Pass quality increases incorrectly after one day", 0, pass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePassUpdateTenDays_11Day_q50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50));
		
		// Act
		for (int i = 0; i < 10; i++) {
			store.updateEndOfDay();
		}

		// Assert
		List<Item> items = store.getItems();
		Item pass = items.get(0);
		assertEquals("Pass quality increases over 50", 50, pass.getQuality());
	}
}
