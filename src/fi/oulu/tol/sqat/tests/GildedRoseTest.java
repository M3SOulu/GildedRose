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
	public void testUpdateEndOfDay_AgedBrie_SellIn_2_Quality_10_after_1_day() {
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
	public void testUpdateEndOfDay_AgedBrieQuality50Plus1() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 10, 50));
		
		// Act
		
		store.updateEndOfDay();
		
		// Assert
		
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrieSellIn_2_Quality_0_After_2_Days() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 0));
		
		// Act
		
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(2, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfura_QualityChange() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		// Act
		
		store.updateEndOfDay();
		
		// Assert
		
		List<Item> items = store.getItems();
		Item itemSulfura = items.get(0);
		assertEquals(80, itemSulfura.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfura_SellInChange() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		// Act
		
		store.updateEndOfDay();
		
		// Assert
		
		List<Item> items = store.getItems();
		Item itemSulfura = items.get(0);
		assertEquals(0, itemSulfura.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePass_SellIn_10_Quality_10_after_1_day() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10));
		
		// Act
		
		store.updateEndOfDay();
		
		// Assert
		
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(12, itemPass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePass_SellIn_5_Quality_10_after_1_day() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10));
		
		// Act
		
		store.updateEndOfDay();
		
		// Assert
		
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(13, itemPass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_BackstagePass_SellIn_1_Quality_10_after_1_day() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10));
		
		// Act
		
		store.updateEndOfDay();
		
		// Assert
		
		List<Item> items = store.getItems();
		Item itemPass = items.get(0);
		assertEquals(0, itemPass.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_ManaCake_SellIn_2_Quality_2_after_3_days() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Mana cake", 2, 2));
		
		// Act
		
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		
		List<Item> items = store.getItems();
		Item itemCake = items.get(0);
		assertEquals(0, itemCake.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_ManaCake_SellIn_0_Quality_6_after_3_days() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Mana cake", 0, 6));
		
		// Act
		
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		
		List<Item> items = store.getItems();
		Item itemCake = items.get(0);
		assertEquals(0, itemCake.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_ManaCake_SellIn_6_Quality_0_after_3_days() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Mana cake", 6, 0));
		
		// Act
		
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		
		List<Item> items = store.getItems();
		Item itemCake = items.get(0);
		assertEquals(0, itemCake.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_ManaCake_SellIn_10_Quality_49_after_3_days() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Mana cake", 10, 49));
		
		// Act
		
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		
		List<Item> items = store.getItems();
		Item itemCake = items.get(0);
		assertEquals(50, itemCake.getQuality());
	}
	
	
	
}
