package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import fi.oulu.tol.sqat.GildedRose;

import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {
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

}
