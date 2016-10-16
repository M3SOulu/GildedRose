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

	// Assignment 5 tests BEGIN
	//
	//
	GildedRose store = new GildedRose();

	// Test Aged Brie
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_2_10() {
		// Arrange
		store.addItem(new Item("Aged Brie", 2, 10) );
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "Quality of Aged Brie increases";
		assertEquals(failMessage, 11,quality);
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_50() {
		// Arrange
		store.addItem(new Item("Aged Brie", 10, 50) );
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "The Quality of an item is never more than 50";
		assertEquals(failMessage, 50, quality);
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_0_10() {
		// Arrange
		store.addItem(new Item("Aged Brie", 0, 10) );
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "The Quality of Aged Brie increases twice after SellIn date has passed";
		assertEquals(failMessage, 12, quality);
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_0_50() {
		// Arrange
		store.addItem(new Item("Aged Brie", 0, 50) );
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "The Quality of Aged Brie is never more than 50 increases twice after SellIn date has passed";
		assertEquals(failMessage, 50, quality);
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_Minus1_20() {
		// Arrange
		store.addItem(new Item("Aged Brie", -1, 20) );
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "The Quality of Aged Brie increases twice after SellIn date has passed";
		assertEquals(failMessage, 22, quality);
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_SellIn_2_10() {
		// Arrange
		store.addItem(new Item("Aged Brie", 2, 10) );
		// Act
		store.updateEndOfDay();
		// Assert
		int sellIn = store.getItems().get(0).getSellIn();
		String failMessage = "SellIn date decreases";
		assertEquals(failMessage, 1, sellIn);
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_SellIn_1_10() {
		// Arrange
		store.addItem(new Item("Aged Brie", 1, 10) );
		// Act
		store.updateEndOfDay();
		// Assert
		int sellIn = store.getItems().get(0).getSellIn();
		String failMessage = "SellIn date decreases";
		assertEquals(failMessage, 0, sellIn);
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_SellIn_0_10() {
		// Arrange
		store.addItem(new Item("Aged Brie", 0, 10) );
		// Act
		store.updateEndOfDay();
		// Assert
		int sellIn = store.getItems().get(0).getSellIn();
		String failMessage = "SellIn date decreases";
		assertEquals(failMessage, -1, sellIn);
	}
	
	// Test Sulfuras
	@Test
	public void testUpdateEndOfDay_Sulfuras_Quality_0_80() {
		// Arrange
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "Quality of Sulfuras is 80 and never alters";
		assertEquals(failMessage, 80, quality);
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras_SellIn_5_80() {
		// Arrange
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 5, 80) );
		// Act
		store.updateEndOfDay();
		// Assert
		int sellIn = store.getItems().get(0).getSellIn();
		String failMessage = "Sulfuras, being a legendary item, never has to be sold";
		assertEquals(failMessage, 5, sellIn);
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras_SellIn_0_80() {
		// Arrange
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
		// Act
		store.updateEndOfDay();
		// Assert
		int sellIn = store.getItems().get(0).getSellIn();
		String failMessage = "Sulfuras, being a legendary item, never has to be sold";
		assertEquals(failMessage, 0, sellIn);
	}
	
	// Test Backstage pass
	@Test
	public void testUpdateEndOfDay_Backstage_Quality_15_20() {
		// Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",
		15, 20) );
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "Quality of Backstage pass increases by 1 when there are more than 10 days";
		assertEquals(failMessage, 21, quality);
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_Quality_10_20() {
		// Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",
		10, 20) );
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "Quality of Backstage pass increases by 2 when there are 10 or less days";
		assertEquals(failMessage, 22, quality);
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_Quality_8_20() {
		// Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",
		8, 20) );
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "Quality of Backstage pass increases by 2 when there are 10 or less days";
		assertEquals(failMessage, 22, quality);
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_Quality_5_20() {
		// Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",
		5, 20) );
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "Quality of Backstage pass increases by 3 when there are 5 or less days";
		assertEquals(failMessage, 23, quality);
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_Quality_3_20() {
		// Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",
		3, 20) );
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "Quality of Backstage pass increases by 3 when there are 5 or less days";
		assertEquals(failMessage, 23, quality);
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_Quality_0_20() {
		// Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",
		0, 20) );
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "Quality of Backstage drops to 0 after the concert";
		assertEquals(failMessage, 0, quality);
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_Quality_15_50() {
		// Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",
		15, 50) );
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "The Quality of an item is never more than 50";
		assertEquals(failMessage, 50, quality);
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_SellIn_5_10() {
		// Arrange
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",
		5, 10) );
		// Act
		store.updateEndOfDay();
		// Assert
		int sellIn = store.getItems().get(0).getSellIn();
		String failMessage = "The SellIn value should decrease by 1";
		assertEquals(failMessage, 4, sellIn);
	}
	
	// Test Elixir
	@Test
	public void testUpdateEndOfDay_Elixir_Quality_2_7() {
		// Arrange
		store.addItem(new Item("Elixir of the Mongoose", 2, 7) );
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "Quality decreases by 1";
		assertEquals(failMessage, 6,quality);
	}
	
	@Test
	public void testUpdateEndOfDay_SellIn_Quality_2_7() {
		// Arrange
		store.addItem(new Item("Elixir of the Mongoose", 2, 7) );
		// Act
		store.updateEndOfDay();
		// Assert
		int sellIn = store.getItems().get(0).getSellIn();
		String failMessage = "SelIn decreases by 1";
		assertEquals(failMessage, 1, sellIn);
	}
	
	//
	//
	// Assignment 5 tests END
	
	@Test
	public void testUpdateEndOfDay_Elixir_Quality_1_0_NotNegative() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 1, 1) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay(); 
		
		// Assert
		List<Item> items = store.getItems();
		Item itemElixir = items.get(0);
		
		assertTrue(itemElixir.getQuality() == 0);
	}

	@Test
	public void testUpdateEndOfDay_Mana_Quality_1_0_NotNegative() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 1, 1) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemMana = items.get(0);
		
		assertTrue(itemMana.getQuality() == 0);
	}

	@Test
	public void testUpdateEndOfDay_DextVest_Quality_1_0_NotNegative() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 1, 1) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemDextVest = items.get(0);
		
		assertTrue(itemDextVest.getQuality() == 0);
	}
	
	@Test
	public void testUpdateEndOfDay_Elixir_Quality_10_Degrade() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemElixir = items.get(0);
		
		assertTrue(itemElixir.getQuality() < 10);
	}

	@Test
	public void testUpdateEndOfDay_Mana_Quality_10_Degrade() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemMana = items.get(0);
		
		assertTrue(itemMana.getQuality() < 10);
	}

	@Test
	public void testUpdateEndOfDay_DextVest_Quality_10_Degrade() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemDextVest = items.get(0);
		
		assertTrue(itemDextVest.getQuality() < 10);
	}
	
	@Test
	public void testUpdateEndOfDay_Elixir_SellIn_2_Decrease() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemElixir = items.get(0);
		
		assertTrue(itemElixir.getSellIn() < 2);
	}

	@Test
	public void testUpdateEndOfDay_Mana_SellIn_2_Decrease() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemMana = items.get(0);
		
		assertTrue(itemMana.getSellIn() < 2);
	}

	@Test
	public void testUpdateEndOfDay_DextVest_SellIn_2_Decrease() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemDextVest = items.get(0);
		
		assertTrue(itemDextVest.getSellIn() < 2);
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_SellIn_2_2() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(2, itemBrie.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_SellIn_2_1() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(1, itemBrie.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_SellIn_2_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(0, itemBrie.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_SellIn_2_2() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 2, 10) );
		
		// Act
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBacktage = items.get(0);
		assertEquals(2, itemBacktage.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_SellIn_2_1() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBacktage = items.get(0);
		assertEquals(1, itemBacktage.getSellIn());
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_SellIn_2_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 2, 10) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBacktage = items.get(0);
		assertEquals(0, itemBacktage.getSellIn());
	}

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
	public void testUpdateEndOfDay_AgedBrie_Quality_45_50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 100, 45) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
	}
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_45_50_Overdue_1() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 100, 45) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_45_50_Overdue_5() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 100, 45) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();

		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10) );
		
		// Act
		for (int i = 0; i < 20; i++)
			store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(0, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_Sulfuras_Day_1_Quality_80() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		assertEquals(80, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras_Day_10_Quality_80() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
		
		// Act
		for (int i = 0; i < 10; i++)
			store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		assertEquals(80, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras_Day_100_Quality_80() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
		
		// Act
		for (int i = 0; i < 100; i++)
			store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemSulfuras = items.get(0);
		assertEquals(80, itemSulfuras.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_Backstage_Quality_20_21() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) );
		
		// Act
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBackstage = items.get(0);
		assertEquals(21, itemBackstage.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_Quality_20_25() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBackstage = items.get(0);
		assertEquals(25, itemBackstage.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_Quality_20_27() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();

		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBackstage = items.get(0);
		assertEquals(27, itemBackstage.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_Backstage_Quality_20_35() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();

		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBackstage = items.get(0);
		assertEquals(35, itemBackstage.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_Backstage_Quality_20_38() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();

		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBackstage = items.get(0);
		assertEquals(38, itemBackstage.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_Backstage_Quality_20_41() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();

		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();

		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBackstage = items.get(0);
		assertEquals(41, itemBackstage.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Backstage_Quality_20_50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();

		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();

		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBackstage = items.get(0);
		assertEquals(50, itemBackstage.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_Backstage_Quality_20_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();

		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();

		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();

		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBackstage = items.get(0);
		assertEquals(0, itemBackstage.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_Backstage_Quality_20_0_Overdue_1() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50) );
		
		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();

		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();

		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();
		store.updateEndOfDay();

		store.updateEndOfDay();
		store.updateEndOfDay();
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBackstage = items.get(0);
		assertEquals(0, itemBackstage.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_Add_Item() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 0, 0) );

		store.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemElixir = items.get(0);

		assertEquals(itemElixir.getName(), "+5 Dexterity Vest");
	}

//	@Test
//	public void testUpdateEndOfDay() {
//		fail("Test not implemented");
//	}
}
