package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import fi.oulu.tol.sqat.GildedRose;

import fi.oulu.tol.sqat.Item;

public class GildedRoseQualityTest {
	@Before
	public void setUp() {
		GildedRose.items = new ArrayList<>();

	}

	@Test
	public void testQuality() {
		
		// Arrange
		GildedRose.items.add(new Item("+5 Dexterity Vest", 10, 20));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(19, GildedRose.items.get(0).getQuality());
	}

	
	@Test
	public void testQualityandSell() {
		// Arrange

		GildedRose.items.add(new Item("+5 Dexterity Vest", 0, 20));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(18, GildedRose.items.get(0).getQuality());
	}

	@Test
	public void testQualityNegative() {
		// Arrange

		GildedRose.items.add(new Item("+5 Dexterity Vest", 1, 0));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(0, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testSellMinor0QualityMajor0() {
		// Arrange

		GildedRose.items.add(new Item("+5 Dexterity Vest", -1, 1));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(0, GildedRose.items.get(0).getQuality());
	}


	@Test
	public void testQualityAgedBrie() {
		// Arrange

	GildedRose.items.add(new Item("Aged Brie", 2, 0));
		// Act
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		// Assert
		assertEquals(2, GildedRose.items.get(0).getQuality());
	}

	@Test
	public void testQualityNeverMore50() {
		
		// Arrange
		GildedRose.items.add(new Item("Aged Brie", 2, 50));
		// Act
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		// Assert
		assertEquals(50, GildedRose.items.get(0).getQuality());
	}

	@Test
	public void testQualitySulfuras() {
		
		// Arrange
		GildedRose.items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		// Act
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		// Assert
		assertEquals(80, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testQualitySellMinor0() {
		
		// Arrange
		GildedRose.items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		// Act
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		// Assert
		assertEquals(80, GildedRose.items.get(0).getQuality());
	}

	@Test
	public void testQualityLegendaryItemsWithTenDays() {
		
		// Arrange
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(22, GildedRose.items.get(0).getQuality());
	}

	@Test
	public void testQualityLegendaryItemsWith5Days() {
		
		// Arrange
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(23, GildedRose.items.get(0).getQuality());
	}

	@Test
	public void testQualityLegendaryItemsWith0Days() {
		// Arrange

		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(0, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testQualityLegendarySellMinor11QualityMinor50() {
		
		// Arrange
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 32));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(34, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testQualityLegendarySellMajor11QualityMinor50() {
		
		// Arrange
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 32));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(33, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testQualityLegendarySellMinor11QualityMajor50() {
		
		// Arrange
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(50, GildedRose.items.get(0).getQuality());
	}
	
	
	

	
	@Test
	public void testQualityLegendarySellMinor6QualityMinor50() {
		
		// Arrange
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 43));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(46, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testQualityLegendarySellMinor6QualityMajor50() {
		
		// Arrange
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(50, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testQualitySellMinor0NotAgedBrie() {
		
		// Arrange
		GildedRose.items.add(new Item("Sulfuras, Hand of Ragnaros", -1, -1));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(-1, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testQualitySellMinor0QaulityMajor0NotAgedBrie() {
		
		// Arrange
		GildedRose.items.add(new Item("Sulfuras, Hand of Ragnaros", -1, 1));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(1, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testQualityMajor50AgedBrie() {
		
		// Arrange
		GildedRose.items.add(new Item("Aged Brie", -1, 50));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(50, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testQualityMinor50AgedBrie() {
		
		// Arrange
		GildedRose.items.add(new Item("Aged Brie", 1, 49));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(50, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testQualitySellMinor0AgedBrie() {
		
		// Arrange
		GildedRose.items.add(new Item("Aged Brie", -1, -1));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(1, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testQualityLegendarySellMinor0Backstage() {
		
		// Arrange
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", -1, -1));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(0, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testQualityConjuredItem() {
		
		// Arrange
		GildedRose.items.add(new Item("Conjured", 4, 18));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(16, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testQualityConjuredItemSell0() {
		
		// Arrange
		GildedRose.items.add(new Item("Conjured", 0, 18));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(14, GildedRose.items.get(0).getQuality());
	}

}
