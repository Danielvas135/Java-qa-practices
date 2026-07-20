package selenium.m4.selenium.tests;

public class Neeko extends Champion {

   public Spell[] spells;


    public Neeko() {
        super("Neeko", "Mid/Support", 610,450, 48,21,104,2.5,5.2, 4.2);

//super() is a special call to the parent class's constructor.
//It tells Java: "Hey, before I finish creating this child object, go run the parent's constructor first."
// Super must be the first line in the child constructor.


        spells = new Spell[4];
        spells[0] = new Spell("Q - Blooming Burst", 60);
        spells[1] = new Spell("W - Shapesplitter", 0);
        spells[2] = new Spell("E - Tangle Barbs", 50);
        spells[3] = new Spell("R - Pop Blossom", 100);
    }
    public void showSpells(){
        System.out.println("\n=== Neeko's Spells ===");
            for(int i = 0; i < spells.length; i++){
                spells[i].showSpell();

    }
    }



}
