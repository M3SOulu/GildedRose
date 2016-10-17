package fi.oulu.tol.sqat;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

  private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  private static final String AGED_BRIE = "Aged Brie";
  private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
  private static List<Item> items = null;

  public List<Item> getItems() {
    return items;
  }

  public GildedRose() {
    items = new ArrayList<Item>();
  }

  public static void updateEndOfDay() {
    // Loop over all items.
    for (int i = 0; i < items.size(); i++) {
      // Brie and Backstage increase in quality
      if (!isSameName(AGED_BRIE, i) && !isSameName(BACKSTAGE, i)) {
        if (getQualityInList(i) > 0) { // Quality can't be minus
          if (!isSameName(SULFURAS, i)) { // Sulfuras quality does not change
            changeItemQualBy(i, -1);
          }
        }
      }

      // Exceptional cases BRIE or BACKSTAGE
      else {
        if (getQualityInList(i) < 50) {
          changeItemQualBy(i, +1);

          if (isSameName(BACKSTAGE, i)) {
            if (getSellInInList(i) <= 10 && getQualityInList(i) < 50) {
              changeItemQualBy(i, +1);
            }

            if (getSellInInList(i) <= 5 && getQualityInList(i) < 50) {
              changeItemQualBy(i, +1);
            }
          }
        }
      }

      // Sell in of every item decrements by 1 except SULFURAS.
      if (!isSameName(SULFURAS, i)) {
        changeSellInBy(i, -1);
      }

      if (getSellInInList(i) < 0) {
        if (!isSameName(AGED_BRIE, i)) {
          if (isSameName(BACKSTAGE, i)) {
            items.get(i).setQuality(0);
          }
          else {
            if (getQualityInList(i) > 0) {
              if (!isSameName(SULFURAS, i)) {
                changeItemQualBy(i, -1);
              }
            }
          }
        }
        else {
          if (getQualityInList(i) < 50) {
            changeItemQualBy(i, +1);
          }
        }
      }
    }
  }

  public void addItem(Item item) {
    items.add(item);
  }

  // Compare the name of the string with i'th element on item list.
  public static boolean isSameName(String item, int i) {
    if (item.equals(items.get(i).getName()))
      return true;
    else
      return false;
  }

  public static void changeItemQualBy(int itemNum, int val) {
    items.get(itemNum).setQuality(items.get(itemNum).getQuality() + val);
  }

  public static void changeSellInBy(int itemNum, int val) {
    items.get(itemNum).setSellIn(getSellInInList(itemNum) + val);
  }

  public static int getQualityInList(int i) {
    return items.get(i).getQuality();
  }

  private static int getSellInInList(int i) {
    return items.get(i).getSellIn();
  }
}
