package Map.Places;

import Entities.LegendsEntity;
import Game.LegendsOfValor;
import Map.Cell;
import Util.Token;

//Specifies the components of a location in an RPG
public abstract class Place extends Cell {
  public boolean accessiblity;
  
  public Place(int row, int col, boolean accessiblity, Token design){
    super(row, col, design);
    this.accessiblity = accessiblity;
  }
  
  public Place(int row, int col, boolean accessiblity, Token design, Token activeDesign){
    super(row, col, design, activeDesign);
    this.accessiblity = accessiblity;
  }
  
  public abstract void activatePlace(LegendsEntity e, LegendsOfValor game);
  
  
  public boolean isAccessible(){
    return accessiblity; 
  }
  
  public void setAccessibility(boolean accessiblity){
    this.accessiblity = accessiblity; 
  }
  
}