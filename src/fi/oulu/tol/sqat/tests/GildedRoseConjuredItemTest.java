package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseConjuredItemTest {
	private GildedRose gr;

	@Before
	public void setUp(){
		gr = new GildedRose();
	}

	@Test
	public void testConjuredItemDegradeQualityTwice() {
		//Arrange
		gr.add(new Item("Conjured Mana Cake", 3, 6));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(2, gr.get(0).getSellIn());
		assertEquals(4, gr.get(0).getQuality());
	}
	
	@Test
	public void testConjuredItemDegradeQualityTwiceWithSellInLowerThan0() {
		//Arrange
		gr.add(new Item("Conjured Mana Cake", 0, 6));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(-1, gr.get(0).getSellIn());
		assertEquals(2, gr.get(0).getQuality());
	}
	
	@Test
	public void testConjuredItemQualityIsNeverLowerThan0() {
		//Arrange
		gr.add(new Item("Conjured Mana Cake", 0, 2));
		//Act
		gr.updateQuality();
		//Assert
		assertEquals(-1, gr.get(0).getSellIn());
		assertEquals(0, gr.get(0).getQuality());
	}

}
