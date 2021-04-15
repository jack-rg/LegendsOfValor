//Common Tile Place in an RPG
import java.util.*;
public class Plains extends Place{
  
  public Plains(int row, int col, Token plainToken, Location location){
    super(row, col, true, location, plainToken);
  }
  
  public void activatePlace(RPG game){
    game.getMap().updateBoard(this.getRowID(), this.getColID());
    System.out.println("Your party sets out along the road!");
    if(dangerCheck()){
      fightSequence(game);
    }
  }
  
  public boolean dangerCheck(){
    double rng = Math.random() * 10;
    return rng < 3;
  }
  
  public void fightSequence(RPG game){
    System.out.println("Oh no! A Monster Ambush!");
    ArrayList<Monster> monsters = generateMonsters();
    ArrayList<Hero> availableHeros = game.player.getTeam();
    while(isFighting(monsters, availableHeros)){
     // heroFight();
     // monsterFight();
    }
  }

public ArrayList<Monster> generateMonsters(){
  ArrayList<Monster> monsters = new ArrayList<Monster>();
 return monsters; 
}

public boolean isFighting(ArrayList<Monster> monsters, ArrayList<Hero> availableHeros){
  boolean flagMonster = false;
  boolean flagHero = false;
  for(Monster m: monsters){
    if(m.isAlive()){
      flagMonster = true;
    }
  }
  for(Hero h: availableHeros){
    if(h.isAlive()){
      flagHero = true;
    }
  }
  return flagHero && flagMonster;
}



}