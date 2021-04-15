package Map.Tracks;

import Map.Places.Nature;
import Map.Places.Place;
import Util.Token;

//A path track filled with inaccessible areas
public class Boundary extends Track{
    private Place[] places;
    private Place currPlace;
  
 
  public Boundary(int boundID, int length){
    super(boundID);
    places = new Place[length];
    for(int i = 0; i < places.length; i++){
     places[i] = new Nature(i, 0, new Token("XXX"));
    }
    currPlace = places[0];
  }
  
  
  
  public Place getPlace(int row, int col){
   return places[row]; 
  }
  
  public Place getCurrPlace(){
    return currPlace;
  }
  
  public void setCurrPlace(int row, int col){
  currPlace = places[row];
  }
  
    
  public void printTrack(){
 System.out.println("insert print pls");
  }
  
}