package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

    // Example scenarios for testing
    //   Item("+5 Dexterity Vest", 10, 20));
    //   Item("Aged Brie", 2, 10));
    //   Item("Elixir of the Mongoose", 5, 7));
    //   Item("Sulfuras, Hand of Ragnaros", 0, 80));
    //   Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
    //   Item("Conjured Mana Cake", 3, 6));

    private GildedRose store = new GildedRose();

    private void updateDays(int days) {
        for (int i = 0; i < days; i++) {
            store.updateEndOfDay();
        }
    }

    @Test
    public void testUpdateEndOfDay_AgedBrie_Quality_10To11_In1Day() {
        // Arrange
        store.addItem(new Item("Aged Brie", 2, 10));

        // Act
        store.updateEndOfDay();

        // Assert
        List<Item> items = store.getItems();
        Item itemBrie = items.get(0);
        assertEquals(11, itemBrie.getQuality());
    }

    @Test
    public void testUpdateEndOfDay_AgedBrie_Quality_10To18_In5Days() {
        // Arrange
        store.addItem(new Item("Aged Brie", 2, 10));

        // Act
        updateDays(5);

        // Assert
        List<Item> items = store.getItems();
        Item itemBrie = items.get(0);
        assertEquals(18, itemBrie.getQuality());
    }

    @Test
    public void testUpdateEndOfDay_AgedBrie_Quality_10To48_In20Days() {
        // Arrange
        store.addItem(new Item("Aged Brie", 2, 10));

        // Act
        updateDays(20);

        // Assert
        List<Item> items = store.getItems();
        Item itemBrie = items.get(0);
        assertEquals(48, itemBrie.getQuality());
    }

    @Test
    public void testUpdateEndOfDay_AgedBrie_Quality_10To50_In21Days() {
        // Arrange
        store.addItem(new Item("Aged Brie", 2, 10));

        // Act
        updateDays(21);

        // Assert
        List<Item> items = store.getItems();
        Item itemBrie = items.get(0);
        assertEquals(50, itemBrie.getQuality());
    }

    @Test
    public void testUpdateEndOfDay_AgedBrie_Quality_10To50_In100Days() {
        // Arrange
        store.addItem(new Item("Aged Brie", 2, 10));

        // Act
        updateDays(100);

        // Assert
        List<Item> items = store.getItems();
        Item itemBrie = items.get(0);
        assertEquals(50, itemBrie.getQuality());
    }

    @Test
    public void testUpdateEndOfDay_DexterityVest_20To17_In3Days() {
        // Arrange
        store.addItem(new Item("+5 Dexterity Vest", 10, 20));

        // Act
        updateDays(3);

        // Assert
        List<Item> items = store.getItems();
        Item itemBrie = items.get(0);
        assertEquals(17, itemBrie.getQuality());
    }

    @Test
    public void testUpdateEndOfDay_DexterityVest_20To0_In50Days() {
        // Arrange
        store.addItem(new Item("+5 Dexterity Vest", 10, 20));

        // Act
        updateDays(50);

        // Assert
        List<Item> items = store.getItems();
        Item itemBrie = items.get(0);
        assertEquals(0, itemBrie.getQuality());
    }

    @Test
    public void testUpdateEndOfDay_Sulfuras_80_In1Day() {
        // Arrange
        store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));

        // Act
        store.updateEndOfDay();

        // Assert
        List<Item> items = store.getItems();
        Item itemBrie = items.get(0);
        assertEquals(80, itemBrie.getQuality());
    }

    @Test
    public void testUpdateEndOfDay_Sulfuras_80_In3Days() {
        // Arrange
        store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));

        // Act
        updateDays(3);

        // Assert
        List<Item> items = store.getItems();
        Item itemBrie = items.get(0);
        assertEquals(80, itemBrie.getQuality());
    }

    @Test
    public void testUpdateEndOfDay_BackstagePass_20To41_In10Days() {
        // Arrange
        store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20));

        // Act
        updateDays(10);

        // Assert
        List<Item> items = store.getItems();
        Item itemBrie = items.get(0);
        assertEquals(41, itemBrie.getQuality());
    }

    @Test
    public void testUpdateEndOfDay_BackstagePass_20To0_In13Days() {
        // Arrange
        store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20));

        // Act
        updateDays(13);

        // Assert
        List<Item> items = store.getItems();
        Item itemBrie = items.get(0);
        assertEquals(0, itemBrie.getQuality());
    }

    @Test
    public void testUpdateEndOfDay_ConjuredManaCake_6To4_In2Days() {
        // Arrange
        store.addItem(new Item("Conjured Mana Cake", 3, 6));

        // Act
        updateDays(2);

        // Assert
        List<Item> items = store.getItems();
        Item itemBrie = items.get(0);
        assertEquals(4, itemBrie.getQuality());
    }

    @Test
    public void testUpdateEndOfDay_ConjuredManaCake_6To1_In4Days() {
        // Arrange
        store.addItem(new Item("Conjured Mana Cake", 3, 6));

        // Act
        updateDays(4);

        // Assert
        List<Item> items = store.getItems();
        Item itemBrie = items.get(0);
        assertEquals(1, itemBrie.getQuality());
    }

    @Test
    public void testUpdateEndOfDay_ConjuredManaCake_6To0_In6Days() {
        // Arrange
        store.addItem(new Item("Conjured Mana Cake", 3, 6));

        // Act
        updateDays(6);

        // Assert
        List<Item> items = store.getItems();
        Item itemBrie = items.get(0);
        assertEquals(0, itemBrie.getQuality());
    }

    @Test
    public void testUpdateEndOfDay_Elixir_7To2_In5Days() {
        // Arrange
        store.addItem(new Item("Elixir of the Mongoose", 5, 7));

        // Act
        updateDays(5);

        // Assert
        List<Item> items = store.getItems();
        Item itemBrie = items.get(0);
        assertEquals(2, itemBrie.getQuality());
    }

    @Test
    public void testUpdateEndOfDay_Elixir_7To0_In6Days() {
        // Arrange
        store.addItem(new Item("Elixir of the Mongoose", 5, 7));

        // Act
        updateDays(6);

        // Assert
        List<Item> items = store.getItems();
        Item itemBrie = items.get(0);
        assertEquals(0, itemBrie.getQuality());
    }

    //
    // Example tests from the assignment instructions
    //

    // Test Aged Brie
    @Test
    public void testUpdateEndOfDay_AgedBrie_Quality_2_10() {
        // Arrange
        store.addItem(new Item("Aged Brie", 2, 10));

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
        store.addItem(new Item("Aged Brie", 10, 50));

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
        store.addItem(new Item("Aged Brie", 0, 10));

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
        store.addItem(new Item("Aged Brie", 0, 50));

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
        store.addItem(new Item("Aged Brie", -1, 20));

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
        store.addItem(new Item("Aged Brie", 2, 10));

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
        store.addItem(new Item("Aged Brie", 1, 10));

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
        store.addItem(new Item("Aged Brie", 0, 10));

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
        store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));

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
        store.addItem(new Item("Sulfuras, Hand of Ragnaros", 5, 80));

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
        store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));

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
        store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));

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
        store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));

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
        store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 8, 20));

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
        store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));

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
        store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20));

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
        store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));

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
        store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50));

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
        store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10));

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
        store.addItem(new Item("Elixir of the Mongoose", 2, 7));

        // Act
        store.updateEndOfDay();

        // Assert
        int quality = store.getItems().get(0).getQuality();
        String failMessage = "Quality decreases by 1";
        assertEquals(failMessage, 6, quality);
    }

    @Test
    public void testUpdateEndOfDay_SellIn_Quality_2_7() {
        // Arrange
        store.addItem(new Item("Elixir of the Mongoose", 2, 7));

        // Act
        store.updateEndOfDay();

        // Assert
        int sellIn = store.getItems().get(0).getSellIn();
        String failMessage = "SelIn decreases by 1";
        assertEquals(failMessage, 1, sellIn);
    }
}
