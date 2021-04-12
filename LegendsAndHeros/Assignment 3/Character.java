public class Character{
  private String name;
  private int level;
  private int health;
  private boolean isAlive;
  
  public Character(String name, int level, int health){
    this.name = name;
    this.level = level;
    this.health = health;
    this.isAlive = true;
  }
  
public boolean isAlive(){
  return isAlive;
}

public void setAlive(boolean lifeState){
  isAlive = lifeState;
}

  public String getName(){
    return name;
  }
  

  public void setName(String name){
    this.name = name;
  }
  
  public int getLevel(){
    return level;
  }
  
  public void setLevel(int level){
    this.level = level;
  }
  
  public void levelUp(int levelUp){
    level+=levelUp; 
  }
  
  public int getHealth(){
    return health;
  }
  
  public void setHealth(int hp){
    health = hp;
  }
  
  public void updateHealth(int diff){
    health += diff; 
  }
  
  
}