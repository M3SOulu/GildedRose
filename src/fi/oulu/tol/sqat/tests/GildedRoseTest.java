package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {
	@Before
	public void setUp(){
		GildedRose.main(null);//esegue già una volta il metodo updateQuality()
	}
	
	@Test
	public void checkCorrectQualityOfDexerityVest(){
		//Act
		int result = GildedRose.getList().get(0).getQuality();
		//Assert
		assertEquals(19,result);
	}
	
	@Test
	public void checkCorrectQualityOfAgedBrie(){
		//Act
		int result = GildedRose.getList().get(1).getQuality();
		//Assert
		assertEquals(1,result);
	}
	
	@Test
	public void checkCorrectQualityOfElixir(){
		//Act
		int result = GildedRose.getList().get(2).getQuality();
		//Assert
		assertEquals(6,result);
	}
	
	@Test
	public void checkCorrectQualityOfSulfuras(){
		//Act
		int result = GildedRose.getList().get(3).getQuality();
		//Assert
		assertEquals(80,result);
	}
	
	@Test
	public void checkCorrectQualityOfBackStagePasses(){
		//Act
		int result = GildedRose.getList().get(4).getQuality();
		//Assert
		assertEquals(21,result);
	}
	
	@Test
	public void checkCorrectQualityOfBackStagePassesAfter5Days(){
		//Arrange
		GildedRose.getList().add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
		//Act
		GildedRose.updateQuality();
		int result = GildedRose.getList().get(6).getQuality();
		//Assert
		assertEquals(22,result);
	}
	
	@Test
	public void checkCorrectQualityOfBackStagePassesAfter10Days(){
		//Arrange
		GildedRose.getList().add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
		//Act
		GildedRose.updateQuality();
		int result = GildedRose.getList().get(6).getQuality();
		//Assert
		assertEquals(23,result);
	}
	
	@Test
	public void checkCorrectQualityWithValue0(){
		//Arrange
		GildedRose.getList().add(new Item("Spada nella doccia +9", 5, 0));
		//Act
		GildedRose.updateQuality();
		int result = GildedRose.getList().get(6).getQuality();
		//Assert
		assertEquals(0,result);
	}
	
	@Test
	public void checkCorrectQualityWithValue50(){
		//Arrange
		GildedRose.getList().add(new Item("Aged Brie", 5, 50));
		//Act
		GildedRose.updateQuality();
		int result = GildedRose.getList().get(6).getQuality();
		//Assert
		assertEquals(50,result);
	}
	
	@Test
	public void checkCorrectQualityWithValue50ForConcertAndSellIn10(){
		//Arrange
		GildedRose.getList().add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50));
		//Act
		GildedRose.updateQuality();
		int result = GildedRose.getList().get(6).getQuality();
		//Assert
		assertEquals(50,result);
	}
	
	@Test
	public void checkCorrectQualityWithValue50ForConcertAndSellIn5(){
		//Arrange
		GildedRose.getList().add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50));
		//Act
		GildedRose.updateQuality();
		int result = GildedRose.getList().get(6).getQuality();
		//Assert
		assertEquals(50,result);
	}
	
	@Test
	public void checkCorrectQualityWithSellin0(){
		//Arrange
		GildedRose.getList().add(new Item("Spada nella doccia", 0, 20));
		//Act
		GildedRose.updateQuality();
		int result = GildedRose.getList().get(6).getSellIn();
		//Assert
		assertEquals(-1,result);
	}
	
	@Test
	public void checkCorrectQualityWithSellin0ForConcerts(){
		//Arrange
		GildedRose.getList().add(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0));
		//Act
		GildedRose.updateQuality();
		int result = GildedRose.getList().get(6).getQuality();
		//Assert
		assertEquals(0,result);
	}
	
	@Test
	public void checkCorrectQualityWithSellin0ForAgedBrieAndQualitylessThen50(){
		//Arrange
		GildedRose.getList().add(new Item("Aged Brie", 0, 20));
		//Act
		GildedRose.updateQuality();
		int result = GildedRose.getList().get(6).getQuality();
		//Assert
		assertEquals(22,result);
	}
	
	@Test
	public void checkCorrectQualityWithSellin0ForAgedBrieAndQuality50(){
		//Arrange
		GildedRose.getList().add(new Item("Aged Brie", 0, 50));
		//Act
		GildedRose.updateQuality();
		int result = GildedRose.getList().get(6).getQuality();
		//Assert
		assertEquals(50,result);
	}
	
	@Test
	public void checkCorrectQualityWithSellin0ForCustomAndSellInlessThen0(){
		//Arrange
		GildedRose.getList().add(new Item("la lambo di aladino", 0, 0));
		//Act
		GildedRose.updateQuality();
		int result = GildedRose.getList().get(6).getQuality();
		//Assert
		assertEquals(0,result);
	}
	
	@Test
	public void checkCorrectQualityWithSellin0ForSolfurasAndSellInlessThen0(){
		//Arrange
		GildedRose.getList().add(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
		//Act
		GildedRose.updateQuality();
		int result = GildedRose.getList().get(6).getQuality();
		//Assert
		assertEquals(80,result);
	}
	
	@Test
	public void checkCorrectQualityWithValue50ForConcertAndSellInLessThen10(){
		//Arrange
		GildedRose.getList().add(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 49));
		//Act
		GildedRose.updateQuality();
		int result = GildedRose.getList().get(6).getQuality();
		//Assert
		assertEquals(50,result);
	}
	
	@Test
	public void checkCorrectQualityWithValue50ForConcertAndSellInLessThen5(){
		//Arrange
		GildedRose.getList().add(new Item("Backstage passes to a TAFKAL80ETC concert", 4, 49));
		//Act
		GildedRose.updateQuality();
		int result = GildedRose.getList().get(6).getQuality();
		//Assert
		assertEquals(50,result);
	}
	
	//Test in aggiunta per il nuovo item nell shop
	@Test
	public void checkCorrectQualityofCojuredItems(){
		int resultOfQuality = GildedRose.getList().get(5).getQuality();
		int resultOfSellIn = GildedRose.getList().get(5).getSellIn();
		//Assert
		assertEquals(4,resultOfQuality);
		assertEquals(2,resultOfSellIn);
	}
	
	@Test
	public void checkCorrectQualityofCojuredItemsIfSellDatePassed(){
		//Arrange
		GildedRose.getList().add(new Item("Conjured Mana Cake", 0, 6));
		//Act
		GildedRose.updateQuality();
		int result = GildedRose.getList().get(6).getQuality();
		//Assert
		assertEquals(2,result);
	}
	
	@Test
	public void checkCorrectQualityofCojuredItemsWithOneQuality(){
		//Arrange
		GildedRose.getList().add(new Item("Conjured Mana Cake", 3, 1));
		//Act
		GildedRose.updateQuality();
		int result = GildedRose.getList().get(6).getQuality();
		//Assert
		assertEquals(0,result);
	}
	
	@Test
	public void checkCorrectQualityofCojuredItemsIfSellDatePassedAndQualityIsThree(){
		//Arrange
		GildedRose.getList().add(new Item("Conjured Mana Cake", 0, 3));
		//Act
		GildedRose.updateQuality();
		int result = GildedRose.getList().get(6).getQuality();
		//Assert
		assertEquals(0,result);
	}
}
