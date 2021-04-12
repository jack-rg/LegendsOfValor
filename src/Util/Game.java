package Util;

//Generic Game class that outlines the play of most games
import java.util.*;

public abstract class Game {
	private static Scanner in = new Scanner(System.in); // player input scanner
	private State status; // current state of the game

	// initializes players, objects (such as decks or boards), sets status to begin,
	// and updates over time
	public Game() {
		initPlayers();
		status = State.PLAYING; // start playing game
		while (status == State.PLAYING) {
			playGame(); // run through gameplay
			updateStatus(); // update winner, replay, etc
		}
	}

	public State getStatus() {
		return status;
	}

	public void setStatus(State s) {
		status = s;
	}

	// game-specific methods
	public abstract void initObjects(); // needs details about game-specific objects

	public abstract void initPlayers(); // needs to know what the game requires of a player to begi n

	public abstract void playGame(); // needs game rules

	public abstract void updateStatus(); // needs specification for continuation

	public abstract void reset(); // how to start over

	// generic method for asking players if they want to continue playing or if they
	// wish to complete
	public void replay() {
		System.out.println("Would you like to play a new game? (Y/N)");
		boolean flag = true;
		while (flag) {
			try {
				String ans = in.nextLine();
				if (ans.equals("Y")) {
					status = State.PLAYING;
					reset();
					flag = false;
				} else if (ans.equals("N")) {
					status = State.QUIT;
					System.out.println("Goodbye :)");
					flag = false;
				} else {
					System.out.println("Please input either Y or N");
				}
			} catch (Exception e) {
				System.out.println("Please input either Y or N");
				in.nextLine();
			}
		}
	}

}
