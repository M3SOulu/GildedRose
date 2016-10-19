package fi.oulu.tol.sqat.tests;
import static org.junit.Assert.*;
import org.junit.Test;
import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;
public class GildedRoseTest {
GildedRose store = new GildedRose();

// Test Aged Brie
@Test
public void testUpdateEndOfDay_AgedBrie_Quality_2_10() {
// Arrange
store.addItem(new Item("Aged Brie", 2, 10) );
// Act
store.updateEndOfDay();
// Assert
int quality = store.getItems().get(0).getQuality();
String failMessage = "Quality of Aged Brie increases";
assertEquals(failMessage, 11, quality);
}

@Test
public void testUpdateEndOfDay_AgedBrie_Quality_10_50() {
// Arrange
store.addItem(new Item("Aged Brie", 10, 50) );
// Act
store.updateEndOfDay();
// Assert
int quality = store.getItems().get(0).getQuality();
String failMessage = "The Quality of an item is never more than 50";
assertEquals(failMessage, 50, quality);
}

@Test
public void testUpdateEndOfDay_AgedBrie_Quality_0_10() {
// Arrange
store.addItem(new Item("Aged Brie", 0, 10) );
// Act
store.updateEndOfDay();
// Assert
int quality = store.getItems().get(0).getQuality();
String failMessage = "The Quality of Aged Brie increases twice after SellIn date has passed";
assertEquals(failMessage, 12, quality);
}

@Test
public void testUpdateEndOfDay_AgedBrie_Quality_0_50() {
// Arrange
store.addItem(new Item("Aged Brie", 0, 50) );
// Act
store.updateEndOfDay();
// Assert
int quality = store.getItems().get(0).getQuality();
String failMessage = "The Quality of Aged Brie is never more than 50 increases twice after SellIn date has passed";
assertEquals(failMessage, 50, quality);
}

@Test
public void testUpdateEndOfDay_AgedBrie_Quality_Minus1_20() {
// Arrange
store.addItem(new Item("Aged Brie", -1, 20) );
// Act
store.updateEndOfDay();
// Assert
int quality = store.getItems().get(0).getQuality();
String failMessage = "The Quality of Aged Brie increases twice after SellIn date has passed";
assertEquals(failMessage, 22, quality);
}

@Test
public void testUpdateEndOfDay_AgedBrie_SellIn_2_10() {
// Arrange
store.addItem(new Item("Aged Brie", 2, 10) );
// Act
store.updateEndOfDay();
// Assert
int sellIn = store.getItems().get(0).getSellIn();
String failMessage = "SellIn date decreases";
assertEquals(failMessage, 1, sellIn);
}

@Test
public void testUpdateEndOfDay_AgedBrie_SellIn_1_10() {
// Arrange
store.addItem(new Item("Aged Brie", 1, 10) );
// Act
store.updateEndOfDay();
// Assert
int sellIn = store.getItems().get(0).getSellIn();
String failMessage = "SellIn date decreases";
assertEquals(failMessage, 0, sellIn);
}

@Test
public void testUpdateEndOfDay_AgedBrie_SellIn_0_10() {
// Arrange
store.addItem(new Item("Aged Brie", 0, 10) );
// Act
store.updateEndOfDay();
// Assert
int sellIn = store.getItems().get(0).getSellIn();
String failMessage = "SellIn date decreases";
assertEquals(failMessage, -1, sellIn);
}
// Test Sulfuras

@Test
public void testUpdateEndOfDay_Sulfuras_Quality_0_80() {
// Arrange
store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
// Act
store.updateEndOfDay();
// Assert
int quality = store.getItems().get(0).getQuality();
String failMessage = "Quality of Sulfuras is 80 and never alters";
assertEquals(failMessage, 80, quality);
}

@Test
public void testUpdateEndOfDay_Sulfuras_SellIn_5_80() {
// Arrange
store.addItem(new Item("Sulfuras, Hand of Ragnaros", 5, 80) );
// Act
store.updateEndOfDay();
// Assert
int sellIn = store.getItems().get(0).getSellIn();
String failMessage = "Sulfuras, being a legendary item, never has to be sold";
assertEquals(failMessage, 5, sellIn);
}

@Test
public void testUpdateEndOfDay_Sulfuras_SellIn_0_80() {
// Arrange
store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80) );
// Act
store.updateEndOfDay();
// Assert
int sellIn = store.getItems().get(0).getSellIn();
String failMessage = "Sulfuras, being a legendary item, never has to be sold";
assertEquals(failMessage, 0, sellIn);
} 
// Test Backstage pass

@Test
public void testUpdateEndOfDay_Backstage_Quality_15_20() {
// Arrange
store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",
15, 20) );
// Act
store.updateEndOfDay();
// Assert
int quality = store.getItems().get(0).getQuality();
String failMessage = "Quality of Backstage pass increases by 1 when there are more than 10 days";
assertEquals(failMessage, 21, quality);
}

@Test
public void testUpdateEndOfDay_Backstage_Quality_10_20() {
// Arrange
store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert",
10, 20) );
// Act
store.updateEndOfDay();
// Assert
int quality = store.getItems().get(0).getQuality();
String failMessage = "Quality of Backstage pass increases by 2 when there are 10 or less days";
assertEquals(failMessage, 22, quality);
}

@Test
public void testUpdateEndOfDay_Backstage_Quality_8_20() {
// Arrange
store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 8, 20) );
// Act
store.updateEndOfDay();
// Assert
int quality = store.getItems().get(0).getQuality();
String failMessage = "Quality of Backstage pass increases by 2 when there are 10 or less days";
assertEquals(failMessage, 22, quality);
}

@Test
public void testUpdateEndOfDay_Backstage_Quality_5_20() {
// Arrange
store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) );
// Act
store.updateEndOfDay();
// Assert
int quality = store.getItems().get(0).getQuality();
String failMessage = "Quality of Backstage pass increases by 3 when there are 5 or less days";
assertEquals(failMessage, 23, quality);
}

@Test
public void testUpdateEndOfDay_Backstage_Quality_3_20() {
// Arrange
store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20) );
// Act
store.updateEndOfDay();
// Assert
int quality = store.getItems().get(0).getQuality();
String failMessage = "Quality of Backstage pass increases by 3 when there are 5 or less days";
assertEquals(failMessage, 23, quality);
}

@Test
public void testUpdateEndOfDay_Backstage_Quality_0_20() {
// Arrange
store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) );
// Act
store.updateEndOfDay();
// Assert
int quality = store.getItems().get(0).getQuality();
String failMessage = "Quality of Backstage drops to 0 after the concert";
assertEquals(failMessage, 0, quality);
}

@Test
public void testUpdateEndOfDay_Backstage_Quality_15_50() {
// Arrange
store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50) );
// Act
store.updateEndOfDay();
// Assert
int quality = store.getItems().get(0).getQuality();
String failMessage = "The Quality of an item is never more than 50";
assertEquals(failMessage, 50, quality);
}

@Test
public void testUpdateEndOfDay_Backstage_SellIn_5_10() {
// Arrange
store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) );
// Act
store.updateEndOfDay();
// Assert
int sellIn = store.getItems().get(0).getSellIn();
String failMessage = "The SellIn value should decrease by 1";
assertEquals(failMessage, 4, sellIn);
}
// Test Elixir

@Test
public void testUpdateEndOfDay_Elixir_Quality_2_7() {
// Arrange
store.addItem(new Item("Elixir of the Mongoose", 2, 7) );
// Act
store.updateEndOfDay();
// Assert
int quality = store.getItems().get(0).getQuality();
String failMessage = "Quality decreases by 1";
assertEquals(failMessage, 6,quality);
}

@Test
public void testUpdateEndOfDay_SellIn_Quality_2_7() {
// Arrange
store.addItem(new Item("Elixir of the Mongoose", 2, 7) );
// Act
store.updateEndOfDay();
// Assert
int sellIn = store.getItems().get(0).getSellIn();
String failMessage = "SelIn decreases by 1";
assertEquals(failMessage, 1, sellIn);
}
}
