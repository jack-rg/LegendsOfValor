import java.lang.reflect.Field;

public class Heroes {
    //each hero stats and info held here
    public static String name;
    //weapon be wielded here
    public static Inventory bag;
    public static Weapons wielding;
    public static Armor holding;
    public static int hp;
    public static int mana;
    public static int heroLevel;
    public static int money;
    public static int xp;
    public static int dexterity;
    public static int strength;
    public static int agility;
    public static  int maxMana;
    public static boolean goodAgility;
    public static boolean goodStrength;
    public static boolean goodDexterity;

    public Heroes(int hpts, int mn, int hlvl, int mny, int exp, int dxty, int strh, int agty, int mxmn, boolean gagty, boolean gstrh, boolean gdxty, Weapons wdg, Inventory bg, String nm, Armor arm) {
        //designed this way for extendability
        this.name=nm;
        this.hp=hpts;
        this.mana=mn;
        this.heroLevel= hlvl;
        this.money=mny;
        this.xp=exp;
        this.dexterity=dxty;
        this.strength=strh;
        this.agility=agty;
        this.maxMana=mxmn;
        this.bag= bg;
        this.wielding= wdg;
        this.holding=arm;
        this.goodAgility=gagty;
        this.goodStrength=gstrh;
        this.goodDexterity=gdxty;

    }



    //initializing type of fighter user chooses
    public static Heroes getHeroes(int chosen, int specific) {
        //Initializing a new hero
        if (chosen== 1) {
            //setting up new warrior
            if (specific == 1) {
                //chose warrior 1
                name= "Gaerdal_Ironhand";
                hp= 100;
                mana=100;
                maxMana=mana;
                heroLevel=1;
                money=1354;
                xp=7;
                dexterity=600;
                strength=700;
                agility=500;
                goodAgility=true;
                goodDexterity=false;
                goodStrength=true;

            } else if (specific == 2) {
                //chose warrior type 2
                name= "Sehanine_Monnbow";
                hp= 100;
                mana=600;
                heroLevel=1;
                money=2500;
                xp=8;
                dexterity=500;
                strength=700;
                maxMana=mana;
                agility=800;
                goodAgility=true;
                goodDexterity=false;
                goodStrength=true;
            } else if (specific ==3) {
                //chose warrior type 3
                name= "Muamman_Duathall";
                hp= 100;
                mana=300;
                heroLevel=1;
                money=2546;
                xp=6;
                dexterity=750;
                maxMana=mana;
                strength=900;
                agility=500;
                goodAgility=true;
                goodDexterity=false;
                goodStrength=true;
            } else if (specific==4) {
                //choose warrior 4
                name= "Flandal_Steelskin";
                hp= 100;
                mana=200;
                heroLevel=1;
                money=2500;
                xp=7;
                dexterity=700;
                maxMana=mana;
                strength=750;
                agility=650;
                goodAgility=true;
                goodDexterity=false;
                goodStrength=true;

            } else if (specific==5 ) {
                //choose warrior 5
                name= "Undefeated_Yoj";
                hp= 100;
                mana=400;
                heroLevel=1;
                money=100;
                xp=7;
                dexterity=700;
                maxMana=mana;
                strength=800;
                agility=400;
                goodAgility=true;
                goodDexterity=false;
                goodStrength=true;

            } else if (specific==6) {
                //choose warrior 6
                name= "Eunoia_Cyn";
                hp= 100;
                mana=400;
                maxMana=mana;
                heroLevel=1;
                money=2500;
                xp=6;
                dexterity=600;
                strength=700;
                agility=800;
                goodAgility=true;
                goodDexterity=false;
                goodStrength=true;

            }
        } else if (chosen== 2) {
            //setting up new sorcerer
            if (specific == 1) {
                //chose sorcerer type 1
                name= "Rillifane_Rallathil";
                hp= 100;
                mana=1300;
                heroLevel=1;
                money=2500;
                xp=9;
                maxMana=mana;
                dexterity=500;
                strength=750;
                agility=450;
                goodAgility=true;
                goodDexterity=true;
                goodStrength=false;
            } else if (specific == 2) {
                //chose sorcerer type 2
                name= "Segojan_Earthcaller";
                hp= 100;
                mana=900;
                heroLevel=1;
                money=2500;
                xp=5;
                maxMana=mana;
                dexterity=650;
                strength=800;
                agility=500;
                goodAgility=true;
                goodDexterity=true;
                goodStrength=false;

            } else if (specific ==3) {
                //chose sorcerer type 3
                name= "Reign_Havoc";
                hp= 100;
                mana=800;
                heroLevel=1;
                money=2500;
                maxMana=mana;
                xp=8;
                dexterity=800;
                strength=800;
                agility=800;
                goodAgility=true;
                goodDexterity=true;
                goodStrength=false;
            } else if (specific==4) {
                //choose sorcerer 4
                name= "Reverie_Ashels";
                hp= 100;
                mana=900;
                maxMana=mana;
                heroLevel=1;
                money=2500;
                xp=7;
                dexterity=400;
                strength=800;
                agility=700;
                goodAgility=true;
                goodDexterity=true;
                goodStrength=false;

            } else if (specific==5 ) {
                //choose sorcerer 5
                name= "Kalabar";
                hp= 100;
                mana=800;
                maxMana=mana;
                heroLevel=1;
                money=2500;
                xp=6;
                dexterity=600;
                strength=850;
                agility=400;
                goodAgility=true;
                goodDexterity=true;
                goodStrength=false;

            } else if (specific==6) {
                //choose sorcerer 6
                name= "Skye_Soar";
                hp= 100;
                mana=1000;
                maxMana=mana;
                heroLevel=1;
                money=2500;
                xp=5;
                dexterity=500;
                strength=700;
                agility=400;
                goodAgility=true;
                goodDexterity=true;
                goodStrength=false;

            }
        } else {
            //setting up new paladin
            if (specific == 1) {
                //chose paladin type 1
                name= "Parzival";
                hp= 100;
                mana=300;
                maxMana=mana;
                heroLevel=1;
                money=2500;
                xp=7;
                dexterity=700;
                strength=750;
                agility=650;
                goodAgility=false;
                goodDexterity=true;
                goodStrength=true;

            } else if (specific == 2) {
                //chose paladin type 2
                name= "Sehanine_Moonbow";
                hp= 100;
                mana=300;
                maxMana=mana;
                heroLevel=1;
                money=2500;
                xp=7;
                dexterity=700;
                strength=750;
                agility=700;
                goodAgility=false;
                goodDexterity=true;
                goodStrength=true;
            } else if (specific ==3) {
                //chose paladin type 3
                name= "Skoraeus_Stonebones";
                hp= 100;
                mana=250;
                maxMana=mana;
                heroLevel=1;
                money=2500;
                xp=4;
                dexterity=350;
                strength=650;
                agility=600;
                goodAgility=false;
                goodDexterity=true;
                goodStrength=true;
            } else if (specific==4) {
                //choose paladin 4
                name= "Garl_Glittergold";
                hp= 100;
                mana=100;
                maxMana=mana;
                heroLevel=1;
                money=2500;
                xp=5;
                dexterity=400;
                strength=600;
                agility=500;
                goodAgility=false;
                goodDexterity=true;
                goodStrength=true;

            } else if (specific==5 ) {
                //choose paladin 5
                name= "Amaryllis_Astra";
                hp= 100;
                mana=500;
                maxMana=mana;
                heroLevel=1;
                money=2500;
                xp=5;
                dexterity=500;
                strength=500;
                agility=500;
                goodAgility=false;
                goodDexterity=true;
                goodStrength=true;

            } else if (specific==6) {
                //choose paladin 6
                name= "Caliber_Heist";
                hp= 100;
                mana=400;
                maxMana=mana;
                heroLevel=1;
                money=2500;
                xp=8;
                dexterity=400;
                strength=400;
                agility=400;
                goodAgility=false;
                goodDexterity=true;
                goodStrength=true;

            }
        }
        bag= new Inventory();
        wielding= new Weapons("Bare_Hands", 2, 1, 250);
        bag.numWeapons=1;
        holding= new Armor("Bare_Skin", 2, 1, 100);
        bag.numArmor=1;

        return new Heroes(hp, mana, heroLevel,money, xp, dexterity, strength, agility, maxMana, goodAgility, goodStrength, goodDexterity, wielding, bag,name,holding);

    }


    //creating methods for Heroes class
    public static void printStat(Heroes thisHero) {
        System.out.println("This is info for hero named: "+ thisHero.name);
        System.out.println("Health points: "+ thisHero.hp);
        System.out.println("Currently wielding: " + thisHero.wielding);
        System.out.println("Mana left: "+ thisHero.mana);
        System.out.println("Hero level: "+ thisHero.heroLevel);
        System.out.println("Money left in wallet: "+ thisHero.money);
        System.out.println("XP: "+ thisHero.xp);
        System.out.println("Dexterity: "+ thisHero.dexterity);
        System.out.println("Strength: "+ thisHero.strength);
        System.out.println("Agility: "+ thisHero.agility);
    }



}
