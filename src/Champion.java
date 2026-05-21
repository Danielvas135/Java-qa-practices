public class Champion {

    String name;
    String role;
    int level;
    int gold;

    // Constructor
    public Champion(String name, String role) {
        this.name = name;
        this.role = role;
        this.level = 1;
        this.gold = 500;
    }

    public void levelUp() {
        level++;
        System.out.println(name + " leveled up to " + level + "!");
    }
/*
    public void buyItem(String itemName) {
        System.out.println(name + " bought " + itemName + "!");
    }
*/

}