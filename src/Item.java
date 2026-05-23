public class Item {

    String name;
    String description;
    int price;
    int atk;
    int arm;
    int ap;
    int hp;
    int mp;

    // Constructor
    public Item(String name, String description, int price, int atk, int arm, int ap, int hp, int mp) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.atk = atk;
        this.arm = arm;
        this.ap = ap;
        this.hp = hp;
        this.mp = mp;
    }
    public void showStats(){
    System.out.println("=== " + name + " ===");
    System.out.println("Description: " + description);
    System.out.println("Price: " + price + " gold");
    System.out.println("HP: " + hp + "| MP: " + mp + "| ATK: " + atk + "| AP: "+ ap + " | ARM: " + arm);
    System.out.println("---------------------");

    }
}
