import java.util.*;
import java.io.*;
public abstract class RPG extends Game{
  public LegendsMap map;
  public RPG_Player player;
  private static Scanner in = new Scanner(System.in);   //player input scanner
  
  
    public abstract void initObjects();
  public abstract void printActions();
  public abstract void updateStatus();
  public abstract void processUserInput();
  
  
  public void playGame(){
    processUserInput();
    updateStatus(); 
  } 
  
  public LegendsMap getMap(){
    return map;
  }
  
  

  
  public void initPlayers(){
    System.out.println("Welcome adventurer! What is your name?");
    String name = in.nextLine();
    player = new RPG_Player(name, new Token("\\o/"));
    initObjects();
    readLines("introduction.txt");
  }
  
  
  
  
  public void showInfo(){
    System.out.println("INFO"); 
  }
  public void checkInventory(){
    System.out.println("Inventory"); 
  }
  
  
  public void quit(){
    System.out.println("Are you sure you want to quit? Press Q to confirm, press any other key to continue playing.");
    String quitting = in.nextLine();
    if(quitting.equalsIgnoreCase("Q")){
      System.out.println("Thanks for playing! Goodbye :)");
      setStatus(State.QUIT);
      
    }
  }
  
  
  private void readLines(String fileName){
    File file = new File(fileName);
    try{
      Scanner fileReader = new Scanner(file);
      while(fileReader.hasNext()){
        System.out.println( fileReader.nextLine()); 
      }
      fileReader.close();
    }
    catch(Exception e){
      System.out.println("Error: issue reading from file"); 
    }
    
  }
  
    public void showInfo() {
    System.out.println("INFO");
  }
  
  public void checkInventory() {
    player.printInventory();
  }
  
  public void reset(){
    initPlayers();
    updateStatus();
  }
  
  
  
  
  
  
}