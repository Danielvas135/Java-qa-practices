public class Item {

    String name;
    String description;
    int price;
    int atk;
    int arm;
    int ap;
    int hp;

    // Constructor
    public Item(String name, String description, int price, int atk, int arm, int ap, int hp) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.atk = atk;
        this.arm = arm;
        this.ap = ap;
        this.hp = hp;
    }
    public void showStats(){
    System.out.println("=== " + name + " ===");
    System.out.println("Description: " + description);
    System.out.println("Price: " + price + " gold");
    System.out.println("HP: " + hp + "| ATK: " + atk + "| AP: "+ ap + " | ARM: " + arm);
    System.out.println("---------------------");

    }
}
