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
		updateXtimes(store,1);
		
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(11, itemBrie.getQuality());
	}
    
	@Test
	public void testUpdateEndOfDay_normalItem_Quality_30_29() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("chocolate", 20, 30) );
		
		// Act
		updateXtimes(store, 1);
		
		// Assert
		List<Item> items = store.getItems();
		Item itemChocolate = items.get(0);
		assertEquals(29, itemChocolate.getQuality());
	}
    
	@Test
	public void testUpdateEndOfDay_normalItem_Quality_30_25() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("chocolate", 20, 30) );
		
		// Act
		updateXtimes(store, 5);
		
		// Assert
		List<Item> items = store.getItems();
		Item itemChocolate = items.get(0);
		assertEquals(25, itemChocolate.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_normalItem_Quality_10_6() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("chocolate", 2, 10) );
		
		// Act
		updateXtimes(store, 3);
		
		// Assert
		List<Item> items = store.getItems();
		Item itemChocolate = items.get(0);
		assertEquals(6, itemChocolate.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_normalItem_Quality_10_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("chocolate", 2, 10) );
		
		// Act
		updateXtimes(store, 13);
		
		// Assert
		List<Item> items = store.getItems();
		Item itemChocolate = items.get(0);
		assertEquals(0, itemChocolate.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_brieItem_Quality_40_50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 40) );
		
		// Act
		updateXtimes(store, 13);
		
		// Assert
		List<Item> items = store.getItems();
		Item itemChocolate = items.get(0);
		assertEquals(50, itemChocolate.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_backPassItem_Quality_20_0() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		
		// Act
		updateXtimes(store, 16);
		
		// Assert
		List<Item> items = store.getItems();
		Item itemChocolate = items.get(0);
		assertEquals(0, itemChocolate.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_backPassItem_Quality_20_50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		
		// Act
		updateXtimes(store, 15);
		
		// Assert
		List<Item> items = store.getItems();
		Item itemChocolate = items.get(0);
		assertEquals(50, itemChocolate.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_backPassItem_Quality_20_24() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		
		// Act
		updateXtimes(store, 4);
		
		// Assert
		List<Item> items = store.getItems();
		Item itemChocolate = items.get(0);
		assertEquals(24, itemChocolate.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_backPassItem_Quality_20_27() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		
		// Act
		updateXtimes(store, 6);
		
		// Assert
		List<Item> items = store.getItems();
		Item itemChocolate = items.get(0);
		assertEquals(27, itemChocolate.getQuality());
	}
	
	
	@Test
	public void testUpdateEndOfDay_backPassItem_Quality_20_41() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		
		// Act
		updateXtimes(store, 12);
		
		// Assert
		List<Item> items = store.getItems();
		Item itemChocolate = items.get(0);
		assertEquals(41, itemChocolate.getQuality());
	}
	
	@Test
	public void testUpdateEndOfDay_sulfurasItem_Quality_20_80() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		// Act
		updateXtimes(store, 121);
		
		// Assert
		List<Item> items = store.getItems();
		Item itemChocolate = items.get(0);
		assertEquals(80, itemChocolate.getQuality());
	}
	
	private void updateXtimes(GildedRose store, int x) {
		for(int i = 0; i < x; i++){
			store.updateEndOfDay();
		}
	}
}
