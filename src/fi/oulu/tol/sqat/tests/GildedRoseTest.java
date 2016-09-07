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
	public void testUpdateEndOfDay_AgedBrie_Quality_Max_50(){
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 1, 45));
		// Act
		store.updateEndOfDay(); // Quality = 46
		store.updateEndOfDay(); // Quality = 47
		store.updateEndOfDay(); // Quality = 48
		store.updateEndOfDay(); // Quality = 49
		store.updateEndOfDay(); // Quality = 50
		store.updateEndOfDay(); // Quality = 50
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(50, item.getQuality());
	}
	@Test
	public void testUpdateEndOfDay_AgedBrie_SellIn_3_1(){
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 3, 20));
		// Act
		store.updateEndOfDay(); // SellIn = 2
		store.updateEndOfDay(); // SellIn = 1

		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(1, item.getSellIn());
	}
	@Test
	public void testUpdateEndOfDay_DexterityVest_Quality_20_19(){
		// Arrange
		GildedRose store = new GildedRose();
		
		store.addItem(new Item("+5 Dexterity Vest", 5, 20));
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(19, item.getQuality());
	}
	@Test
	public void testUpdateEndOfDay_DexterityVest_Quality_AfterSellIn_20_17(){
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 1, 20));
		// Act
		store.updateEndOfDay(); // Quality = 19
		store.updateEndOfDay(); // Quality = 17
		store.updateEndOfDay(); // Quality = 15

		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(15, item.getQuality());
	}
	@Test
	public void testUpdateEndOfDay_DexterityVest_Quality_0(){
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 1, 10));
		// Act
		store.updateEndOfDay(); // Quality = 9
		store.updateEndOfDay(); // Quality = 7
		store.updateEndOfDay(); // Quality = 5
		store.updateEndOfDay(); // Quality = 3
		store.updateEndOfDay(); // Quality = 1
		store.updateEndOfDay(); // Quality = 0
		store.updateEndOfDay(); // Quality = 0

		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(0, item.getQuality());
	}
	@Test
	public void testUpdateEndOfDay_DexterityVest_SellIn_2_1(){
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 2, 10));
		// Act
		store.updateEndOfDay(); // SellIn = 1
		
		// Assert
		List<Item> items = store.getItems();
		Item item = items.get(0);
		assertEquals(1, item.getSellIn());
	}
	/*@Test
	public void testUpdateEndOfDay() {
		fail("Test not implemented");
	}*/
}
