public class Nature extends Place{
  
  public Nature(int row, int col, Token natureToken, Location location){
    super(row, col, false, location, natureToken);
  }
  
  public void activatePlace(RPG game){
    System.out.println("These woods give you an eerie feeling. Better keep out."); 
  }
  
  
}