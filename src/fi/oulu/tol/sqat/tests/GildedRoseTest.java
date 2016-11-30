package fi.oulu.tol.sqat.tests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {
	GildedRose store = new GildedRose();
	private static final String DEXT_VEST = "+5 Dexterity Vest";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String ELIXIR = "Elixir of the Mongoose";
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	private static final String MANA_CAKE = "Conjured Mana Cake";
	
	@Test public void testUpdateEndOfDay_Mana_Quality_2_9() {
		// Arrange
		store.addItem(new Item(MANA_CAKE, 2, 9) );
		// Act
		store.updateEndOfDay();
		// Assert
		String failMessage = "Quality decreases 1";
		assertEquals(failMessage, 8, quality());
	}

	private int quality() {
		int quality = store.getItems().get(0).getQuality();
		return quality;
	}
	
	@Test public void testUpdateEndOfDay_DexterityVest_Quality_10_10() {
		// Arrange
		store.addItem(new Item(DEXT_VEST, 10, 10) );
		// Act
		store.updateEndOfDay();
		String failMessage = "Quality decreases 1";
		assertEquals(failMessage, 9, quality());
	}
	
	@Test public void testUpdateEndOfDay_AgedBrie_Quality_2_10() {
		// Arrange
		store.addItem(new Item(AGED_BRIE, 2, 10) );
		// Act
		store.updateEndOfDay();
		String failMessage = "Quality of Aged Brie increases";
		assertEquals(failMessage, 11, quality());
	}
	
	@Test public void testUpdateEndOfDay_AgedBrie_Quality_10_50() {
		// Arrange
		store.addItem(new Item(AGED_BRIE, 10, 50) );
		// Act
		store.updateEndOfDay();
		String failMessage = "The Quality of an item is never more than 50";
		assertEquals(failMessage, 50, quality());
	}
	
	@Test public void testUpdateEndOfDay_AgedBrie_Quality_0_10() {
		// Arrange
		store.addItem(new Item(AGED_BRIE, 0, 10) );
		// Act
		store.updateEndOfDay();
		String failMessage = "The Quality of Aged Brie increases twice after SellIn date has passed";
		assertEquals(failMessage, 12, quality());
	}
	@Test public void testUpdateEndOfDay_AgedBrie_Quality_0_50() {
		// Arrange
		store.addItem(new Item(AGED_BRIE, 0, 50) );
		// Act
		store.updateEndOfDay();
		String failMessage = "The Quality of Aged Brie is never more than 50 increases twice after SellIn date has passed";
		assertEquals(failMessage, 50, quality());
	}
	@Test public void testUpdateEndOfDay_AgedBrie_Quality_Minus1_20() {
		// Arrange
		store.addItem(new Item(AGED_BRIE, -1, 20) );
		// Act
		store.updateEndOfDay();
		String failMessage = "The Quality of Aged Brie increases twice after SellIn date has passed";
		assertEquals(failMessage, 22, quality());
	}
	@Test public void testUpdateEndOfDay_AgedBrie_SellIn_2_10() {
		// Arrange
		store.addItem(new Item(AGED_BRIE, 2, 10) );
		// Act
		store.updateEndOfDay();
		String failMessage = "SellIn date decreases";
		assertEquals(failMessage, 1, sellIn());
	}
	
	@Test public void testUpdateEndOfDay_AgedBrie_SellIn_1_10() {
		// Arrange
		store.addItem(new Item(AGED_BRIE, 1, 10) );
		// Act
		store.updateEndOfDay();
		String failMessage = "SellIn date decreases";
		assertEquals(failMessage, 0, sellIn());
	}
	
	@Test public void testUpdateEndOfDay_AgedBrie_SellIn_0_10() {
		// Arrange
		store.addItem(new Item(AGED_BRIE, 0, 10) );
		// Act
		store.updateEndOfDay();
		String failMessage = "SellIn date decreases";
		assertEquals(failMessage, -1, sellIn());
	}
	
	@Test public void testUpdateEndOfDay_Sulfuras_Quality_0_80() {
		// Arrange
		store.addItem(new Item(SULFURAS, 0, 80) );
		// Act
		store.updateEndOfDay();
		String failMessage = "Quality of Sulfuras is 80 and never alters";
		assertEquals(failMessage, 80, quality());
	}
	
	@Test public void testUpdateEndOfDay_Sulfuras_SellIn_5_80() {
		// Arrange
		store.addItem(new Item(SULFURAS, 5, 80) );
		// Act
		store.updateEndOfDay();
		String failMessage = "Sulfuras, being a legendary item, never has to be sold";
		assertEquals(failMessage, 5, sellIn());
	}
	
	@Test public void testUpdateEndOfDay_Sulfuras_SellIn_0_80() {
		// Arrange
		store.addItem(new Item(SULFURAS, 0, 80) );
		// Act
		store.updateEndOfDay();
		String failMessage = "Sulfuras, being a legendary item, never has to be sold";
		assertEquals(failMessage, 0, sellIn());
	} 
	
	// Test Backstage pass
	@Test public void testUpdateEndOfDay_Backstage_Quality_15_20() {
		// Arrange
		store.addItem(new Item(BACKSTAGE_PASSES, 15, 20) );
		// Act
		store.updateEndOfDay();
		String failMessage = "Quality of Backstage pass increases by 1 when there are more than 10 days";
		assertEquals(failMessage, 21, quality());
	}
	
	@Test public void testUpdateEndOfDay_Backstage_Quality_10_20() {
		// Arrange
		store.addItem(new Item(BACKSTAGE_PASSES, 10, 20) );
		// Act
		store.updateEndOfDay();
		String failMessage = "Quality of Backstage pass increases by 2 when	there are 10 or less days";
		assertEquals(failMessage, 22, quality());
	}
	
	@Test public void testUpdateEndOfDay_Backstage_Quality_8_20() {
		// Arrange
		store.addItem(new Item(BACKSTAGE_PASSES, 8, 20) );
		// Act
		store.updateEndOfDay();
		String failMessage = "Quality of Backstage pass increases by 2 when there are 10 or less days";
		assertEquals(failMessage, 22, quality());
	}
	
	@Test public void testUpdateEndOfDay_Backstage_Quality_5_20() {
		// Arrange
		store.addItem(new Item(BACKSTAGE_PASSES, 5, 20) );
		// Act
		store.updateEndOfDay();
		String failMessage = "Quality of Backstage pass increases by 3 when there are 5 or less days";
		assertEquals(failMessage, 23, quality());
	}
	
	@Test public void testUpdateEndOfDay_Backstage_Quality_3_20() {
		// Arrange
		store.addItem(new Item(BACKSTAGE_PASSES, 3, 20) );
		// Act
		store.updateEndOfDay();
		String failMessage = "Quality of Backstage pass increases by 3 when	there are 5 or less days";
		assertEquals(failMessage, 23, quality());
	}
	
	@Test public void testUpdateEndOfDay_Backstage_Quality_0_20() {
		// Arrange
		store.addItem(new Item(BACKSTAGE_PASSES, 0, 20) );
		// Act
		store.updateEndOfDay();
		int quality = quality();
		String failMessage = "Quality of Backstage drops to 0 after the	concert";
		assertEquals(failMessage, 0, quality());
	}
	
	@Test public void testUpdateEndOfDay_Backstage_Quality_15_50() {
		// Arrange
		store.addItem(new Item(BACKSTAGE_PASSES, 15, 50) );
		// Act
		store.updateEndOfDay();
		String failMessage = "The Quality of an item is never more than 50";
		assertEquals(failMessage, 50, quality());
	}
	
	@Test public void testUpdateEndOfDay_Backstage_SellIn_5_10() {
		// Arrange
		store.addItem(new Item(BACKSTAGE_PASSES, 5, 10) );
		// Act
		store.updateEndOfDay();
		String failMessage = "The SellIn value should decrease by 1";
		assertEquals(failMessage, 4, sellIn());
	}
	
	// Test Elixir
	@Test public void testUpdateEndOfDay_Elixir_Quality_2_7() {
		// Arrange
		store.addItem(new Item("Elixir of the Mongoose", 2, 7) );
		// Act
		store.updateEndOfDay();
		String failMessage = "Quality decreases by 1";
		assertEquals(failMessage, 6, quality());
	}
	
	@Test public void testUpdateEndOfDay_Elixir_SellIn_2_7() {
		// Arrange
		store.addItem(new Item(ELIXIR, 2, 7) );
		// Act
		store.updateEndOfDay();
		// Assert
		String failMessage = "SelIn decreases by 1";
		assertEquals(failMessage, 1, sellIn());
	}

	private int sellIn() {
		int sellIn = store.getItems().get(0).getSellIn();
		return sellIn;
	}
}
