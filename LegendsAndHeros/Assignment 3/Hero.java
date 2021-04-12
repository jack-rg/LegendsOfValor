public class Hero extends Character{
  private int mana;
  private int money;
  private int exp;
  private int dexterity;
  private int agility;
  private int strength;
  private Inventory inventory;
  private HeroType id;
  
  public Hero(String name, int level, int health, int mana, int money, int exp, int dexterity, int agility, int strength, HeroType id){
    super(name, level, health);
    this.mana = mana;
    this.money = money;
    this.exp = exp;
    this.dexterity = dexterity;
    this.agility = agility;
    this.strength = strength;
    this.id = id;
    inventory = new Inventory();
  }


  public Hero(String[] hero, HeroType id){
    super(hero[0], Integer.parseInt(hero[6]), 100*Integer.parseInt(hero[6]));
    this.mana = Integer.parseInt(hero[1]);
    this.strength = Integer.parseInt(hero[2]);
    this.agility = Integer.parseInt(hero[3]);
    this.dexterity = Integer.parseInt(hero[4]);
    this.money = Integer.parseInt(hero[5]);
    this.exp = 100*Integer.parseInt(hero[6]);
    this.id = id;
    inventory = new Inventory();
  }
  



  public Inventory accessInventory(){
    return inventory;
  }
  
  
  
  //Getters, Setters, Updaters
  public HeroType getID(){
    return id;
  }

  public int getMana(){
    return mana; 
  }
  
  public void setMana(int mana){
    this.mana = mana; 
  }
  
  public void updateMana(int diff){
    mana += diff; 
  }
  
  public int getMoney(){
    return money; 
  }
  
  public void setMoney(int money){
    this.money = money; 
  }
  
  public void updateMoney(int diff){
    money += diff; 
  }
  
  
  public int getExp(){
    return exp; 
  }
  
  public void setExp(int exp){
    this.exp = exp; 
  }
  
  public void updateExp(int diff){
    exp += diff; 
  }
  
  public int getDexterity(){
    return dexterity; 
  }
  
  public void setDexterity(int dexterity){
    this.dexterity = dexterity; 
  }
  
  public void updateDexterity(int diff){
    dexterity += diff; 
  }
  
  public int getAgility(){
    return agility; 
  }
  
  public void setAgility(int agility){
    this.agility = agility; 
  }
  
  public void updateAgility(int diff){
    agility += diff; 
  }
  
  
  public int getStrength(){
    return strength; 
  }
  
  public void setStrength(int strength){
    this.strength = strength; 
  }
  
  public void updateStrength(int diff){
    strength += diff; 
  }
  
  public String toString(){
    return String.format("%-20s | %-5d | %-5d | %-5d | %-5d | %-5d | %-5d | %-5d | %-5d |",  getName(),  getLevel(),  getHealth(),  getMana(), getMoney(), getExp(), getDexterity(), getAgility(), getStrength() );
  }
  
}