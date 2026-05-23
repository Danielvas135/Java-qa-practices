       // Main class to test everything
    public class M2L6_ClassesAndObjects {

        public static void main(String[] args) {
            System.out.println("=== M2-L6 Classes and Objects ===\n");

            Neeko neeko = new Neeko();
            Ahri ahri = new Ahri();

            // Creating items with real stats
            Item doransring = new Item("Doran's Ring", "Mage starter item", 400, 0, 0, 18,90, 0);
            Item rocketbelt = new Item("Rocketbelt", "A belt with a rocket on it", 2650, 0, 0, 70, 300, 0);
            Item stormsurge = new Item("Stormsurge", " shockingly good time", 2800, 0, 0, 90, 0, 0);
            Item zhonyas = new Item("Zhonya's Hourglass", "Stops time but just for u", 3250, 0, 50, 105, 0, 0);
            Item bft = new Item("Blackfire Torch", "A hot rod",2800, 0, 0, 80, 0, 300);
            Item Cosmic = new Item("Comic Drive", "A racer helmet from the 80's",3000, 0, 0, 70, 350, 0 );

            //setter for gold  shouldn't be able to get negative
            neeko.setGold(5000);
            ahri.setGold(5000);
            neeko.setGold(-500);
            //System.out.println("Direct access: " + neeko.gold);         //should fail because the variable is private in the champion class
           // System.out.println("Using getter: " + neeko.getGold());     //This should work


            neeko.showStats();
            ahri.showStats();
            neeko.buyItem(doransring);
            ahri.buyItem(doransring);
            neeko.showStats();
            ahri.showStats();

            // Farm gold and exp
            neeko.farmWave(10);   // Farm for 10 minutes
            ahri.farmWave(10);

            // "open shop" look and items available to buy
            System.out.println("\n=== SHOP ===\n");
            rocketbelt.showStats();
            stormsurge.showStats();
            zhonyas.showStats();
            bft.showStats();
            Cosmic.showStats();

            neeko.buyItem(rocketbelt);
            neeko.buyItem(stormsurge);
            neeko.buyItem(zhonyas);

            ahri.buyItem(bft);
            ahri.buyItem(Cosmic);

            neeko.showStats();
            ahri.showStats();

        }
    }

