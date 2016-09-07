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
	public void testUpdateEndOfDay_AgedBrie_Quality_After_Two_Days() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		store.updateEndOfDay();
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item itemAgedBrie = items.get(0);
		assertEquals(12, itemAgedBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Salt_SellIn() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Salt", 2, 20) );
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item itemSalt = items.get(0);
		assertEquals(1, itemSalt.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_Salt_Quality_after_SellIn_0() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Salt", 0, 20) );
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item itemSalt = items.get(0);
		assertEquals(18, itemSalt.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Check_Is_Quality_Of_Salt_Under_0() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Salt", 0, 1) );
		store.updateEndOfDay();
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item itemSalt = items.get(0);
		assertEquals(0, itemSalt.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_HandOfRagnaros_Quality_After_Two_Days() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 1, 80));
		store.updateEndOfDay();
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item itemHandOfRagnaros = items.get(0);
		assertEquals(80, itemHandOfRagnaros.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Dexterity_Vest_Quality_After_A_Week() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));;
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item itemDexterityVests = items.get(0);
		assertEquals(13, itemDexterityVests.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_Passes_Quality_After_Two_Days() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10));
		store.updateEndOfDay();
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item itemPasses = items.get(0);
		assertEquals(14, itemPasses.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_Passes_Quality_When_SellIn_Is_0() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10));
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item itemPasses = items.get(0);
		assertEquals(0, itemPasses.getQuality());
	}
}
