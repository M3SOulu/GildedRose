package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

/**
 * characterization tests
 * @author Luigi
 *
 */
public class GildedRoseTest {
	private GildedRose gr;
	
	@Before
	public void setUp(){
		gr = new GildedRose();
	}

	@Test
	public void testDecreaseQualitySellInSingleItem() {
		//Arrange
		gr.add(new Item("+5 Dexterity Vest", 10, 20));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(9, gr.get(0).getSellIn());
		assertEquals(19, gr.get(0).getQuality());
	}

	@Test
	public void testDecreaseQualityDegradesTwiceOnceSellinHasPassed() {
		//Arrange
		gr.add(new Item("+5 Dexterity Vest", 0, 20));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(-1, gr.get(0).getSellIn());
		assertEquals(18, gr.get(0).getQuality());
	}

	@Test
	public void testQualityIsNeverNegative() {
		//Arrange
		gr.add(new Item("+5 Dexterity Vest", 2, 0));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(1, gr.get(0).getSellIn());
		assertEquals(0, gr.get(0).getQuality());
	}

	@Test
	public void testQualityIncreasesWithBrieItem() {
		//Arrange
		gr.add(new Item("Aged Brie", 2, 0));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(1, gr.get(0).getSellIn());
		assertEquals(1, gr.get(0).getQuality());
	}
	
	@Test
	public void testQualityEqualsWithBrieItemQualityGreaterThan50AndNegativeSellIn() {
		//Arrange
		gr.add(new Item("Aged Brie", -1, 51));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(-2, gr.get(0).getSellIn());
		assertEquals(51, gr.get(0).getQuality());
	}

	@Test
	public void testQualityIsNeverMoreThan50() {
		//Arrange
		gr.add(new Item("Aged Brie", 2, 50));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(1, gr.get(0).getSellIn());
		assertEquals(50, gr.get(0).getQuality());
	}
	
	@Test
	public void testQualityIncreaseWithBrieItemAndSellInLowerThan0() {
		//Arrange
		gr.add(new Item("Aged Brie", -1, 30));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(-2, gr.get(0).getSellIn());
		assertEquals(32, gr.get(0).getQuality());
	}
	
	
	
	@Test
	public void testQualityEqualsSellInAndQualityLowerThan0() {
		//Arrange
		gr.add(new Item("+5 Dexterity Vest", -1, -5));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(-2, gr.get(0).getSellIn());
		assertEquals(-5, gr.get(0).getQuality());
	}

	@Test
	public void testLegendaryItem() {
		//Arrange
		gr.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(0, gr.get(0).getSellIn());
		assertEquals(80, gr.get(0).getQuality());
	}
	
	@Test
	public void testLegendaryItemWithNegativeSellIn() {
		//Arrange
		gr.add(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(-1, gr.get(0).getSellIn());
		assertEquals(80, gr.get(0).getQuality());
	}

	@Test
	public void testBackstagePassesIncreaseQuality() {
		//Arrange
		gr.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(14, gr.get(0).getSellIn());
		assertEquals(21, gr.get(0).getQuality());
	}
	
	@Test
	public void testBackstagePassesIncreaseQualityBy2With10SellinDaysOrLess() {
		//Arrange
		gr.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(9, gr.get(0).getSellIn());
		assertEquals(22, gr.get(0).getQuality());
	}
	
	@Test
	public void testBackstagePassesIncreaseQualityBy1With10SellinDaysOrLessAnd49Quality() {
		//Arrange
		gr.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(9, gr.get(0).getSellIn());
		assertEquals(50, gr.get(0).getQuality());
	}
	
	@Test 
	public void testBackstagePassesIncreaseQualityBy1With5SellinDaysOrLessAnd49Quality() {
		//Arrange
		gr.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(4, gr.get(0).getSellIn());
		assertEquals(50, gr.get(0).getQuality());
	}
	
	@Test
	public void testBackstagePassesIncreaseQualityBy3With5SellinDaysOrLess() {
		//Arrange
		gr.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(4, gr.get(0).getSellIn());
		assertEquals(23, gr.get(0).getQuality());
	}
	
	@Test
	public void testBackstagePassesQualityDropsTo0AfterConcert() {
		//Arrange
		gr.add(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 23));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(-1, gr.get(0).getSellIn());
		assertEquals(0, gr.get(0).getQuality());
	}
	
	




}
