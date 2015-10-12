package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {
	
	private List<Item> items;
	private GildedRose rose;
	
	@Before
	public void setup() {
		items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
	}
	
	@Test
	public void testDexterityVestQualityDecreaseByOne() {
		int quality = 0;
		rose = new GildedRose(items, 1);
		Item item = rose.getItemByName("Dexterity");
		if (item != null) {
			quality = item.getQuality();
		}
		assertEquals(19, quality);
	}
	
	
	@Test
	public void testDexterityVestSellInDropToZero() {
		int sellIn = 10;
		rose = new GildedRose(items, 25);
		Item item = rose.getItemByName("Dexterity");
		if (item != null) {
			assertEquals(0, item.getSellIn());
		}
	}
	
	@Test
	public void testSulfurasQuality80After90Days() {
		int quality = 0;
		rose = new GildedRose(items, 90);
		Item item = rose.getItemByName("Sulfuras");
		if (item != null) {
			quality = item.getQuality();
		}
		assertEquals(80, quality);
	}
	
	@Test
	public void testDecreaseQualityBy2IfSellIn0() {
		int quality = 0;
		Item item = new Item("Kalamiehen kalapata", 0, 4);
		items.add(item);
		rose = new GildedRose(items, 1);
		Item item2 = rose.getItemByName("Kalamiehen");
		if (item2 != null) {
			quality = item2.getQuality();
		}
		assertEquals(2, quality);
	}
	
	@Test
	public void testBackstagePassQualityDropsTo0() {
		int quality = 50;
		rose = new GildedRose(items, 25);
		Item item = rose.getItemByName("Backstage");
		if (item != null) {
			quality = item.getQuality();
		}
		assertEquals(0, quality);
	}
	
	@Test
	public void testBackstagePassQualityIncreasesTo50After15Days() {
		int quality = 0;
		rose = new GildedRose(items, 15);
		Item item = rose.getItemByName("Backstage");
		if (item != null) {
			quality = item.getQuality();
		}
		assertEquals(50, quality);
	}
	
	@Test
	public void testBackstagePassQualityIncreaseBy3() {
		int quality = 0;
		List<Item> items = new ArrayList();
		items.add(new Item("Backstage", 5, 10));
		rose = new GildedRose(items, 1);
		Item item2 = rose.getItemByName("Backstage");
		if (item2 != null) {
			quality = item2.getQuality();
		}
		assertEquals(13, quality);
	}

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
}
