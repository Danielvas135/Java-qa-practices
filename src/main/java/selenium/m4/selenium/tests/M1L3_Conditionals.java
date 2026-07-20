package selenium.m4.selenium.tests;

public class M1L3_Conditionals {
    public static void main(String[] args) {
        System.out.println("=== M1-L3 Conditionals (If-Else) ===\n");

        String champion = "Neeko";
        int level = 5;
        int gold = 3000;
        boolean isAlive = false;

        //Simple if
        if(level >= 6){
            System.out.println(champion + " can use ultimate!");
        }

        //If - Else If - Else
        if(gold >= 3200){
            System.out.println(champion + " can buy Rocketbelt!");
        } else{
            System.out.println(champion + " Can't buy Rocketbelt.");
    }
        //If - Else If - Else
        if (level >= 18) {
            System.out.println(champion + " is max level!");
        } else if (level >= 11) {
            System.out.println(champion + " is ready to Pop some ADCs!");
        } else if (level >= 6) {
            System.out.println(champion + "  just got ultimate.");
        } else {
            System.out.println(champion + " is still early game.");
        }
        // Boolean check
        if (isAlive) {
            System.out.println(champion + " is still fighting!");
        } else {
            System.out.println(champion + " is dead...");
        }
        System.out.println("\nEnd of conditionals example.");

        }


}
