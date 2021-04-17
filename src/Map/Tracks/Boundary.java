package Map.Tracks;

import Map.Places.Nature;
import Map.Places.Place;
import Util.Token;

//A path track filled with inaccessible areas
public class Boundary extends Track{
    private Place[] places;
  
 
  public Boundary(int boundID, int length){
    super(boundID);
    places = new Place[length];
    for(int i = 0; i < places.length; i++){
     places[i] = new Nature(this, i, 0, new Token("XXX"));
    }
  }
 
  public Place getPlace(int row, int col){
   return places[row]; 
  }
    
  public void printTrack(){
 System.out.println("insert print pls");
  }
  
}