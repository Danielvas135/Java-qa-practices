package selenium.m4.selenium.tests;

public class Champion {
    //set protected variables for subclasses
    protected String name;
    protected String role;
    protected int level;
    protected int gold;
    protected int exp;


    protected int baseHp,baseMp, baseAtk, baseAp, baseArm;
    protected int currentHp, currentMp, currentAtk, currentAp, currentArm;

    protected double hpPerLevel, mpPerLevel, atkPerLevel, armPerLevel;

    /*

    //Base stats

    private int baseHp;
    private int baseAtk;
    private int baseAp;
    private int baseArm;

    //current stats
    private int currentHp;
    private int currentAtk;
    private int currentAp;
    private int currentArm;

    //Stat Growth
    private int hpPerLevel;
    private double atkPerLevel;
    private double armPerLevel;

    */

    // Constructor - used to create champions - starting gold stats and growth rates |  whatever is in the brackets will need to be filled in when creating the champion
    public Champion(String name, String role, int baseHp, int baseMp, int baseAtk, int baseArm, double hpPerLevel, double mpPerLevel, double atkPerLevel, double armPerLevel ){
        this.name = name;
        this.role = role;
        this.level = 1;
        this.gold = 500;
        this.exp = 0;

        this.baseHp = baseHp;
        this.baseMp = baseMp;
        this.baseAtk = baseAtk;
        this.baseAp = 0;
        this.baseArm = baseArm;

        //Starts with base stats
        this.currentHp = baseHp;
        this.currentMp = baseMp;
        this.currentAtk = baseAtk;
        this.currentAp = baseAp;
        this.currentArm = baseArm;

        //Stat growth from base stats
        this.hpPerLevel = hpPerLevel;
        this.mpPerLevel = mpPerLevel;
        this.atkPerLevel = atkPerLevel;
        this.armPerLevel = armPerLevel;

    }

    // Getters
    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getGold() { return gold; }
    public int getCurrentHp() { return currentHp; }
    public int getCurrentMp() { return currentMp; }
    public int getCurrentAtk() { return currentAtk; }
    public int getCurrentAp() { return currentAp; }
    public int getCurrentArm() { return currentArm; }

    public void buyItem(Item item) {
        if (gold >= item.price) {
            System.out.println(name + " bought " + item.name + "!");

            // Add item stats to champion
            this.currentAtk += item.atk;
            this.currentAp += item.ap;
            this.currentArm += item.arm;
            this.currentHp += item.hp;
            this.currentMp += item.mp;

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
        System.out.println("\n=== " + getName() + " Current Stats ===");
        System.out.println("Level: " + getLevel() + " | Gold: " + getGold());
        System.out.println("HP: " + getCurrentHp() + " | MP: " + getCurrentMp() + " | ATK: " + getCurrentAtk() +
                " | AP: " + getCurrentAp() + " | ARM: " + getCurrentArm());
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
    // Setter for adding/ checking gold
    public void setGold(int amount) {
        if(amount >=0){
            this.gold = amount;
        } else {
            System.out.println("Warning: Cannot set negative gold!");
        }

    }

}