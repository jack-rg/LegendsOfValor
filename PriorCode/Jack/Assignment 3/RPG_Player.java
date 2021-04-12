import java.util.*;
public class RPG_Player extends Player{
  public static Scanner in = new Scanner(System.in);
  public ArrayList<Hero> team;
  
  public RPG_Player(String name, Token token){
    super(name, token);
    team = new ArrayList<Hero>();
  }
  
  public void addToTeam(Hero hero){
   team.add(hero); 
  }
  
  public ArrayList<Hero> getTeam(){
   return team; 
  }

  public Hero chooseHero(){
    if(team.size() == 0){
      System.out.println("Oh no! You have no team members");
      return null;
    }
    else{
    while(true){
      printTeam();
      System.out.println("Please choose which hero to use, or -1 to go back");
      try{
        int input = in.nextInt();
        if(input == -1){
          return null;
        }
        else{
        System.out.println("You chose "+team.get(input).getName());
        return team.get(input);
        }
      }
      catch(Exception e){
        System.out.println("Please input a valid int selection");
        in.next();
      }
    }
  }
  }
  
  public void printTeam(){
    System.out.format("+------------------------+%n");
    System.out.format("|        Your Team       |%n");
    System.out.format("+------------------------+%n");
    int i = 0;
    for(Hero h : team){
     System.out.format("%3d: "+h+"%n", i); 
     i++;
    }
  }

  public void printTeamNames(){
    System.out.format("+------------------------+%n");
    System.out.format("|        Your Team       |%n");
    System.out.format("+------------------------+%n");
    int i = 0;
    for(Hero h : team){
     System.out.format("%3d: "+h.getName()+"%n", i); 
     i++;
    }
  }
  
}