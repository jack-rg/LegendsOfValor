public class Armor {
    //hero armor for purchase
    String name;
    int cost;
    int minHeroLevel;
    int damageReduction;

    public Armor(String nm, int cst, int mhl, int dmgred) {
        this.name= nm;
        this.cost=cst;
        this.minHeroLevel= mhl;
        this.damageReduction=dmgred;

    }

    public Armor getArmor(int selection) {
        //initializing armor
        if (selection==1) {
            //choose platinum shield
            name= "Platinum_Shield";
            cost= 150;
            minHeroLevel=1;
            damageReduction=200;

        } else if (selection==2) {
            name= "Breastplate";
            cost= 350;
            minHeroLevel=3;
            damageReduction=600;
        } else if (selection==3) {
            name= "Full_Body_Armor";
            cost= 1000;
            minHeroLevel=8;
            damageReduction=1100;
        } else if (selection==4) {
            name= "Wizard_Shield";
            cost= 1200;
            minHeroLevel=10;
            damageReduction=1500;
        } else if (selection==5) {
            name= "Guardian_Angel";
            cost= 1000;
            minHeroLevel=10;
            damageReduction=1000;
        }
        return new Armor(name, cost, minHeroLevel, damageReduction);
    }



}
