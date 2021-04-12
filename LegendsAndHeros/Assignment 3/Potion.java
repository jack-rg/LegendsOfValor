import java.util.*;
public class Potion extends Item{
  private ArrayList<String> buffType;
  private int effeciency;
  
  public Potion(String name, int price, int minLevel, int effeciency){
    super(name, price, minLevel, ItemType.POTION);
    this.effeciency = effeciency;
    buffType = new ArrayList<String>();
  }
  
  public Potion(String[] potions){
    super(potions[0], Integer.parseInt(potions[1]), Integer.parseInt(potions[2]), ItemType.POTION);
    this.effeciency = Integer.parseInt(potions[3]);
    buffType = new ArrayList<String>();
    for(String buff:potions[4].split(",")){
      addBuffType(buff);
    }

  }
  
  
  public ArrayList<String> getBuffType(){
    return buffType;
  }
  
  public void addBuffType(String buff){
    buffType.add(buff);
  }
  
  public void setEffeciency(int effeciency){
    this.effeciency = effeciency; 
  }
  
  public int getEffeciency(){
    return effeciency; 
  }
  
  
  public String toString(){
    String ret = "";
    ret += String.format("%-20s %-5d %-5d %-5d ",  getName(),  getPrice(),  getMinLevel(),  getEffeciency());
    for(String stat : getBuffType()){
      ret += String.format("| %-10s|  ",  stat);
    }
    ret += String.format(" \n");
    return ret;
    
  }
  
  
  
}