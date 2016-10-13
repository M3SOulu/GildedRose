package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	// Example scenarios for testing
	//   Item("+5 Dexterity Vest", 10, 20));
	//   Item("Aged Brie", 2, 10));
	//   Item("Elixir of the Mongoose", 5, 7));
	//   Item("Sulfuras, Hand of Ragnaros", 0, 80));
	//   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
	//   Item("Conjured Mana Cake", 3, 6));

	private GildedRose store = new GildedRose();

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10To11_In1Day() {
		// Arrange
		store.addItem(new Item("Aged Brie", 2, 10));

		// Act
		GildedRose.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10To18_In5Days() {
		// Arrange
		store.addItem(new Item("Aged Brie", 2, 10));

		// Act
		for (int i = 0; i < 5; i++) {
			GildedRose.updateEndOfDay();
		}

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(18, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10To48_In20Days() {
		// Arrange
		store.addItem(new Item("Aged Brie", 2, 10));

		// Act
		for (int i = 0; i < 20; i++) {
			GildedRose.updateEndOfDay();
		}

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(48, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10To50_In21Days() {
		// Arrange
		store.addItem(new Item("Aged Brie", 2, 10));

		// Act
		for (int i = 0; i < 21; i++) {
			GildedRose.updateEndOfDay();
		}

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10To50_In100Days() {
		// Arrange
		store.addItem(new Item("Aged Brie", 2, 10));

		// Act
		for (int i = 0; i < 100; i++) {
			GildedRose.updateEndOfDay();
		}

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_DexterityVest_20To17_In3Days() {
		// Arrange
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));

		// Act
		GildedRose.updateEndOfDay();
		GildedRose.updateEndOfDay();
		GildedRose.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(17, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_DexterityVest_20To0_In50Days() {
		// Arrange
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));

		// Act
		for (int i = 0; i < 50; i++) {
			GildedRose.updateEndOfDay();
		}

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(0, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_Sulfuras_80_In1Day() {
		// Arrange
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));

		// Act
		GildedRose.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(80, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_Sulfuras_80_In3Days() {
		// Arrange
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));

		// Act
		GildedRose.updateEndOfDay();
		GildedRose.updateEndOfDay();
		GildedRose.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(80, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_BackstagePass_20To41_In10Days() {
		// Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20));

		// Act
		for (int i = 0; i < 10; i++) {
			GildedRose.updateEndOfDay();
		}

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(41, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_BackstagePass_20To0_In13Days() {
		// Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20));

		// Act
		for (int i = 0; i < 13; i++) {
			GildedRose.updateEndOfDay();
		}

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(0, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_ConjuredManaCake_6To4_In2Days() {
		// Arrange
		store.addItem(new Item("Conjured Mana Cake", 3, 6));

		// Act
		GildedRose.updateEndOfDay();
		GildedRose.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(4, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_ConjuredManaCake_6To1_In4Days() {
		// Arrange
		store.addItem(new Item("Conjured Mana Cake", 3, 6));

		// Act
		for (int i = 0; i < 4; i++) {
			GildedRose.updateEndOfDay();
		}

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(1, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_ConjuredManaCake_6To0_In6Days() {
		// Arrange
		store.addItem(new Item("Conjured Mana Cake", 3, 6));

		// Act
		for (int i = 0; i < 6; i++) {
			GildedRose.updateEndOfDay();
		}

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(0, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_Elixir_7To2_In5Days() {
		// Arrange
		store.addItem(new Item("Elixir of the Mongoose", 5, 7));

		// Act
		for (int i = 0; i < 5; i++) {
			GildedRose.updateEndOfDay();
		}

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(2, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_Elixir_7To0_In6Days() {
		// Arrange
		store.addItem(new Item("Elixir of the Mongoose", 5, 7));

		// Act
		for (int i = 0; i < 6; i++) {
			GildedRose.updateEndOfDay();
		}

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(0, itemBrie.getQuality());
	}
}
