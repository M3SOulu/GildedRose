package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	@Before
	public void setUp(){
		GildedRose.items = new ArrayList<Item>();
	}

	@Test
	public void testDecreaseQualitySellInSingleItem() {
		//Arrange
		GildedRose.items.add(new Item("+5 Dexterity Vest", 10, 20));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(9, GildedRose.items.get(0).getSellIn());
		assertEquals(19, GildedRose.items.get(0).getQuality());
	}

	@Test
	public void testDecreaseQualityDegradesTwiceOnceSellinHasPassed() {
		//Arrange
		GildedRose.items.add(new Item("+5 Dexterity Vest", 0, 20));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(-1, GildedRose.items.get(0).getSellIn());
		assertEquals(18, GildedRose.items.get(0).getQuality());
	}

	@Test
	public void testQualityIsNeverNegative() {
		//Arrange
		GildedRose.items.add(new Item("+5 Dexterity Vest", 2, 0));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(1, GildedRose.items.get(0).getSellIn());
		assertEquals(0, GildedRose.items.get(0).getQuality());
	}

	@Test
	public void testQualityIncreasesWithBrieItem() {
		//Arrange
		GildedRose.items.add(new Item("Aged Brie", 2, 0));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(1, GildedRose.items.get(0).getSellIn());
		assertEquals(1, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testQualityEqualsWithBrieItemQualityGreaterThan50AndNegativeSellIn() {
		//Arrange
		GildedRose.items.add(new Item("Aged Brie", -1, 51));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(-2, GildedRose.items.get(0).getSellIn());
		assertEquals(51, GildedRose.items.get(0).getQuality());
	}

	@Test
	public void testQualityIsNeverMoreThan50() {
		//Arrange
		GildedRose.items.add(new Item("Aged Brie", 2, 50));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(1, GildedRose.items.get(0).getSellIn());
		assertEquals(50, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testQualityIncreaseWithBrieItemAndSellInLowerThan0() {
		//Arrange
		GildedRose.items.add(new Item("Aged Brie", -1, 30));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(-2, GildedRose.items.get(0).getSellIn());
		assertEquals(32, GildedRose.items.get(0).getQuality());
	}
	
	
	
	@Test
	public void testQualityEqualsSellInAndQualityLowerThan0() {
		//Arrange
		GildedRose.items.add(new Item("+5 Dexterity Vest", -1, -5));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(-2, GildedRose.items.get(0).getSellIn());
		assertEquals(-5, GildedRose.items.get(0).getQuality());
	}

	@Test
	public void testLegendaryItem() {
		//Arrange
		GildedRose.items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(0, GildedRose.items.get(0).getSellIn());
		assertEquals(80, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testLegendaryItemWithNegativeSellIn() {
		//Arrange
		GildedRose.items.add(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(-1, GildedRose.items.get(0).getSellIn());
		assertEquals(80, GildedRose.items.get(0).getQuality());
	}

	@Test
	public void testBackstagePassesIncreaseQuality() {
		//Arrange
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(14, GildedRose.items.get(0).getSellIn());
		assertEquals(21, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testBackstagePassesIncreaseQualityBy2With10SellinDaysOrLess() {
		//Arrange
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(9, GildedRose.items.get(0).getSellIn());
		assertEquals(22, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testBackstagePassesIncreaseQualityBy1With10SellinDaysOrLessAnd49Quality() {
		//Arrange
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(9, GildedRose.items.get(0).getSellIn());
		assertEquals(50, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testBackstagePassesIncreaseQualityBy1With5SellinDaysOrLessAnd49Quality() {
		//Arrange
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(4, GildedRose.items.get(0).getSellIn());
		assertEquals(50, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testBackstagePassesIncreaseQualityBy3With5SellinDaysOrLess() {
		//Arrange
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(4, GildedRose.items.get(0).getSellIn());
		assertEquals(23, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void testBackstagePassesQualityDropsTo0AfterConcert() {
		//Arrange
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 23));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(-1, GildedRose.items.get(0).getSellIn());
		assertEquals(0, GildedRose.items.get(0).getQuality());
	}
	
	




}
