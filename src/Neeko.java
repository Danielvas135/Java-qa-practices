public class Neeko extends Champion {

    private String firstAbillity = "Blooming Burst";

    public Neeko() {
        super("Neeko", "Mid/Support", 610,450, 48,21,104,2.5,5.2, 4.2);
    }
//super() is a special call to the parent class's constructor.
//It tells Java: "Hey, before I finish creating this child object, go run the parent's constructor first."
// Super must be the first line in the child constructor.
}
