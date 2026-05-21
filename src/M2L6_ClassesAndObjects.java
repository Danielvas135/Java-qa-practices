       // Main class to test everything
    public class M2L6_ClassesAndObjects {

        public static void main(String[] args) {
            System.out.println("=== M2-L6 Classes and Objects ===\n");

            // Creating objects from the Champion blueprint
            Champion neeko = new Champion("Neeko", "Mid/Support");
            Champion yasuo = new Champion("Yasuo", "Mid");

            // Creating objects from the Champion blueprint
            Item rocketbelt = new Item("Rocketbelt", "A belt with a rocket on it");
            Item stormsurge = new Item("Stormsurge", "Sword of storms");

            System.out.println("Created champion: " + neeko.name + " (" + neeko.role + ")");

            neeko.levelUp();
            //neeko.buyItem("erm");

            System.out.println("\nYasuo's level: " + yasuo.level);
        }
    }

