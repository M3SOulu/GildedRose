package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseSellInTest {
	
	@Before
	public void setUp() {
		GildedRose.items = new ArrayList<>();

	}

	@Test
	public void testSellIn() {
		
		// Arrange
		GildedRose.items.add(new Item("+5 Dexterity Vest", 10, 20));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(9, GildedRose.items.get(0).getSellIn());
	}
	
	@Test
	public void testSellInLegendaryItem() {
		
		// Arrange
		GildedRose.items.add(new Item("Sulfuras, Hand of Ragnaros", 10, 20));
		// Act
		GildedRose.updateQuality();
		// Assert
		assertEquals(10, GildedRose.items.get(0).getSellIn());
	}

}
