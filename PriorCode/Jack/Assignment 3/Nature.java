public class Nature extends Place{
  
  public Nature(int row, int col, Token teamToken){
    super(row, col, false, Location.NATURE, new Token("XXX"), teamToken);
  }
  
  public void activatePlace(RPG game){
    System.out.println("These woods give you an eerie feeling. Better keep out."); 
  }
  
  
}