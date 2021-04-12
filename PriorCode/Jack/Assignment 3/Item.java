public class Item{
  private String name;
  private int price; 
  private int minLevel;
  private ItemType id;
  
  public Item(String name, int price, int minLevel, ItemType id){
    this.name = name;
    this.price = price;
    this.minLevel = minLevel;
    this.id = id;
  }
  
  public ItemType getID(){
    return id;
  }

  public void setName(String name){
    this.name = name;
  }
  
  public String getName(){
    return name;
  }
  
  public void setPrice(int price){
    this.price = price;
  }
  
  public int getPrice(){
    return price;
  }
  
  public void setMinLevel(int level){
    minLevel = level;
  }
  
  public int getMinLevel(){
    return minLevel;
  }
  
  
}