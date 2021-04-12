public class IceSpells extends Spells{
    String name;
    int cost;
    int minHeroLevel;
    int damage;
    int manaCost;

    public IceSpells(String nm, int cst, int mhl, int dmg, int mcst){
        this.name=nm;
        this.cost=cst;
        this.minHeroLevel=mhl;
        this.damage= dmg;
        this.manaCost=mcst;
    }


    public IceSpells getIceSpells(int selection) {
        //initializing new weapons
        if (selection == 1) {
            name = "Snow_Cannon";
            cost = 500;
            minHeroLevel = 2;
            damage = 650;
            manaCost = 250;

        } else if (selection == 2) {
            name = "Ice_Blade";
            cost = 250;
            minHeroLevel = 1;
            damage = 450;
            manaCost = 100;

        } else if (selection == 3) {
            name = "Frost_Blizzard";
            cost = 750;
            minHeroLevel = 5;
            damage = 850;
            manaCost = 350;
        } else if (selection == 4) {
            name = "Arctic_Storm";
            cost = 700;
            minHeroLevel = 6;
            damage = 800;
            manaCost = 300;
        }
        return new IceSpells(name, cost, minHeroLevel, damage, manaCost);
    }


}
