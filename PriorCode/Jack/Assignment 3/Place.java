public abstract class Place extends Cell{
  public boolean accessiblity;
  public Location locationType;
  
  public Place(int row, int col, boolean accessiblity, Location locationType, Token design){
    super(row, col, design);
    this.accessiblity = accessiblity;
    this.locationType = locationType;
  }
  
  public Place(int row, int col, boolean accessiblity, Location locationType, Token design, Token activeDesign){
    super(row, col, design, activeDesign);
    this.accessiblity = accessiblity;
    this.locationType = locationType;
  }
  
  public abstract void activatePlace(RPG game);
  
  
  public boolean isAccessible(){
    return accessiblity; 
  }
  
  public void setAccessibility(boolean accessiblity){
    this.accessiblity = accessiblity; 
  }
  
  public Location getLocation(){
    return locationType; 
  }
  
  
  
  
}