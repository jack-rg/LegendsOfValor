//Has all the attributes of a market space, but has room for further implementation
public class Nexus extends Market{
  
  public Nexus(int row, int col, Token nexusType){
    super(row, col, nexusType, Location.NEXUS);
  }
  
  public void activatePlace(RPG game){
    System.out.println("This area is a Nexus"); 
    super.activatePlace(game);
  }
  
  
}