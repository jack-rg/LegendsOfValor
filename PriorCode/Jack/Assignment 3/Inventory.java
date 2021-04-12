import java.util.*;
public class Inventory{
  private static ArrayList<Weapon> weapons;
  private ArrayList<Armor> armors;
  private ArrayList<Potion> potions;
  private ArrayList<Spell> spells;

  public Inventory() {
    weapons = new ArrayList<Weapon>();
    armors = new ArrayList<Armor>();
    potions = new ArrayList<Potion>();
    spells = new ArrayList<Spell>();
  }

  // Getters, Adders, Removers, Printers
  public ArrayList<Weapon> getWeapons() {
    return weapons;
  }

  public void addWeapon(Weapon weapon) {
    weapons.add(weapon);
  }
  
  public Weapon removeWeapon(int index){
    return weapons.remove(index); 
  }
  
  public void printWeapons(){
    System.out.format("+------------------------+%n");
    System.out.format("|          WEAPONS       |%n");
    System.out.format("+------------------------+%n");
    printItems(weapons);
  }
  
  
  public ArrayList<Armor> getArmors(){
    return armors;
  }
  
  public void addArmor(Armor armor){
    armors.add(armor); 
  }
  
  public Armor removeArmor(int index){
    return armors.remove(index); 
  }
  
  public void printArmors(){
    System.out.format("+------------------------+%n");
    System.out.format("|          ARMORS        |%n");
    System.out.format("+------------------------+%n");
    printItems(armors);
  }
  
  public ArrayList<Potion> getPotions(){
    return potions;
  }
  
  public void addPotion(Potion potion){
    potions.add(potion); 
  }
  
  public Potion removePotion(int index){
    return potions.remove(index); 
  }
  
  public void printPotions(){
    System.out.format("+------------------------+%n");
    System.out.format("|          POTIONS       |%n");
    System.out.format("+------------------------+%n");
    printItems(potions);
  }
  
  public ArrayList<Spell> getSpells(){
    return spells;
  }
  
  public void addSpell(Spell spell){
    spells.add(spell); 
  }
  
  public Spell removeSpell(int index){
    return spells.remove(index); 
  }
  
  public void printSpells(){
    System.out.format("+------------------------+%n");
    System.out.format("|          SPELLS        |%n");
    System.out.format("+------------------------+%n");
    printItems(spells);
  }
  
  public void printInventory(){
    System.out.format("+------------------------+%n");
    System.out.format("|        INVENTORY       |%n");
    System.out.format("+------------------------+%n");
    printWeapons();
    printArmors();
    printPotions();
    printSpells();
  }
  
  
  
  public void printItems(List<?> list) {
    for (int i=0; i< list.size(); i++) {
      System.out.print(i+": "+list.get(i));
    }
  }
  



}