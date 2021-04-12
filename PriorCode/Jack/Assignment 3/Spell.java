public class Spell extends Item{
  private String elementType;
  private int damageLevel;
  private int manaRequired;
  
  public Spell(String name, int price, int minLevel, String elementType, int damageLevel, int manaRequired){
    super(name, price, minLevel, ItemType.SPELL);
    this.elementType = elementType;
    this.damageLevel = damageLevel;
    this.manaRequired = manaRequired;
    
  }
  

  public Spell(String[] spells){
    super(spells[0], Integer.parseInt(spells[1]), Integer.parseInt(spells[2]), ItemType.SPELL);
    elementType = spells[3];
    damageLevel = Integer.parseInt(spells[4]);
    manaRequired = Integer.parseInt(spells[5]);
    
  }

  
  public String getElementType(){
    return elementType;
  }
  
  public void setElementType(String elementType){
    this.elementType = elementType;
  }
  
  public void setDamageLevel(int damage){
    damageLevel = damage; 
  }
  
  public int getDamageLevel(){
    return damageLevel; 
  }
  
  public void setManaRequired(int mana){
    manaRequired = mana; 
  }
  
  public int getManaRequired(){
    return manaRequired; 
  }
  
  public String toString(){
    return String.format("%-15s%-5d%-5d%-10s%-5d%-5d  \n",  getName(),  getPrice(),  getMinLevel(),  getElementType(),  getDamageLevel(),  getManaRequired());
  }
  
  
}