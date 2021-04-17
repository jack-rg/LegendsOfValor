package Game;

import java.util.*;

import Util.Game;
import Util.State;

import java.io.*;

public class LegendsOfValor extends Game {
  public static int ENTITY_IDS;
  public static int ITEM_IDS;
  
  public LegendsMap map;
  public LegendsPlayer player;
  private static Scanner in = new Scanner(System.in); // player input scanner
  
  
  public void playGame() {
    processUserInput();
    updateStatus();
  }
  
  public void initObjects(){
    map = new LegendsMap(8, player.getToken());
  }
  
  
  
  public void chooseCharacters() {
    int numHeros = 3;
    ArrayList<Hero> heroSelection = new ArrayList<Hero>();
    loadCharacters(heroSelection);
    System.out.println(
                       "In this game you are given "+numHeros+" random  heroes to adventure with. Warriors are renowned for their strength and speed; paladins, for their speed and power; sorcerers, for their power and strength. May the odds be in your favor... ");
    for(int i = 0; i<numHeros; i++){
      int nextSelection = Math.random(heroSelection.size());
      player.addToTeam(heroSelection.remove(nextSelection)); 
    }
    
    player.printTeamNames();
    in.nextLine();
  }
  
  public void printActions() {
    String leftAlignFormat = "| %-15s | %-4s |%n";
    
    System.out.format("+------------------------+%n");
    System.out.format("|         ACTIONS        |%n");
    System.out.format("+-----------------+------+%n");
    System.out.format(leftAlignFormat, "move up", "w");
    System.out.format(leftAlignFormat, "move down", "s");
    System.out.format(leftAlignFormat, "move left", "a");
    System.out.format(leftAlignFormat, "move right", "d");
    System.out.format(leftAlignFormat, "check info", "i");
    System.out.format(leftAlignFormat, "show map", "m");
    System.out.format(leftAlignFormat, "check inventory", "c");
    System.out.format(leftAlignFormat, "teleport", "t");
    System.out.format(leftAlignFormat, "back", "b");
    
    if (map.getCurrCell() instanceof Common)
      System.out.format(leftAlignFormat, "fight monster", "f");
    
    if (map.getCurrCell() instanceof Nexus)
      System.out.format(leftAlignFormat, "enter market", "e");
    
    System.out.format(leftAlignFormat, "quit", "q");
    System.out.format("+-----------------+------+%n");
    
  }
  
  public void processUserInput() {
    player.rotateCharacter();
    while (true) {
      map.print();
      System.out.println("What would you like to do?");
      printActions();
      String input = in.nextLine();
      switch (input.toLowerCase()) {
        case "w":
          if (map.getCurrCell().getRowID() != 0) {
          this.map.updateBoard(map.getCurrCell().getRowID() - 1, map.getCurrCell().getColID());
          this.map.getCurrCell().activatePlace(this);
        }
          break;
        case "s":
          if (map.getCurrCell().getRowID() != map.getMapDimen() - 1) {
          this.map.updateBoard(map.getCurrCell().getRowID() + 1, map.getCurrCell().getColID());
          this.map.getCurrCell().activatePlace(this);
        }
          break;
        case "a":
          if (map.getCurrCell().getColID() != 0) {
          this.map.updateBoard(map.getCurrCell().getRowID(), map.getCurrCell().getColID() - 1);
          this.map.getCurrCell().activatePlace(this);
        }
          break;
        case "d":
          if (map.getCurrCell().getColID() != map.getMapDimen() - 1) {
          this.map.updateBoard(map.getCurrCell().getRowID(), map.getCurrCell().getColID() + 1);
          this.map.getCurrCell().activatePlace(this);
        }
          break;
        case "i":
          showInfo();
          break;
        case "m":
          break;
        case "e":
          if (map.getCurrCell instanceof Nexus) {
          map.getCurrCell().activatePlace(this);
        }
          break;
        case "c":
          checkInventory();
          break;
        case "q":
          quit();
          break;
        case "t":
          teleport();
          break;
        case "b":
          back();
          break;
        case "f":
          if (map.getCurrCell instanceof Common) {
          map.getCurrCell().activatePlace(this);
        }
        default:
          System.out.println("This move is currently invalid. Please input a proper value");
          break;
      }
    }
  }
  
  public void showInfo() {
    System.out.println("INFO");
  }
  
  public void quit() {
    System.out
      .println("Are you sure you want to quit? Press Q to confirm, press any other key to continue playing.");
    String quitting = in.nextLine();
    if (quitting.equalsIgnoreCase("Q")) {
      System.out.println("Thanks for playing! Goodbye :)");
      setStatus(State.QUIT);
    }
  }
  
  public void checkInventory() {
    player.printInventory();
  }
  
  private void readLines(String fileName) {
    File file = new File(fileName);
    try {
      Scanner fileReader = new Scanner(file);
      while (fileReader.hasNext()) {
        System.out.println(fileReader.nextLine());
      }
      fileReader.close();
    } catch (Exception e) {
      System.out.println("Error: issue reading from file");
    }
    
  }
  
  public void updateStatus() {
    
    //We can also use this method to implement stats for these games that we would print after user quits
    //Gets updated every turn after player input is processed
  }
}
