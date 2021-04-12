public class FireSpells extends Spells{
    //holds fire spells
    String name;
    int cost;
    int minHeroLevel;
    int damage;
    int manaCost;

    public FireSpells(String nm, int cst, int mhl, int dmg, int mcst) {
        this.name=nm;
        this.cost=cst;
        this.minHeroLevel=mhl;
        this.manaCost=mcst;
    }


    public FireSpells getFireSpells(int selection) {
        //initializing new weapons
        if (selection == 1) {
            name = "Flame_Tornado";
            cost = 700;
            minHeroLevel = 4;
            damage = 850;
            manaCost = 300;

        } else if (selection == 2) {
            name = "Breath_of_Fire";
            cost = 350;
            minHeroLevel = 1;
            damage = 450;
            manaCost = 100;

        } else if (selection == 3) {
            name = "Heat_Wave";
            cost = 450;
            minHeroLevel = 2;
            damage = 600;
            manaCost = 150;
        } else if (selection == 4) {
            name = "Lava_Comet";
            cost = 800;
            minHeroLevel = 7;
            damage = 1000;
            manaCost = 550;
        } else if (selection == 5) {
            name = "Hell_Storm";
            cost = 600;
            minHeroLevel = 3;
            damage = 950;
            manaCost = 600;
        }
        return new FireSpells(name, cost, minHeroLevel, damage, manaCost);
    }
}
