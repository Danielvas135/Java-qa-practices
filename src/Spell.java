public class Spell {

    public String name;
    public int baseMpCost;
    public int currentMpCost;

    public Spell(String name, int baseMpCost) {
        this.name = name;
        this.baseMpCost = baseMpCost;
        this.currentMpCost = baseMpCost;
    }
    public void levelUpSpell(){
        if(currentMpCost > 0) {
            currentMpCost += 10;  //mana cost increases as you rank up the spell
        }
    }
    public String getName() {
        return name;
    }
    public int getCurrentMpCost() {
        return currentMpCost;
    }
    public void showSpell(){
        System.out.println(name + " - " + currentMpCost + " MP");
    }
}
