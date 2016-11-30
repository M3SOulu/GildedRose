package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	@Test
	public void dexterityVestQualityIsEqualNineteen() {
		GildedRose gildedRose = new GildedRose();
		List<Item> item = gildedRose.getItems();
		
		assertEquals(item.get(0).getQuality(), 19);
	}
	
	@Test
	public void dexterityVestSellInIsEqualOne() {
		GildedRose gildedRose = new GildedRose();
		List<Item> item = gildedRose.getItems();
		
		assertEquals(item.get(0).getSellIn(), 9);
	}
	
	@Test
	public void agedBrieQualityIsEqualOne() {
		GildedRose gildedRose = new GildedRose();
		List<Item> item = gildedRose.getItems();
		
		assertEquals(item.get(1).getQuality(), 1);
	}
	
	@Test
	public void agedBrieSellInIsEqualOne() {
		GildedRose gildedRose = new GildedRose();
		List<Item> item = gildedRose.getItems();
		
		assertEquals(item.get(1).getSellIn(), 1);
	}
	
	@Test
	public void agedBrieSellInIsEqualZero() {
		GildedRose gildedRose = new GildedRose();
		List<Item> item = gildedRose.getItems();
		GildedRose.updateQuality();
		
		assertEquals(item.get(1).getSellIn(), 0);
	}
	
	@Test
	public void agedBrieSellInIsEqualMenusOne() {
		GildedRose gildedRose = new GildedRose();
		List<Item> item = gildedRose.getItems();
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		
		for(int i = 1; i <= 25; i++) {
			GildedRose.updateQuality();
		}
		
		
		assertEquals(item.get(1).getSellIn(), -26);
		assertEquals(item.get(1).getQuality(), 50);
	}
	
	@Test
	public void sulfurasSellInIsEqualZero() {
		GildedRose gildedRose = new GildedRose();
		List<Item> item = gildedRose.getItems();
		
		assertEquals(item.get(3).getSellIn(), 0);
	}
	
	@Test
	public void backstageQualityIncreasesByOneWhenSellinIsTenOrLess() {
		GildedRose gildedRose = new GildedRose();
		List<Item> item = gildedRose.getItems();
		
		assertEquals(item.get(4).getQuality(), 21);
	}
	
	@Test
	public void backstageQualityIncreasesByTwoWhenSellinIsThreeOrLess() {
		GildedRose gildedRose = new GildedRose();
		List<Item> item = gildedRose.getItems();
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		GildedRose.updateQuality();
		
		assertEquals(item.get(4).getQuality(), 27);
	}
	
}
