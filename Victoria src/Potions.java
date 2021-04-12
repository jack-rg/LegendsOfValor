public class Potions extends Legends {
    //holds all potion types
    String name;
    int cost;
    int minHeroLevel;
    int attribIncrease;
    boolean affectsHealth;
    boolean affectsMana;
    boolean affectsStrength;
    boolean affectsAgility;
    boolean affectsDexterity;
    boolean affectsDefense;


    public Potions(int selection) {
        //initializing new weapons
        if (selection == 1) {
            name = "Healing_Potion";
            cost = 250;
            minHeroLevel = 1;
            attribIncrease = 100;
            affectsAgility = false;
            affectsHealth = true;
            affectsDefense = false;
            affectsDexterity = false;
            affectsMana = false;
            affectsStrength = false;

        } else if (selection == 2) {
            name = "Strength_Potion";
            cost = 200;
            minHeroLevel = 1;
            attribIncrease = 75;
            affectsAgility = false;
            affectsHealth = false;
            affectsDefense = false;
            affectsDexterity = false;
            affectsMana = false;
            affectsStrength = true;

        } else if (selection == 3) {
            name = "Magic_Potion";
            cost = 350;
            minHeroLevel = 2;
            attribIncrease = 100;
            affectsAgility = false;
            affectsHealth = false;
            affectsDefense = false;
            affectsDexterity = false;
            affectsMana = true;
            affectsStrength = false;

        } else if (selection == 4) {
            name = "Luck_Elixir";
            cost = 500;
            minHeroLevel = 4;
            attribIncrease = 65;
            affectsAgility = true;
            affectsHealth = false;
            affectsDefense = false;
            affectsDexterity = false;
            affectsMana = false;
            affectsStrength = false;

        } else if (selection == 5) {
            name = "Mermaid_Tears";
            cost = 850;
            minHeroLevel = 5;
            attribIncrease = 100;
            affectsAgility = true;
            affectsHealth = true;
            affectsDefense = false;
            affectsDexterity = false;
            affectsMana = true;
            affectsStrength = true;

        } else if (selection == 6) {
            name = "Ambrosia";
            cost = 1000;
            minHeroLevel = 8;
            attribIncrease = 150;
            affectsAgility = true;
            affectsHealth = true;
            affectsDefense = true;
            affectsDexterity = true;
            affectsMana = true;
            affectsStrength = true;

        }
    }
}
