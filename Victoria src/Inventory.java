import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    //holds a heroes potions, weapons, and armor
    public static Scanner scan= new Scanner(System.in);
    int numWeapons;
    int numPotions;
    int numArmor;
    int numLightningSpells;
    int numFireSpells;
    int numIceSpells;

    ArrayList<Weapons> weaponsOwned;
    ArrayList<Potions> potionsOwned;
    ArrayList<Armor> armorOwned;
    ArrayList<LightningSpells> lightningSpellsOwned;
    ArrayList<FireSpells> fireSpellsOwned;
    ArrayList<IceSpells> iceSpellsOwned;

// how to initialize in Heroes class as a field?
    public Inventory() {
        numPotions=0;
        numLightningSpells=0;
        numIceSpells=0;
        numFireSpells=0;
        numArmor=0;
        numWeapons=0;

        weaponsOwned=new ArrayList<>() ;
        lightningSpellsOwned=new ArrayList<>() ;
        potionsOwned=new ArrayList<>() ;
        armorOwned=new ArrayList<>() ;
        fireSpellsOwned= new ArrayList<>() ;
        iceSpellsOwned= new ArrayList<>() ;

    }


    //starts shopping for the hero
    public static void shopping(Heroes thisHero) {
        //shopping between items from market
        boolean purchasing =true;
        boolean choosingType=true;
        String shoppingFor= " ";


        while(purchasing) {
            System.out.println("What would you like to shop for? \n" +
                    "(1) Weapons\n" +
                    "(2) Potions\n" +
                    "(3) Lightning Spells\n" +
                    "(4) Ice Spells\n" +
                    "(5) Fire Spells\n" +
                    "(6) Armor\n" +
                    "(7) Exit");
            while (choosingType) {
                shoppingFor= scan.nextLine();
                if (shoppingFor.equals("1") || shoppingFor.equals("1") || shoppingFor.equals("1") ||shoppingFor.equals("1") ) {
                    //print corresponding shopping items
                }

            }


        }


    }

    //starts selling for the hero
    public static void selling(Heroes thisHero) {

        System.out.println("What would you like to sell? the current items in your bag are: ");
        for (int w=0; w<thisHero.bag.numArmor; w++) {
            System.out.println("(1) " + thisHero.bag.armorOwned.get(w).name + ": cost:" + thisHero.bag.armorOwned.get(w).cost);
        }
        for (int w=0; w<thisHero.bag.numWeapons; w++) {
            System.out.println("(2) " + thisHero.bag.weaponsOwned.get(w).name + ": cost:" + thisHero.bag.weaponsOwned.get(w).cost);
        }
        for (int w=0; w<thisHero.bag.numPotions; w++) {
            System.out.println("(3) " + thisHero.bag.potionsOwned.get(w).name + ": cost:" + thisHero.bag.potionsOwned.get(w).cost);
        }
        for (int w=0; w<thisHero.bag.numLightningSpells; w++) {
            System.out.println("(4) " + thisHero.bag.lightningSpellsOwned.get(w).name + ": cost:" + thisHero.bag.lightningSpellsOwned.get(w).cost);
        }
        for (int w=0; w<thisHero.bag.numFireSpells; w++) {
            System.out.println("(5) " + thisHero.bag.fireSpellsOwned.get(w).name + ": cost:" + thisHero.bag.fireSpellsOwned.get(w).cost);
        }
        for (int w=0; w<thisHero.bag.numIceSpells; w++) {
            System.out.println("(6) " + thisHero.bag.iceSpellsOwned.get(w).name + ": cost:" + thisHero.bag.iceSpellsOwned.get(w).cost);
        }

    }

}
