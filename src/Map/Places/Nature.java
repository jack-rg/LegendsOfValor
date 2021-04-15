package Map.Places;

import Entities.LegendsEntity;
import Game.LegendsOfValor;
import Util.Token;

public class Nature extends Place {
  
  public Nature(int row, int col, Token natureToken){
    super(row, col, false, natureToken);
  }
  
  public void activatePlace(LegendsEntity e, LegendsOfValor game){
    System.out.println("These woods give you an eerie feeling. Better keep out."); 
  }
  
  
}