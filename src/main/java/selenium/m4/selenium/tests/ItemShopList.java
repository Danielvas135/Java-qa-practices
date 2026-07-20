package selenium.m4.selenium.tests;

import selenium.m4.selenium.tests.Item;

import java.util.ArrayList;


public class ItemShopList {

    private ArrayList<Item> allItems;

    public ItemShopList() {
        allItems = new ArrayList<>();

        allItems.add(new Item("Doran's Ring", "Mage starter item", 400, 0, 0, 18, 90, 0));
        allItems.add(new Item("Rocketbelt", "A belt with a rocket on it", 2650, 0, 0, 70, 300,0));
        allItems.add(new Item("Stormsurge", "Shockingly good time", 2800, 0, 0, 90, 0,0));
        allItems.add(new Item("Zhonya's Hourglass", "Stops time but just for u", 3250, 0, 50, 105, 0,0));
        allItems.add(new Item("Blackfire Torch", "A hot rod", 2800, 0, 0, 80, 0,300));
        allItems.add(new Item("Comic Drive", "A racer helmet from the 80's", 3000, 0, 0, 70, 350, 0));
    }

    public void showAllItems() {
        System.out.println("\n=== NEEKO'S ITEM SHOP ===\n");
        for (int i = 0; i < allItems.size(); i++) {
            System.out.print((i + 1) + ". ");
            allItems.get(i).showStats();
        }
    }

    public Item getItem(int index) {
        return allItems.get(index);
    }
    // Add a new item to the shop
    public void addItem(Item newItem) {
        allItems.add(newItem);
        System.out.println("New item added to shop: " + newItem.getName());
    }
    // Remove an item from the shop by index
    public void removeItem(int index) {
        if (index >= 0 && index < allItems.size()) {
            Item removed = allItems.remove(index);
            System.out.println("Removed from shop: " + removed.getName());
        }
    }


}