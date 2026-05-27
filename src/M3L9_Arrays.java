public class M3L9_Arrays {

    public static void main(String[] args) {
        System.out.println("=== M3-L9 Arrays ===\n");
        Neeko neeko = new Neeko();
        // Array of Neeko's spells Values Given immediately
        String[] spells = {"Q - Blooming Burst", "W - Shapesplitter", "E - Tangle-barbs", "R - Pop Blossom"};

        int[] manaCost = {60, 0, 80, 100};

        System.out.println("Neeko's Spells:");
        for (int i = 0; i < spells.length; i++) {
            System.out.println(spells[i] + " > " + manaCost[i] + " mana");
        }

        System.out.println("\nNeeko has " + spells.length + " spells available.");

        //ITEMS ARRAY PRACTICE FOR EMPTY ARRAY
        System.out.println("=== Neeko's Item Shop ===\n");

        // 1. Array with fixed size (empty at first)
        String[] mageItems = new String[6];
        String[] tankItems = new String[4];

        // 2. Adding items one by one
        mageItems[0] = "Doran's Ring";
        mageItems[1] = "Lost Chapter";
        mageItems[2] = "Blasting Wand";
        mageItems[3] = "Amplifying Tome";
        mageItems[4] = "Needlessly Large Rod";
        mageItems[5] = "Dark Seal";

        tankItems[0] = "Cloth Armor";
        tankItems[1] = "Chain Vest";
        tankItems[2] = "Giant's Belt";
        tankItems[3] = "Ruby Crystal";

        // 3. Printing the arrays
        System.out.println("Mage Items (" + mageItems.length + " items):");
        for (int i = 0; i < mageItems.length; i++) {                      // This says: If there are items in the Array
            System.out.println((i + 1) + ". " + mageItems[i]);
        }

        System.out.println("\nTank Items (" + tankItems.length + " items):");
        for (int i = 0; i < tankItems.length; i++) {
            System.out.println((i + 1) + ". " + tankItems[i]);
        }
        neeko.showSpells();

    }

}

