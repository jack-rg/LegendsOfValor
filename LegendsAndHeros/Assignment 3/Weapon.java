public class Weapon extends Item{
  private int damageLevel;
  private int numHandsRequired;
  
  public Weapon(String name, int price, int minHeroLevel, int damageLevel, int numHandsRequired){
    super(name, price, minHeroLevel, ItemType.WEAPON);
    this.damageLevel = damageLevel;
    this.numHandsRequired = numHandsRequired;
  }

  public Weapon(String[] weapon){
    super(weapon[0], Integer.parseInt(weapon[1]), Integer.parseInt(weapon[2]), ItemType.WEAPON);
    damageLevel = Integer.parseInt(weapon[3]);
    numHandsRequired = Integer.parseInt(weapon[4]);
  }
  
  public int getDamageLevel(){
    return damageLevel;
  }
  
  public void setDamageLevel(int damage){
    damageLevel = damage;
  }
  
  public void getNumHands(int hands){
    numHandsRequired = hands; 
  }
  
  public int getNumHands(){
    return numHandsRequired; 
  }
  
  
  public String toString(){

    return String.format("%-15s%-5d%-5d%-5d%-2d %n",  getName(),  getPrice(),  getMinLevel(),  getDamageLevel(), getNumHands() );
  }
  
  
}