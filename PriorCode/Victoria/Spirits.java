public class Spirits extends Monsters{
    //holds all spirits
    String name;
    int monsterLevel;
    int damage;
    int defense;
    int dodgeChance;

    public Spirits(String nm, int mlvl, int dmg, int df, int dgchc) {
        this.name= nm;
        this.monsterLevel=mlvl;
        this.damage=dmg;
        this.defense=df;
        this.dodgeChance=dgchc;
    }

    //takes highest lvl and returns that lvl monster
    public Spirits getSpirits(int selection) {
        if (selection==1) {
            name= "Blinky";
            monsterLevel=1;
            damage= 450;
            defense= 350;
            dodgeChance= 35;
        } else if (selection==2) {
            name= "Andrealphus";
            monsterLevel=2;
            damage= 600;
            defense= 500;
            dodgeChance= 40;
        } else if (selection==3) {
            name = "Andromalius";
            monsterLevel = 3;
            damage = 550;
            defense = 450;
            dodgeChance = 25;
        } else if (selection==4) {
            name = "Chiang-shih";
            monsterLevel = 4;
            damage = 700;
            defense = 600;
            dodgeChance = 40;
        } else if (selection==5) {
            name = "FallenAngel";
            monsterLevel = 5;
            damage = 800;
            defense = 700;
            dodgeChance = 50;
        } else if (selection==6) {
            name = "Ereshkigall";
            monsterLevel = 6;
            damage = 950;
            defense = 450;
            dodgeChance = 35;
        } else if (selection==7) {
            name = "Michiresas";
            monsterLevel = 7;
            damage = 350;
            defense = 150;
            dodgeChance = 75;
        } else if (selection==8) {
            name = "Jormunngand";
            monsterLevel = 8;
            damage = 600;
            defense = 900;
            dodgeChance = 20;
        } else if (selection==9) {
            name = "Rakkshasass";
            monsterLevel = 9;
            damage = 550;
            defense = 600;
            dodgeChance = 35;
        } else if (selection==10) {
            name = "Taltecuhti";
            monsterLevel = 10;
            damage = 300;
            defense = 200;
            dodgeChance = 50;
        }
        return new Spirits(name, monsterLevel, damage, defense, dodgeChance);
    }
}
