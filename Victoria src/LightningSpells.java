public class LightningSpells extends Spells{
    String name;
    int cost;
    int minHeroLevel;
    int damage;
    int manaCost;

    public LightningSpells(String nm, int cst, int mhl, int dmg, int mcst){
        this.name=nm;
        this.cost=cst;
        this.minHeroLevel=mhl;
        this.damage= dmg;
        this.manaCost=mcst;
    }


    public LightningSpells getLightningSpells(int selection) {
        //initializing new weapons
        if (selection == 1) {
            name = "Lightning_Dagger";
            cost = 400;
            minHeroLevel = 1;
            damage = 500;
            manaCost = 150;

        } else if (selection == 2) {
            name = "Thunder_Blast";
            cost = 750;
            minHeroLevel = 4;
            damage = 950;
            manaCost = 400;

        } else if (selection == 3) {
            name = "Electric_Arrows";
            cost = 550;
            minHeroLevel = 5;
            damage = 650;
            manaCost = 200;
        } else if (selection == 4) {
            name = "Spark_Needles";
            cost = 500;
            minHeroLevel = 2;
            damage = 600;
            manaCost = 200;
        }
        return new LightningSpells(name, cost, minHeroLevel, damage, manaCost);
    }
}
