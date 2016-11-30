package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {
	
	
	@Before
	public void setup(){
		GildedRose.items = new ArrayList<Item>();
	}

	@Test
	public void updatingQualityOfANormalItemsDecreasesTheirQualityAndSellIn() {
		//Arrange
		GildedRose.items.add(new Item("Conjured Mana Cake", 3, 6));
		GildedRose.items.add(new Item("+5 Dexterity Vest", 10, 20));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(5, GildedRose.items.get(0).getQuality());
		assertEquals(2, GildedRose.items.get(0).getSellIn());
		assertEquals(19, GildedRose.items.get(1).getQuality());
		assertEquals(9, GildedRose.items.get(1).getSellIn());
	}
	
	@Test
	public void updatingQualityOfAnExpiredItemDecreasesTwiceAsFast(){
		//Arrange
		GildedRose.items.add(new Item("Conjured Mana Cake", 0, 6));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(4, GildedRose.items.get(0).getQuality());
	}
	
	@Test
	public void qualityCantBeNegative(){
		//Arrange
		GildedRose.items.add(new Item("Conjured Mana Cake", 3, 0));
		GildedRose.items.add(new Item("Conjured Mana Cake", 0, 0));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(0, GildedRose.items.get(0).getQuality());
		assertEquals(0, GildedRose.items.get(1).getQuality());
	}
	
	@Test
	public void updatingQualityOfAgedBrieIncreasesItsQuality() {
		//Arrange
		GildedRose.items.add(new Item("Aged Brie", 2, 0));
		GildedRose.items.add(new Item("Aged Brie", -1, 0));
		GildedRose.items.add(new Item("Aged Brie", -1, 60));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(1, GildedRose.items.get(0).getQuality());
		assertEquals(2, GildedRose.items.get(1).getQuality());
		assertEquals(60, GildedRose.items.get(2).getQuality());
	}
	
	@Test
	public void qualityCantBeMoreThan50() {
		//Arrange
		GildedRose.items.add(new Item("Aged Brie", 2, 50));
		GildedRose.items.add(new Item("Item", 2, 51));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(50, GildedRose.items.get(0).getQuality());
		assertEquals(50, GildedRose.items.get(1).getQuality());
	}
	
	@Test
	public void updatingQualityOfSulfuraDoesNotDecreaseItsQuality() {
		//Arrange
		GildedRose.items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		GildedRose.items.add(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(80, GildedRose.items.get(0).getQuality());
		assertEquals(80, GildedRose.items.get(1).getQuality());
	}
	
	@Test
	public void sulfurasSellInDoesNotDecrease() {
		//Arrange
		GildedRose.items.add(new Item("Sulfuras, Hand of Ragnaros", 1, 80));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(1, GildedRose.items.get(0).getSellIn());
	}
	
	@Test
	public void updatingQualityOfBackstagePassesIncreasesItsQuality() {
		//Arrange
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 60));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(21, GildedRose.items.get(0).getQuality());
		assertEquals(60, GildedRose.items.get(1).getQuality());
	}
	
	@Test
	public void updatingQualityOfBackstagePassesIncreasesBy2WhenThereAre10DaysOrLess() {
		//Arrange
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(22, GildedRose.items.get(0).getQuality());
		assertEquals(50, GildedRose.items.get(1).getQuality());
	}
	
	@Test
	public void updatingQualityOfBackstagePassesIncreasesBy3WhenThereAre5DaysOrLess() {
		//Arrange
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 4, 49));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(23, GildedRose.items.get(0).getQuality());
		assertEquals(50, GildedRose.items.get(1).getQuality());
	}
	
	@Test
	public void updatingQualityOfBackstagePassesDropsQualityTo0IfDateIsPassed() {
		//Arrange
		GildedRose.items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
		//Act
		GildedRose.updateQuality();
		//Assert
		assertEquals(0, GildedRose.items.get(0).getQuality());
	}
	
}
