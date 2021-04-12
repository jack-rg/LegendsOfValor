import java.util.*;
public class Path extends Place{
  
  public Path(int row, int col, Token teamToken){
    super(row, col, true, Location.PATH, new Token("==="), teamToken);
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