public class Exoskeletons extends Monsters{
    //holds all exoskeletons
    String name;
    int monsterLevel;
    int damage;
    int defense;
    int dodgeChance;

    public Exoskeletons(String nm, int mlvl, int dmg, int df, int dgchc) {
        this.name= nm;
        this.monsterLevel=mlvl;
        this.damage=dmg;
        this.defense=df;
        this.dodgeChance=dgchc;
    }


    //takes highest lvl and returns that lvl monster
    public Exoskeletons getExoskeletons(int selection) {
        if (selection==1) {
            name= "BigBad-Wolf";
            monsterLevel=1;
            damage= 150;
            defense= 250;
            dodgeChance= 15;
        } else if (selection==2) {
            name= "WickedWitch";
            monsterLevel=2;
            damage= 250;
            defense= 350;
            dodgeChance= 25;
        } else if (selection==3) {
            name = "Brandobaris";
            monsterLevel = 3;
            damage = 350;
            defense = 450;
            dodgeChance = 30;
        } else if (selection==4) {
            name = "Aasterinian";
            monsterLevel = 4;
            damage = 400;
            defense = 500;
            dodgeChance = 45;
        } else if (selection==5) {
            name = "St-Shargaas";
            monsterLevel = 5;
            damage = 550;
            defense = 650;
            dodgeChance = 55;
        } else if (selection==6) {
            name = "Chronepsish";
            monsterLevel = 6;
            damage = 650;
            defense = 750;
            dodgeChance = 60;
        } else if (selection==7) {
            name = "Cyrrollalee";
            monsterLevel = 7;
            damage = 700;
            defense = 800;
            dodgeChance = 75;
        } else if (selection==8) {
            name = "Kiaransalee";
            monsterLevel = 8;
            damage = 850;
            defense = 950;
            dodgeChance = 85;
        } else if (selection==9) {
            name = "St-Yeenoghu";
            monsterLevel = 9;
            damage = 950;
            defense = 850;
            dodgeChance = 90;
        } else if (selection==10) {
            name = "Exodia";
            monsterLevel = 10;
            damage = 1000;
            defense = 1000;
            dodgeChance = 50;
        }
        return new Exoskeletons(name, monsterLevel, damage, defense, dodgeChance);
    }
}
