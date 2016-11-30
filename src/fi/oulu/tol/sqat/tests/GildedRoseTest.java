package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	
	//test dei normalItem
	@Test
	public void NormalItem_Quality_decrese_by_1__with_1_apdate() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		GildedRose negozio = new GildedRose(items);
		negozio.updateQuality();
		items = new ArrayList(negozio.getItems());
		assertEquals(19,items.get(0).getQuality());
	}
	@Test
	public void first_day_after_sellIn_decesed_by_2() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		GildedRose negozio = new GildedRose(items);
		for(int i = 0; i<11;i++){
			negozio.updateQuality();
		}
		items = new ArrayList(negozio.getItems());
		assertEquals(8,items.get(0).getQuality());
	}
	
	@Test
	public void quality_cant_be_negativ() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		GildedRose negozio = new GildedRose(items);
		for(int i = 0; i<30;i++){
			negozio.updateQuality();
		}
		items = new ArrayList(negozio.getItems());
		assertEquals(0,items.get(0).getQuality());
	}
	
	//test del formaggio
	
	@Test
	public void cees_increesQuality_with_decreasing_day() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("Aged Brie", 2, 0));
		GildedRose negozio = new GildedRose(items);
		for(int i = 0; i<2;i++){
			negozio.updateQuality();
		}
		items = new ArrayList(negozio.getItems());
		assertEquals(2,items.get(0).getQuality());
	}
	@Test
	public void cees_increes_Quality_twice_after_sellIn_with_decreasing_day() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("Aged Brie", 2, 0));
		GildedRose negozio = new GildedRose(items);
		for(int i = 0; i<5;i++){
			negozio.updateQuality();
		}
		items = new ArrayList(negozio.getItems());
		assertEquals(8,items.get(0).getQuality());
	}
	@Test
	public void MaxQuality_mast_Be_50() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("Aged Brie", 2, 0));
		GildedRose negozio = new GildedRose(items);
		for(int i = 0; i<500;i++){
			negozio.updateQuality();
		}
		items = new ArrayList(negozio.getItems());
		assertEquals(50,items.get(0).getQuality());
	}
	
	//sulfuras
	
	@Test
	public void Sulfuras_must_not_decrese_quality() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		GildedRose negozio = new GildedRose(items);
		for(int i = 0; i<500;i++){
			negozio.updateQuality();
		}
		items = new ArrayList(negozio.getItems());
		assertEquals(80,items.get(0).getQuality());
	}
	
	//BackStage
	
	@Test
	public void BackStage_increasing_quality_by_decreasing_of_day() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		GildedRose negozio = new GildedRose(items);
		for(int i = 0; i<5;i++){
			negozio.updateQuality();
		}
		items = new ArrayList(negozio.getItems());
		assertEquals(25,items.get(0).getQuality());
	}
	
	@Test
	public void BackStage_when_sellIn_is_minore_uguale_10_increases_twice() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		GildedRose negozio = new GildedRose(items);
		for(int i = 0; i<6;i++){
			negozio.updateQuality();
		}
		items = new ArrayList(negozio.getItems());
		assertEquals(27,items.get(0).getQuality());
		for(int i = 0; i<4;i++){
			negozio.updateQuality();
		}
		assertEquals(35,items.get(0).getQuality());
	}
	
	@Test
	public void BackStage_when_sellIn_is_minore_uguale_5_increases_by_3() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		GildedRose negozio = new GildedRose(items);
		for(int i = 0; i<11;i++){
			negozio.updateQuality();
		}
		items = new ArrayList(negozio.getItems());
		assertEquals(38,items.get(0).getQuality());
	}
	@Test
	public void BackStage_quality_after_sellIn_must_be_0() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		GildedRose negozio = new GildedRose(items);
		for(int i = 0; i<16;i++){
			negozio.updateQuality();
		}
		items = new ArrayList(negozio.getItems());
		assertEquals(0,items.get(0).getQuality());
	}
	@Test
	public void BackStage_quality_at_sellIn_day_bust_be_max() {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		GildedRose negozio = new GildedRose(items);
		for(int i = 0; i<15;i++){
			negozio.updateQuality();
		}
		items = new ArrayList(negozio.getItems());
		assertEquals(50,items.get(0).getQuality());
	}
	
	@Test
	public void AllTogeder() {
		ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
		GildedRose negozio = new GildedRose(items);
		for(int i = 0; i<1;i++){
			negozio.updateQuality();
		}
		items = new ArrayList(negozio.getItems());
		assertEquals(19,items.get(0).getQuality());
		assertEquals(1,items.get(1).getQuality());
		assertEquals(6,items.get(2).getQuality());
		assertEquals(80,items.get(3).getQuality());
		assertEquals(21,items.get(4).getQuality());
	}
	
}
