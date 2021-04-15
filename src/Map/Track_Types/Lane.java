//Class that holds a two-column track of places, starting and ending with a row of Nexuses. Monster Nexus spawn first on top of the column.
public class Lane extends Track{
  private Place[][] places;
  private Place currPlace;
  private int currPlaceRowID;
  private int currPlaceColID;
  private int length;
  private boolean isActive;
  
  public Lane(int laneID, int length){
    super(laneID);
    this.length = length;
    places = new Place[length][2];
    isActive = false;
    initPlaces();
  }
  
  private void initPlaces(){
    places[0][0] = new Nexus(0, 0, new Token("~M~"));
    places[0][1] = new Nexus(0, 1, new Token("~M~"));
    for (int r = 1; r < places.length-1; r++) {
      for (int c = 0; c < places[r].length; c++) {
        Place p = generateLocation(r,c);
        places[r][c] = p; 
      }
    }
    places[length-1][0] = new Nexus(length-1, 0, new Token("~H~"));
    places[length-1][1] = new Nexus(length-1, 1, new Token("~H~"));
    currPlaceRowID = length-1;
    currPlaceColID = 0;
    currPlace = places[currPlaceRowID][currPlaceColID];
  }
  
  

  public Place generateLocation(int r, int c){
    double rng = Math.random() * 10;
    if(rng > 6){
      return new Plains(r,c, new Token("==="), Location.PLAINS);
    }
    else if( rng > 4){
      return new Bush(r,c, new Token("***"), Location.BUSH);
    }
    else if( rng > 2){
      return new Koulou(r,c,  new Token("KKK"), Location.KOULOU);
    }
    else{
      return new Cave(r,c,  new Token("CCC"), Location.CAVE); 
    }
  }
  
  public Place getPlace(int row, int col){
   return places[row][col]; 
  }
  
  public Place getCurrPlace(){
    return currPlace;
  }
  
  public void setCurrPlace(int row, int col){
    currPlace = places[row][col];
  }
  
  
  
  public Place[][] getRawPlaces(){
    return places;
  }
  
  
  public boolean isActive(){
    return isActive;
  }
  
  public void setActive(boolean activity){
    isActive = activity;
  }
  
  public void printTrack(){
 System.out.println("insert print pls");
  }
  
  
}