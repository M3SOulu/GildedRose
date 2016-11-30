package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;

public class GildedRoseTest {

	@Test
	public void testQualityNormalItem() {
		GildedRose.addItem("+5 Dexterity Vest", 10, 20);
		GildedRose.updateQuality();
		int quality  = GildedRose.getItem("+5 Dexterity Vest").getQuality();
		assertEquals(19, quality);
	}
	
	@Test
	public void testSellinNormalItem() {
		GildedRose.addItem("+5 Dexterity Vest", 10, 20);
		GildedRose.updateQuality();
		int sellin  = GildedRose.getItem("+5 Dexterity Vest").getSellIn();
		assertEquals(9, sellin);
	}
	
	@Test
	public void testQualityNeverNegative() {
		GildedRose.addItem("+5 Dexterity Vest", 10,0);
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		int quality  = GildedRose.getItem("+5 Dexterity Vest").getQuality();
		assertEquals(0, quality);
	}
	
	@Test
	public void testQualityAgedBrie() {
		GildedRose.addItem("Aged Brie", 2, 49);
		GildedRose.updateQuality();
		int quality  = GildedRose.getItem("Aged Brie").getQuality();
		assertEquals(50, quality);
	}
	@Test
	public void testQualityNeverGreaterThan50() {
		GildedRose.addItem("Aged Brie", 2, 49);
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		int quality  = GildedRose.getItem("Aged Brie").getQuality();
		assertEquals(50, quality);
	}
	@Test
	public void testQualitySulfuras() {
		GildedRose.addItem("Sulfuras, Hand of Ragnaros",0, 80);
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		int quality  = GildedRose.getItem("Sulfuras, Hand of Ragnaros").getQuality();
		assertEquals(80, quality);
	}
	
	@Test
	public void testQualityIncreasesLessThan10DaysBackstage() {
		GildedRose.addItem("Backstage passes to a TAFKAL80ETC concert",9, 20);
		GildedRose.updateQuality();
		int quality  = GildedRose.getItem("Backstage passes to a TAFKAL80ETC concert").getQuality();
		assertEquals(22, quality);
	}
	@Test
	public void testQualityIncreasesLessThan3DaysBackstage() {
		GildedRose.addItem("Backstage passes to a TAFKAL80ETC concert",5, 20);
		GildedRose.updateQuality();
		int quality  = GildedRose.getItem("Backstage passes to a TAFKAL80ETC concert").getQuality();
		assertEquals(23, quality);
	}
	@Test
	public void testQualityDropTo0Backstage() {
		GildedRose.addItem("Backstage passes to a TAFKAL80ETC concert",-1, 20);
		GildedRose.updateQuality();
		int quality  = GildedRose.getItem("Backstage passes to a TAFKAL80ETC concert").getQuality();
		assertEquals(0, quality);
	}

	@Test
	public void testQualityAgedBrieAfterSellin() {
		GildedRose.addItem("Aged Brie", -2, 20);
		GildedRose.updateQuality();
		int quality  = GildedRose.getItem("Aged Brie").getQuality();
		assertEquals(22, quality);
	}

	@Test
	public void testQualityNormalItemAfterSellin() {
		GildedRose.addItem("Elixir of the Mongoose", -2, 20);
		GildedRose.updateQuality();
		int quality  = GildedRose.getItem("Elixir of the Mongoose").getQuality();
		assertEquals(18, quality);
	}

	@Test
	public void testQualityLegendaryItemAfterSellin() {
		GildedRose.addItem("Sulfuras, Hand of Ragnaros", -2, 20);
		GildedRose.updateQuality();
		int quality  = GildedRose.getItem("Sulfuras, Hand of Ragnaros").getQuality();
		assertEquals(20, quality);
	}

	@Test
	public void testQualityTickettemAfterSellin() {
		GildedRose.addItem("Backstage passes to a TAFKAL80ETC concert", -2, 20);
		GildedRose.updateQuality();
		int quality  = GildedRose.getItem("Backstage passes to a TAFKAL80ETC concert").getQuality();
		assertEquals(0, quality);
	}

	@Test
	public void testQualityTickettemBeforeSellin() {
		GildedRose.addItem("Backstage passes to a TAFKAL80ETC concert", 4, 20);
		GildedRose.updateQuality();
		int quality  = GildedRose.getItem("Backstage passes to a TAFKAL80ETC concert").getQuality();
		assertEquals(23, quality);
		int sellin  = GildedRose.getItem("Backstage passes to a TAFKAL80ETC concert").getSellIn();
		assertEquals(3, sellin);
	}

	@Test
	public void testQualityTicket() {
		GildedRose.addItem("Backstage passes to a TAFKAL80ETC concert", 20, 20);
		GildedRose.updateQuality();
		int quality  = GildedRose.getItem("Backstage passes to a TAFKAL80ETC concert").getQuality();
		assertEquals(21, quality);
		int sellin  = GildedRose.getItem("Backstage passes to a TAFKAL80ETC concert").getSellIn();
		assertEquals(19, sellin);
	}

	@Test
	public void testQualityTicketAfter50() {
		GildedRose.addItem("Backstage passes to a TAFKAL80ETC concert", 4, 49);
		GildedRose.updateQuality();
		int quality  = GildedRose.getItem("Backstage passes to a TAFKAL80ETC concert").getQuality();
		assertEquals(50, quality);
		int sellin  = GildedRose.getItem("Backstage passes to a TAFKAL80ETC concert").getSellIn();
		assertEquals(3, sellin);
	}

	@Test
	public void testQualityConjuredItem() {
		GildedRose.addItem("Conjured Fish", 19, 30);
		GildedRose.updateQuality();
		int quality  = GildedRose.getItem("Conjured Fish").getQuality();
		assertEquals(28, quality);
		int sellin  = GildedRose.getItem("Conjured Fish").getSellIn();
		assertEquals(18, sellin);
	}

	@Test
	public void testQualityConjuredItemAfterSellin() {
		GildedRose.addItem("Conjured Fish", -2, 30);
		GildedRose.updateQuality();
		int quality  = GildedRose.getItem("Conjured Fish").getQuality();
		assertEquals(26, quality);
		int sellin  = GildedRose.getItem("Conjured Fish").getSellIn();
		assertEquals(-3, sellin);
	}

}
