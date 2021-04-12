public class Monster extends Character{
  private int damage;
  private int defense;
  private int agility;
  
  
  public Monster(String name, int level, int health, int damage, int defense, int agility){
    super(name, level, health);
    this.damage = damage;
    this.damage = damage;
    this.agility = agility;
    
    
  }
  
  
  public int getDamage(){
    return damage; 
  }
  
  public void setDamage(int damage){
    this.damage = damage; 
  }
  
  public void updateDamage(int diff){
    damage += diff; 
  }
  
  public int getDefense(){
    return defense; 
  }
  
  public void setDefense(int defense){
    this.defense = defense; 
  }
  
  public void updateDefense(int diff){
    defense += diff; 
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
  
  
  public String toString(){
    return String.format("%-15s%-5d%-5d%-5d%-5d%-5d%",  getName(),  getLevel(),  getHealth(),  getDamage(), getDefense(), getAgility());
  }
  
  
  
  
}