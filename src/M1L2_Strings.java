public class M1L2_Strings {
    public static void main(String[] args) {
        System.out.println("=== M1-L2 Java Strings ===\n");

        // 1. Basic String creation
        String champion = "Neeko";
        String playerName = "ShibaScylla";
        String role = "Mid/Support";

        System.out.println("Champion: " + champion);
        System.out.println("Player: " + playerName);

        // 2. Useful String methods
        System.out.println("Length of champion name: " + champion.length());
        System.out.println("Uppercase: " + champion.toUpperCase());
        System.out.println("Lowercase: " + champion.toLowerCase());

        // 3. Checking content
        System.out.println("Contains 'ee'? " + champion.contains("ee"));
        System.out.println("Starts with 'Nee'? " + champion.startsWith("Nee"));

        // 4. String comparison (very important!)
        String spell1 = "Blooming Burst";
        String spell2 = "blooming burst";

        System.out.println("Exact match? " + spell1.equals(spell2));
        System.out.println("Ignore case match? " + spell1.equalsIgnoreCase(spell2));

        // 5. Concatenation
        String fullInfo = champion + " is a " + role + " champion.";
        System.out.println(fullInfo);

        // Practical QA examples
        String errorMessage = "Invalid username or password";
        String successMessage = "Login successful";

        System.out.println("Does error contain 'Invalid'? " + errorMessage.contains("Invalid"));
        System.out.println("Is login successful? " + successMessage.equals("Login successful"));

        // Building a locator dynamically
        String username = "ShibaScylla";
        String dynamicLocator = "input[name='user_" + username + "']";
        System.out.println("Dynamic locator: " + dynamicLocator);

    }

}
