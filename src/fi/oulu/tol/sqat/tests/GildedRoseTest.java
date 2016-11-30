package fi.oulu.tol.sqat.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;

public class GildedRoseTest {

	public static GildedRose gild;
	
	@Before
	public void setUp(){
		gild = new GildedRose();
	}
	
	@Test
	public void testFirstItem() {
		GildedRose.updateQuality();
		Assert.assertEquals(9, gild.getItem(0).getSellIn());
		Assert.assertEquals(19, gild.getItem(0).getQuality());
	}
	
	@Test
	public void testSecondItem() {
		GildedRose.updateQuality();
		Assert.assertEquals(1, gild.getItem(1).getSellIn());
		Assert.assertEquals(1, gild.getItem(1).getQuality());
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		Assert.assertEquals(-1, gild.getItem(1).getSellIn());
		Assert.assertEquals(4, gild.getItem(1).getQuality());
		GildedRose.updateQuality();
		Assert.assertEquals(-2, gild.getItem(1).getSellIn());
		Assert.assertEquals(6, gild.getItem(1).getQuality());
	}
	
	@Test
	public void testThirdItem() {
		GildedRose.updateQuality();
		Assert.assertEquals(4, gild.getItem(2).getSellIn());
		Assert.assertEquals(6, gild.getItem(2).getQuality());
		GildedRose.updateQuality();
		Assert.assertEquals(3, gild.getItem(2).getSellIn());
		Assert.assertEquals(5, gild.getItem(2).getQuality());
	}
	
	@Test
	public void testFourthItem() {
		GildedRose.updateQuality();
		Assert.assertEquals(0, gild.getItem(3).getSellIn());
		Assert.assertEquals(80, gild.getItem(3).getQuality());
	}
	
	@Test
	public void testFifthItem() {
		GildedRose.updateQuality();
		Assert.assertEquals(14, gild.getItem(4).getSellIn());
		Assert.assertEquals(21, gild.getItem(4).getQuality());
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		Assert.assertEquals(10, gild.getItem(4).getSellIn());
		Assert.assertEquals(25, gild.getItem(4).getQuality());
		GildedRose.updateQuality();
		Assert.assertEquals(9, gild.getItem(4).getSellIn());
		Assert.assertEquals(27, gild.getItem(4).getQuality());
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		Assert.assertEquals(4, gild.getItem(4).getSellIn());
		Assert.assertEquals(38, gild.getItem(4).getQuality());
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		Assert.assertEquals(-1, gild.getItem(4).getSellIn());
		Assert.assertEquals(0, gild.getItem(4).getQuality());
	}
	
	@Test
	public void testSixthItem() {
		GildedRose.updateQuality();
		Assert.assertEquals(2, gild.getItem(5).getSellIn());
		Assert.assertEquals(4, gild.getItem(5).getQuality());
	}
}
