package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.*;

import fi.oulu.tol.sqat.*;

@RunWith (Parameterized.class)
public class GildedRoseTest {

	int sellIn;
	int expectedSellIn;
	int expectedQuality;
	//Item item;
	ItemDecorator item;
	
	public GildedRoseTest(ItemDecorator item,int expectedSellIn,int expectedQuality) {
		this.item = item;
		this.expectedQuality = expectedQuality;
		this.expectedSellIn = expectedSellIn;
	}
	
	@Parameters (name = "{index}: sellIn{1} quality:{2}")
	public static List<Object[]> myData() {
		return Arrays.asList(new Object[][] {
				{new SulfurasDecorator(0,80),0,80}, //0
				
				//{new Item("Sulfuras, Hand of Ragnaros", 0, 80),0,80}, //sulfuras should stay the same
				/*
				 * aged brie should icrease by one
				 */
				//{new Item("Aged Brie", 2, 0),1,1 },
				{new BrieDecorator(2,0),1,1},  //1
				{new BrieDecorator(2,49),1,50}, //2
				{new BrieDecorator(2,50),1,50}, //3
				
				/*
				 * backstage passes
				 */
				{new BackstageDecorator(9, 25),8,27},  //4
				{new BackstageDecorator(10, 25),9,27}, //5
				{new BackstageDecorator(2, 20),1,23},  //6
				{new BackstageDecorator(3, 20),2,23},  //7
				{new BackstageDecorator(6, 20),5,22},  //8
				{new BackstageDecorator(5, 20),4,23},  //9
				{new BackstageDecorator(1, 20),0,23},  //10
				{new BackstageDecorator(0, 20),-1,0},  //11
				
				/*
				 * test conjured items
				 */
				{new ConjuredDecorator(0,5),-1,1}, //12
				{new ConjuredDecorator(0,4),-1,0}, //13
				{new ConjuredDecorator(0,3),-1,0}, //14
				{new ConjuredDecorator(2,5),1,3}, //15
				/*
				 * test couple of normal items
				 */
				{new NormalItemDecorator("+5 Dexterity Vest", 10, 20),9,19}, //16
				{new NormalItemDecorator("+5 Dexterity Vest", 0,20),-1,18}, //17
				{new NormalItemDecorator("+5 Dexterity Vest", 1, 20),0,19}, //18
				{new NormalItemDecorator("+5 Dexterity Vest", -1, 2),-2,0}, //19
				{new NormalItemDecorator("+5 Dexterity Vest", 0,1),-1,0}   //20	
		});
		
	}
	
	@Test
	public void testUpdateItem() {
		GildedRose.updateItem(item);
		assertEquals("SellIn not correct.",item.getSellIn(),expectedSellIn);
		assertEquals("Quality not correct",item.getQuality(),expectedQuality);
	}
	

}
