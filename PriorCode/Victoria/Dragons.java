public class Dragons extends Monsters{
    //holds all dragons
    String name;
    int monsterLevel;
    int damage;
    int defense;
    int dodgeChance;

    public Dragons(String nm, int mlvl, int dmg, int df, int dgchc) {
        this.name= nm;
        this.monsterLevel=mlvl;
        this.damage=dmg;
        this.defense=df;
        this.dodgeChance=dgchc;
    }

    //takes highest lvl and returns that lvl monster
    public Dragons getDragons(int selection) {
        if (selection==1) {
            name= "Natsunomeryu";
            monsterLevel=1;
            damage= 100;
            defense= 200;
            dodgeChance= 10;
        } else if (selection==2) {
            name= "Chrysophylax";
            monsterLevel=2;
            damage= 200;
            defense= 500;
            dodgeChance= 20;
        } else if (selection==3) {
            name = "Desghidorrah";
            monsterLevel = 3;
            damage = 300;
            defense = 400;
            dodgeChance = 35;
        } else if (selection==4) {
            name = "BunsenBurner";
            monsterLevel = 4;
            damage = 400;
            defense = 500;
            dodgeChance = 45;
        } else if (selection==5) {
            name = "Kas-Ethelinh";
            monsterLevel = 5;
            damage = 600;
            defense = 500;
            dodgeChance = 60;
        } else if (selection==6) {
            name = "Phaarthurnax";
            monsterLevel = 6;
            damage = 600;
            defense = 600;
            dodgeChance = 60;
        } else if (selection==7) {
            name = "TheScaleless";
            monsterLevel = 7;
            damage = 700;
            defense = 600;
            dodgeChance = 75;
        } else if (selection==8) {
            name = "TheWeatherbe";
            monsterLevel = 8;
            damage = 800;
            defense = 900;
            dodgeChance = 80;
        } else if (selection==9) {
            name = "D-Maleficent";
            monsterLevel = 9;
            damage = 900;
            defense = 950;
            dodgeChance = 85;
        } else if (selection==10) {
            name = "Alexstraszan";
            monsterLevel = 10;
            damage = 1000;
            defense = 9000;
            dodgeChance = 55;
        }
        return new Dragons(name, monsterLevel, damage, defense, dodgeChance);
    }
}
