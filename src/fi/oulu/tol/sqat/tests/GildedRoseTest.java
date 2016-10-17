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
	private GildedRose store = new GildedRose();

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
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

		// Act
		store.updateEndOfDay();
		// Assert
		List<Item> items = store.getItems();
		assertEquals("Empty store doesnt return empty list", 0, items.size());
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_0_1() {
		// Arrange
		
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
	
	// Test Aged Brie @Test
	public void testUpdateEndOfDay_AgedBrie_Quality_2_10() { 
		// Arrange
		store.addItem(new Item("Aged Brie", 2, 10) );
		// Act
		store.updateEndOfDay();
		// Assert
		int quality = store.getItems().get(0).getQuality(); String failMessage = "Quality of Aged Brie increases";
		assertEquals(failMessage, 11,quality);
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_50() { 
		// Arrange
		store.addItem(new Item("Aged Brie", 10, 50) ); 
		// Act
		store.updateEndOfDay(); // Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "The Quality of an item is never more than 50";
		assertEquals(failMessage, 50, quality);
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_0_10() { 
		// Arrange
		store.addItem(new Item("Aged Brie", 0, 10) ); 
		// Act
		store.updateEndOfDay(); // Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "The Quality of Aged Brie increases twice after SellIn date has passed";
		assertEquals(failMessage, 12, quality);
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_0_50() { 
		// Arrange
		store.addItem(new Item("Aged Brie", 0, 50) ); 
		// Act
		store.updateEndOfDay(); // Assert
		int quality = store.getItems().get(0).getQuality();
		String failMessage = "The Quality of Aged Brie is never more than 50 increases twice after SellIn date has passed";
		assertEquals(failMessage, 50, quality);
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_Minus1_20() { 
		// Arrange
		store.addItem(new Item("Aged Brie", -1, 20) ); 
		// Act
		store.updateEndOfDay(); // Assert
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
		int sellIn = store.getItems().get(0).getSellIn(); String failMessage = "SellIn date decreases"; assertEquals(failMessage, 1, sellIn);
	}
	
	@Test
	public void testUpdateEndOfDay_AgedBrie_SellIn_1_10() { 
		// Arrange
		store.addItem(new Item("Aged Brie", 1, 10) ); 
		// Act
		store.updateEndOfDay();
		// Assert
		int sellIn = store.getItems().get(0).getSellIn(); String failMessage = "SellIn date decreases"; assertEquals(failMessage, 0, sellIn);
	}
	
	@Test
		public void testUpdateEndOfDay_AgedBrie_SellIn_0_10() { 
		// Arrange
		store.addItem(new Item("Aged Brie", 0, 10) ); 
		// Act
		store.updateEndOfDay();
		// Assert
		int sellIn = store.getItems().get(0).getSellIn(); String failMessage = "SellIn date decreases"; assertEquals(failMessage, -1, sellIn);
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
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) );
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
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 8, 20) );
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
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",5, 20) );
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
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20) );
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
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) );
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
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50) );
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
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",5, 10) );
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
}
