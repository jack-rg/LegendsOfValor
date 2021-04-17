package Map.Places;

import Entities.LegendsEntity;
import Game.LegendsOfValor;
import Map.Tracks.Track;
import Util.Token;

//Has all the attributes of a market space, but has room for further implementation
public class Nexus extends Market{
  
  public Nexus(Track track, int row, int col, Token nexusType){
    super(track, row, col, nexusType);
  }
  
  public void activatePlace(LegendsEntity h, LegendsOfValor game){
    System.out.println("This area is a Nexus"); 
    super.activatePlace(h, game);
  }
  
  
}