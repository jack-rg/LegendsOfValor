public class Weapons{
    //holds all weapon types
    String name;
    int cost;
    int minHeroLevel;
    int damage;

    public Weapons(String nm,int cst,int mhl,int dmg) {
        this.name=nm;
        this.cost = cst;
        this.minHeroLevel =mhl;
        this.damage = dmg;
    }

    public Weapons getWeapon(int selection){
        //initializing new weapons
        name= null;
        cost= 0;
        minHeroLevel=0;
        damage=800;
        if (selection==1) {
            name= "Sword";
            cost= 500;
            minHeroLevel=1;
            damage=800;
        } else if (selection==2) {
            name= "Bow";
            cost= 300;
            minHeroLevel=2;
            damage=500;
        } else if (selection==3) {
            name= "Scythe";
            cost= 1000;
            minHeroLevel=6;
            damage=1100;
        } else if (selection==4) {
            name= "Axe";
            cost= 550;
            minHeroLevel=5;
            damage=850;
        } else if (selection==5) {
            name = "TSwords";
            cost = 1400;
            minHeroLevel = 8;
            damage= 1600;
        }
        return new Weapons(name,cost,minHeroLevel,damage);
    }


}
