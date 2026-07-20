package selenium.m4.selenium.tests;

public class M3L10_ArrayList {

    public static void main(String[] args){
        ItemShopList Shop = new ItemShopList();
        Neeko neeko = new Neeko();

        Shop.showAllItems();

        // Neeko buys item #1 (Rocketbelt)
        neeko.buyItem(Shop.getItem(1));
        Shop.removeItem(1);
        Shop.showAllItems();

    }
}
