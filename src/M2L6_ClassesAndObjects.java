       // Main class to test everything
    public class M2L6_ClassesAndObjects {

        public static void main(String[] args) {
            System.out.println("=== M2-L6 Classes and Objects ===\n");

            Champion neeko = new Champion("Neeko", "Mid/Support", 610, 48,21,104,2.5,5.2);
            Champion ahri = new Champion("Ahri", "Mid", 590, 53,21,104,3,4.2);

            // Creating items with real stats
            Item doransring = new Item("Doran's Ring", "Mage starter item", 400, 0, 0, 18,90);
            Item rocketbelt = new Item("Rocketbelt", "A belt with a rocket on it", 2650, 0, 0, 70, 300);
            Item stormsurge = new Item("Stormsurge", " shockingly good time", 2800, 0, 0, 90, 0);
            Item zhonyas = new Item("Zhonya's Hourglass", "Stops time but just for u", 3250, 0, 50, 105, 0);
            Item blt = new Item("Blackfire Torch", "A hot rod",2800, 0, 0, 80, 0 );

/*
            neeko.showStats();
            neeko.buyItem(doransring);
            neeko.showStats();

            // Farm gold
            neeko.farmWave(10);   // Farm for 6 minutes

            System.out.println("\n=== SHOP ===\n");
            rocketbelt.showStats();
            stormsurge.showStats();
            zhonyas.showStats();

            neeko.buyItem(rocketbelt);
            neeko.showStats();

 */
            ahri.showStats();
            ahri.buyItem(doransring);
            ahri.showStats();

            // Farm gold
            ahri.farmWave(10);   // Farm for 6 minutes

            System.out.println("\n=== SHOP ===\n");
            rocketbelt.showStats();
            stormsurge.showStats();
            zhonyas.showStats();
            blt.showStats();

            ahri.buyItem(blt);
            ahri.showStats();
        }
    }

