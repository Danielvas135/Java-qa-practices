public class Champion {

    String name;
    String role;
    int level;
    int gold;
    int exp;

    //Base stats
    int baseHp;
    int baseAtk;
    int baseAp;
    int baseArm;

    //current stats
    int currentHp;
    int currentAtk;
    int currentAp;
    int currentArm;

    //Stat Growth
    int hpPerLevel;
    double atkPerLevel;
    double armPerLevel;


    // Constructor - used to create champions - starting gold stats and growth rates |  whatever is in the brackets will need to be filled in when creating the champion
    public Champion(String name, String role, int baseHp, int baseAtk, int baseArm, int hpPerLevel, double atkPerLevel, double armPerLevel ){
        this.name = name;
        this.role = role;
        this.level = 1;
        this.gold = 500;
        this.exp = 0;

        this.baseHp = baseHp;
        this.baseAtk = baseAtk;
        this.baseAp = 0;
        this.baseArm = baseArm;

        //Starts with base stats
        this.currentHp = baseHp;
        this.currentAtk = baseAtk;
        this.currentAp = baseAp;
        this.currentArm = baseArm;

        //Stat growth from base stats
        this.hpPerLevel = hpPerLevel;
        this.atkPerLevel = atkPerLevel;
        this.armPerLevel = armPerLevel;

    }
    public void buyItem(Item item) {
        if (gold >= item.price) {
            System.out.println(name + " bought " + item.name + "!");

            // Add item stats to champion
            this.currentAtk += item.atk;
            this.currentAp += item.ap;
            this.currentArm += item.arm;
            this.currentHp += item.hp;

            this.gold -= item.price;   // Optional: reduce gold
        } else {
            // Not enough gold
            System.out.println(name + " wants to buy " + item.name + "! Needs " + (item.price - gold) + " gold...");
        }
    }
    public void levelUp() {
        level ++;

        //apply stat growth
        this.currentHp += hpPerLevel;
        this.currentAtk += atkPerLevel;
        this.currentArm += armPerLevel;

    }
    public void showStats() {
        System.out.println("\n=== " + name + " Current Stats ===");
        System.out.println("Level: " + level + " | Gold: " + gold);
        System.out.println("HP: " + currentHp + " | ATK: " + currentAtk +
                " | AP: " + currentAp + " | ARM: " + currentArm);
        System.out.println("-------------------");
    }
    public void farmWave(int minutes) {
        int goldPerMinute = 300;   // Neeko farms 12 gold per minute
        int expPerMinute = 50;

        System.out.println("\n" + name + " has cleared waves for " + minutes + " minutes...");

        for (int i = 1; i <= minutes; i++) {
            this.gold += goldPerMinute;
            this.exp += expPerMinute;
            //System.out.println("Minute " + i + ": +" + goldPerMinute + " gold → Total: " + gold);
            if (exp >= 100){
                exp -= 100;             //resets exp to 0 every level
                levelUp();              // calls the levelUp method
                System.out.println("Level up! " + name + " is now " + level + "!");
            }

        }

        System.out.println(name + " finished farming! Current gold: " + gold);
    }

}