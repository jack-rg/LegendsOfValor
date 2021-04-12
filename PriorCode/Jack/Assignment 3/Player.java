public class Player{
  private String name;
  private Token token;
  private int score;
  
  public Player(String name, Token token){
    this.name = name;
    this.token = token;
    score = 0;
  }
  
  public Player(String name, Token token, int score){
    this.name = name;
    this.token = token;
    this.score = score;
  }
  
  
  public String getName(){
    return name;
  }
  
  public void setName(String name){
    this.name = name; 
  }
  
  public void setToken(Token token){
    this.token = token; 
  }
  
  public Token getToken(){
    return token; 
  }
  
  public void incScore(int points){
    score += points; 
  }
  
  public int getScore(){
    return score; 
  }
  
  
  
}