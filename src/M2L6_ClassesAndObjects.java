       // Main class to test everything
    public class M2L6_ClassesAndObjects {

        public static void main(String[] args) {
            System.out.println("=== M2-L6 Classes and Objects ===\n");

            Neeko neeko = new Neeko();
            Ahri ahri = new Ahri();

            // Creating items with real stats
            ItemShop shop = new ItemShop();

            //setter for gold  shouldn't be able to get negative
            neeko.setGold(5000);
            ahri.setGold(5000);
            neeko.setGold(-500);
            //System.out.println("Direct access: " + neeko.gold);         //should fail because the variable is private in the champion class
           // System.out.println("Using getter: " + neeko.getGold());     //This should work


            neeko.showStats();
            ahri.showStats();
            shop.showAllStarterItems();
            neeko.buyItem(shop.getAllStarterItems()[0]);
            ahri.buyItem(shop.getAllStarterItems()[0]);
            neeko.showStats();
            ahri.showStats();

            // Farm gold and exp
            neeko.farmWave(10);   // Farm for 10 minutes
            ahri.farmWave(10);

            // "open shop" look and items available to buy
           shop.showAllApItems();

            neeko.buyItem(shop.getAllItems()[1]);
            neeko.buyItem(shop.getAllItems()[2]);
            neeko.buyItem(shop.getAllItems()[3]);

            ahri.buyItem(shop.getAllItems()[4]);
            ahri.buyItem(shop.getAllItems()[5]);

            neeko.showStats();
            ahri.showStats();

            shop.showAllAdItems();
            neeko.buyItem(shop.getAllItems()[6]);


        }
    }

