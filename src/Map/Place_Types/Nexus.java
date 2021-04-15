package Map.Place_Types;

import Game.LegendsOfValor;
import Util.Token;

//Has all the attributes of a market space, but has room for further implementation
public class Nexus extends Market{
  
  public Nexus(int row, int col, Token nexusType){
    super(row, col, nexusType);
  }
  
  public void activatePlace(LegendsOfValor game){
    System.out.println("This area is a Nexus"); 
    super.activatePlace(game);
  }
  
  
}