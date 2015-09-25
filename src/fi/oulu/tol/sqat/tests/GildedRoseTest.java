package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fi.oulu.tol.sqat.*;



import org.junit.runners.*;

@RunWith(Parameterized.class)
public class GildedRoseTest 
{

	Item item;
	int expectedSellIn;
	int expectedQuality;
	
	
	public GildedRoseTest(Item item,int expectedSellIn,int expectedQuality) 
	{
		this.item=item;
		this.expectedSellIn = expectedSellIn;
		this.expectedQuality = expectedQuality;
				
	}
	
	@Parameters (name = "{index} SellIn:{1} Quality:{2} ")
	public static List<Object[]>myData()
	{
		return Arrays.asList(new Object[][]
		{
			{new Item("Aged Brie",2,0),1,1}
		});
		
	}
	
	
	@Test
	public void testTheTruth()
	{
		assertTrue(true);
	}
	
	
	@Test
	public void testUpdateItemBrieSellIn2Quality0() 
	{
		
		//Item item =new Item("Aged Brie", 2, 0);
		GildedRose.updateItem(item);
		
		
		assertEquals("SellIn not correct",expectedSellIn,item.getSellIn());
		assertEquals("Quality not correct",expectedQuality,item.getQuality());
	
		
	}
	
	
	
	
}
