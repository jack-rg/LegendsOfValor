public class Armor extends Item{
  private int defenseLevel;
  
  public Armor(String name, int price, int minHeroLevel, int defenseLevel){
    super(name, price, minHeroLevel, ItemType.ARMOR);
    this.defenseLevel = defenseLevel;
  }

  
  public Armor(String[] armor){
    super(armor[0], Integer.parseInt(armor[1]), Integer.parseInt(armor[2]), ItemType.ARMOR);
    defenseLevel = Integer.parseInt(armor[3]);
  }
  
  public int getDefenseLevel(){
    return defenseLevel;
  }
  
  public void setDefenseLevel(int defense){
    defenseLevel = defense;
  }
  
  public String toString(){
    return String.format("%-15s %-5d %-5d %-5d  \n",  getName(),  getPrice(),  getMinLevel(),  getDefenseLevel());
  }
  
  
}