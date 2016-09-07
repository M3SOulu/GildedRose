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
		Item itemSulfuras = items.get(0);
		assertEquals(80, itemSulfuras.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_Sulfuras_Day_100_Quality_80() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
		
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
	public void testUpdateEndOfDay() {
		fail("Test not implemented");
	}
}
