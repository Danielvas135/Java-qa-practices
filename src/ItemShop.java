public class ItemShop {

    // Array of all items in the game
    private Item[] allItems;
    private Item[] allApItems;
    private Item[] getAllStarterItems;

    public ItemShop() {
        // Initialize the array with all items
        allItems = new Item[10];

        allItems[0] = new Item("Doran's Ring", "Mage starter item", 400, 0, 0, 18, 90, 0);
        allItems[1] = new Item("Rocketbelt", "A belt with a rocket on it", 2650, 0, 0, 70, 300, 0);
        allItems[2] = new Item("Stormsurge", " shockingly good time", 2800, 0, 0, 90, 0, 0);
        allItems[3] = new Item("Zhonya's Hourglass", "Stops time but just for u", 3250, 0, 50, 105, 0, 0);
        allItems[4] = new Item("Blackfire Torch", "A hot rod", 2800, 0, 0, 80, 0, 300);
        allItems[5] = new Item("Comic Drive", "A racer helmet from the 80's", 3000, 0, 0, 70, 350, 0);

        allItems[6] = new Item("Blade of the Ruined King","Can't blame him, he lost his wife", 3200,40,0,0,0,0);
        allItems[7] = new Item("Guinsoo's Rageblade"," Seething Strike", 3000,30,0,30,0,0);
        allItems[8] = new Item("Terminus"," Shadow | Juxtaposition, learn to read", 3000,30,0,0,0,0);
        allItems[9] = new Item("Doran's Bow","Ranger starter item", 400,8,0,0,0,0);

    }

    //getter to access the items
    public Item[] getAllItems() {
        return allItems;
    }
    // This method displays the whole shop
    public void showAllItems() {
        System.out.println("\n=== ITEM SHOP ===\n");
        for (int i = 0; i < allItems.length; i++) {
            System.out.println((i + 1) + ". ");
            allItems[i].showStats();
        }
    }


    public Item[] getAllStarterItems() {
        Item[] StarterItems =  new Item[2];
        StarterItems[0] =  allItems[0]; // Doran's Ring
        StarterItems[1] =  allItems[9]; // Doran's Bow

        return StarterItems;
    }
    public void showAllStarterItems() {
        System.out.println("\n=== STARTER ITEM SHOP ===\n");
        Item[] StarterItems =  getAllStarterItems();
        for (int i = 0; i < StarterItems.length; i++) {
            System.out.println((i + 1) + ". ");
            StarterItems[i].showStats();
        }
    }

    public Item[] getAllApItems() {
        Item[] ApItems =  new Item[6];
        ApItems[0] = allItems[0];   //Doran's ring
        ApItems[1] = allItems[1];   //rocketbelt
        ApItems[2] = allItems[2];   //stormsurge
        ApItems[3] = allItems[3];   //zhonya's
        ApItems[4] = allItems[4];   //black fire torch
        ApItems[5] = allItems[5];   //cosmic drive
        return ApItems;
    }
    public void showAllApItems() {
        System.out.println("\n=== AP ITEM SHOP ===\n");
        Item[] ApItems =  getAllApItems();
        for (int i = 0; i < ApItems.length; i++) {
            System.out.println((i + 1) + ". ");
            ApItems[i].showStats();
        }
    }
    public Item[] getAllAdItems() {
        Item[] AdItems =  new Item[4];
        AdItems[0] = allItems[6];   //BORK
        AdItems[1] = allItems[7];   //Rageblade
        AdItems[2] = allItems[8];   //Terminus
        AdItems[3] = allItems[9];   //Doran's bow
        return AdItems;
    }
    public void showAllAdItems() {
        System.out.println("\n=== AD ITEM SHOP ===\n");
        Item[] AdItems =  getAllAdItems();
        for (int i = 0; i < AdItems.length; i++) {
            System.out.println((i + 1) + ". ");
            AdItems[i].showStats();
        }
    }





}
