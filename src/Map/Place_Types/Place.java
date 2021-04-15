package Map.Place_Types;

import Game.LegendsOfValor;
import Map.Cell;
import Map.Location;
import Util.Token;

//Specifies the components of a location in an RPG
public abstract class Place extends Cell {
  public boolean accessiblity;
  
  public Place(int row, int col, boolean accessiblity, Token design){
    super(row, col, design);
    this.accessiblity = accessiblity;
  }
  
  public Place(int row, int col, boolean accessiblity, Location locationType, Token design, Token activeDesign){
    super(row, col, design, activeDesign);
    this.accessiblity = accessiblity;
  }
  
  public abstract void activatePlace(LegendsOfValor game);
  
  
  public boolean isAccessible(){
    return accessiblity; 
  }
  
  public void setAccessibility(boolean accessiblity){
    this.accessiblity = accessiblity; 
  }
  
}