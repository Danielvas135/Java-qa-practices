package selenium.m4.selenium.tests;

public class M1L4_Loops {
    public static void main(String[] args){

        System.out.println("=== M1-L4 Java Loops ===\n");

        String champion = "Neeko";

        //1, For Loop - Most common in automation
        System.out.println("Neeko is leveling up:");
        for(int level = 1; level <=18; level++){
            System.out.println("Level " + level);
        }
        System.out.println("\n--- Spell Rotation (While Loop) ---");
        //2. While Loop
        int spellCooldown = 7;
        while(spellCooldown > 0) {
            System.out.println("Blooming Burst... Ready in: " + spellCooldown);
            spellCooldown--;
        }
                System.out.println("Blooming Burst is ready!");


        System.out.println("\n--- Checking Items in Shop (For-each style) ---");

        // 3. For-each loop (very useful)
        String[] items = {"Rocketbelt", "Shadowflame", "Zhonyas", "Rabadons"};

        for (String item : items) {
            System.out.println("Neeko bought: " + item);
        }

        System.out.println("\nNeeko finished her shopping spree!");
    }

}
