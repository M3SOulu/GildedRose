package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GildedRoseTest {

    private List<Item> items;

    @Before
    public void setUp() throws Exception {
        GildedRose.main(null);
        items = GildedRose.getItems();

//        0 items.add(new Item("+5 Dexterity Vest", 10, 20));
//        1 items.add(new Item("Aged Brie", 2, 0));
//        2 items.add(new Item("Elixir of the Mongoose", 5, 7));
//        3 items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
//        4 items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
//        5 items.add(new Item("Conjured Mana Cake", 3, 6));
//        6 items.add(new Item("SellInPassed", -1, 6));
//        7 items.add(new Item("QualityNegative", 2, -1));


    }

    @Test
    public void sellInPassedAndQualityDegradedTwice() throws Exception {
        GildedRose.updateQuality();
        assertEquals(4, items.get(6).getQuality());
    }

    /*@Test
    public void qualityItemNeverNegative() throws Exception {
        assertEquals(0, items.get(3).getQuality());
    }*/

    @Test
    public void agedBriedIncreaseQualityOlderItGets1() throws Exception {
        items.get(1).setSellIn(1);
        GildedRose.updateQuality();
        assertEquals(1, items.get(1).getQuality());
    }

    @Test
    public void agedBriedIncreaseQualityOlderItGets2() throws Exception {
        items.get(1).setSellIn(0);
        GildedRose.updateQuality();
        assertEquals(2, items.get(1).getQuality());
    }

    @Test
    public void qualityNeverMoreThanFifty() throws Exception {
        GildedRose.updateQuality();
        for (Item item : items) {
            // Sulfuras è leggendario quindi può avere la qualità maggiore di 50
            if (item.getQuality() > 50 && !item.getName().contains("Sulfuras")) {
                fail();
            }
        }
    }

    @Test
    public void sulfurasNeverDecreaseQuality() throws Exception {
        items.get(3).setSellIn(-10);
        GildedRose.updateQuality();
        assertEquals(80, items.get(3).getQuality());
    }

    @Test
    public void backstageQualityIncreasedByTwoWhenSellInUpToTen() throws Exception {
        items.get(4).setSellIn(10);
        GildedRose.updateQuality();
        assertEquals(22, items.get(4).getQuality());
    }

    /*@Test
    public void agedBrieQualityIncreasedByTwoWhenSellInUpToTen() throws Exception {
        items.get(1).setSellIn(10);
        GildedRose.updateQuality();
        assertEquals(2, items.get(1).getQuality());
    }*/

    @Test
    public void backstageQualityIncreasedByThreeWhenSellInUpToFive() throws Exception {
        items.get(4).setSellIn(5);
        GildedRose.updateQuality();
        assertEquals(23, items.get(4).getQuality());
    }

    /*@Test
    public void agedBrieQualityIncreasedByThreeWhenSellInUpToFive() throws Exception {
        items.get(1).setSellIn(5);
        GildedRose.updateQuality();
        assertEquals(2, items.get(1).getQuality());
    }*/

    @Test
    public void backstageQualityDropsToZeroAfterTheConcert() throws Exception {
        items.get(4).setSellIn(-1);
        GildedRose.updateQuality();
        assertEquals(0, items.get(4).getQuality());
    }

}
