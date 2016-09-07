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
    
	public void testUpdateEndOfDay_ElixirQualityAndSellIn() {

		GildedRose store = new GildedRose ();
		store.addItem(new Item("Elixir of the Mongoose", 5, 7));
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item elixir = items.get(0);
		assertEquals(6, elixir.getQuality());
		assertEquals(4, elixir.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_TwoItems_SulfurasQualityAndManaCakeSellIn() {
		GildedRose store = new GildedRose ();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		store.addItem(new Item("Conjured Mana Cake", 3, 6));
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item sulfuras = items.get(0);
		Item manacacke = items.get(1);
		assertEquals(80, sulfuras.getQuality());
		assertEquals(2, manacacke.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfSecondDay_5DexterityVest() {
		GildedRose store = new GildedRose ();
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));
		
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item dext = items.get(0);
		assertEquals(19, dext.getQuality());
		assertEquals(9, dext.getSellIn());
		
		store.updateEndOfDay();
		items = store.getItems();
		dext = items.get(0);
		assertEquals(18, dext.getQuality());
		assertEquals(8, dext.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDayAgedBriePassesSellInDate() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 1, 10) );
		
		store.updateEndOfDay();
	
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
		
		store.updateEndOfDay();
		items = store.getItems();
		itemBrie = items.get(0);
		assertEquals(13, itemBrie.getQuality());
		
	}
	
	@Test
	public void testUpdateEndOfDayAgedBrieQualityCantBeMoreThan50() {

		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 3, 49) );
		
		store.updateEndOfDay();
	
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
		
		store.updateEndOfDay();
		items = store.getItems();
		itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
		assertEquals(1, itemBrie.getSellIn());
		
	}

	@Test
	public void testUpdateEndOfDay_AllItems_backstagePassesQualityIncreasesBy2() {
		GildedRose store = new GildedRose ();
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		store.addItem(new Item("Conjured Mana Cake", 3, 6));
		store.addItem(new Item("Elixir of the Mongoose", 5, 7));
		store.addItem(new Item("Aged Brie", 2, 10));
		store.addItem(new Item ("Backstage passes to a TAFKAL80ETC concert", 9, 20));
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item dext = items.get(0);
		Item sulfuras = items.get(1);
		Item manacake = items.get(2);
		Item elixir = items.get(3);
		Item brie = items.get(4);
		Item backstagepasses = items.get(5);
		assertEquals(19, dext.getQuality());
		assertEquals(9, dext.getSellIn());
		assertEquals(80, sulfuras.getQuality());
		assertEquals(0, sulfuras.getSellIn());
		assertEquals(5, manacake.getQuality());
		assertEquals(2, manacake.getSellIn());
		assertEquals(6, elixir.getQuality());
		assertEquals(4, elixir.getSellIn());
		assertEquals(11, brie.getQuality());
		assertEquals(1, brie.getSellIn());
		assertEquals(22, backstagepasses.getQuality());
		assertEquals(8, backstagepasses.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfSecondDay_AllItems() {
		GildedRose store = new GildedRose ();
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		store.addItem(new Item("Conjured Mana Cake", 3, 6));
		store.addItem(new Item("Elixir of the Mongoose", 5, 7));
		store.addItem(new Item("Aged Brie", 2, 10));
		store.addItem(new Item ("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		
		store.updateEndOfDay();
		List<Item> items = store.getItems();
		Item dext = items.get(0);
		Item sulfuras = items.get(1);
		Item manacake = items.get(2);
		Item elixir = items.get(3);
		Item brie = items.get(4);
		Item tafkal = items.get(5);
		assertEquals(19, dext.getQuality());
		assertEquals(9, dext.getSellIn());
		assertEquals(80, sulfuras.getQuality());
		assertEquals(0, sulfuras.getSellIn());
		assertEquals(5, manacake.getQuality());
		assertEquals(2, manacake.getSellIn());
		assertEquals(6, elixir.getQuality());
		assertEquals(4, elixir.getSellIn());
		assertEquals(11, brie.getQuality());
		assertEquals(1, brie.getSellIn());
		assertEquals(21, tafkal.getQuality());
		assertEquals(14, tafkal.getSellIn());
		
		store.updateEndOfDay();
		items = store.getItems();
		dext = items.get(0);
		sulfuras = items.get(1);
		manacake = items.get(2);
		elixir = items.get(3);
		brie = items.get(4);
		tafkal = items.get(5);
		assertEquals(18, dext.getQuality());
		assertEquals(8, dext.getSellIn());
		assertEquals(80, sulfuras.getQuality());
		assertEquals(0, sulfuras.getSellIn());
		assertEquals(4, manacake.getQuality());
		assertEquals(1, manacake.getSellIn());
		assertEquals(5, elixir.getQuality());
		assertEquals(3, elixir.getSellIn());
		assertEquals(12, brie.getQuality());
		assertEquals(0, brie.getSellIn());
		assertEquals(22, tafkal.getQuality());
		assertEquals(13, tafkal.getSellIn());
	}
}
