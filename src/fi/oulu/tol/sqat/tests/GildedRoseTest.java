package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {
	
	GildedRose locanda;
	
	
	@Before
	public void setUp(){
		locanda = new GildedRose();
		locanda.main(null);
		
		
	}

	@Test
	public void regularItemDecreasesQuality() {			
		
		assertEquals(19, locanda.items.get(0).getQuality());
	}
	
	@Test
	public void regularItemDecreasesSellin() {			
		
		assertEquals(9, locanda.items.get(0).getSellIn());
	}
	
	@Test
	public void regularItemsWhithSellinEquals0DecreasesQualityTwice() {
		locanda.items.get(0).setSellIn(0);
		locanda.updateQuality();
		
		assertEquals(17, locanda.items.get(0).getQuality());
	}
	
	@Test
	public void regularItemsWhithQualityEquals0() {
		locanda.items.get(0).setQuality(-1);
		locanda.updateQuality();
		
		assertEquals(-1, locanda.items.get(0).getQuality());
	}
	
	@Test
	public void regularItemsWhithQualityLessThan0WhithSellinLessThan0() {
		locanda.items.get(0).setSellIn(0);
		locanda.items.get(0).setQuality(-1);
		locanda.updateQuality();
		
		assertEquals(-1, locanda.items.get(0).getQuality());
	}
	
		
	@Test
	public void brieItemDecreasesSellin() {			
		
		assertEquals(1, locanda.items.get(1).getSellIn());
	}
	
	@Test
	public void brieItemIncrementQuality() {			
		
		assertEquals(1, locanda.items.get(1).getQuality());
	}
	
	@Test
	public void brieItemWhitSellin0IncrementQuality() {	
		
		locanda.items.get(1).setSellIn(0);
		locanda.updateQuality();
		
		assertEquals(3, locanda.items.get(1).getQuality());
	}
	
	@Test
	public void brieItemsWhithQualityMoreThan50() {
		locanda.items.get(1).setQuality(52);
		
		locanda.updateQuality();
		
		assertEquals(52, locanda.items.get(1).getQuality());
	}
	@Test
	public void brieItemsWhithQualityMoreThan50SellinLessThan0() {
		locanda.items.get(1).setQuality(52);
		locanda.items.get(1).setSellIn(0);
		locanda.updateQuality();
		
		assertEquals(52, locanda.items.get(1).getQuality());
	}
	
	
	@Test
	public void legendaryItemDoNotDecreasesSellin() {			
		
		assertEquals(0, locanda.items.get(3).getSellIn());
	}
	
	@Test
	public void legendaryItemDoNotDecreasesQuality() {			
		
		assertEquals(80, locanda.items.get(3).getQuality());
	}
	
	@Test
	public void legendaryItemWhitSellinLessThan0Quality() {			
		locanda.items.get(3).setSellIn(-1);
		locanda.updateQuality();
		assertEquals(80, locanda.items.get(3).getQuality());
	}
	
	@Test
	public void backstageIncrementsTwiceTimesQualityAsSellinLessThan10() {
		locanda.items.get(4).setSellIn(9);
		locanda.updateQuality();
		
		assertEquals(23, locanda.items.get(4).getQuality());
	}
	
	@Test
	public void backstageIncrementsThreeTimesQualityAsSellinLessThan5() {
		locanda.items.get(4).setSellIn(4);
		locanda.updateQuality();
		
		assertEquals(24, locanda.items.get(4).getQuality());
	}
	
	@Test
	public void backstageWhithSellin0QualityIs0() {
		locanda.items.get(4).setSellIn(-1);
		locanda.updateQuality();
		
		assertEquals(0, locanda.items.get(4).getQuality());
	}
	
	
	
	@Test
	public void backstageWhithQualityMore50AndSellinLessThan6() {
		locanda.items.get(4).setSellIn(5);
		locanda.items.get(4).setQuality(49);
		locanda.updateQuality();
		
		assertEquals(50, locanda.items.get(4).getQuality());
	}
	 
	
	
	
}
