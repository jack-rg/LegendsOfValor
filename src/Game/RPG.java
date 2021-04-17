package Game;

import java.util.*;

import Entities.LegendsHero;
import Entities.LegendsPlayer;
import Map.LegendsMap;
import Util.Game;
import Util.State;
import Util.Token;

import java.io.*;

public abstract class RPG extends Game {
	public LegendsMap map;
	public LegendsPlayer player;
	private static Scanner in = new Scanner(System.in); // player input scanner

	public abstract void initObjects();

	public abstract void printActions(LegendsHero currHero);

	public abstract void updateStatus();

	public abstract void processUserInput();

	public void gameWon() {
		System.out.println("YOU WON!");
	}
	
	public void gameLost() {
		System.out.println("YOU LOST!");
	}
	
	public void gameQuit() {
		System.out.println("YOU QUIT!");
	}
	
	public void playGame() {
		processUserInput();
	}

	public LegendsMap getMap() {
		return map;
	}

	public void initPlayers() {
		player = new LegendsPlayer(1, new Token("\\o/"));
		initObjects();
		readLines("introduction.txt");
	}

	public void quit() {
		System.out
				.println("Are you sure you want to quit? Press Q to confirm, press any other key to continue playing.");
		String quitting = in.nextLine();
		if (quitting.equalsIgnoreCase("Q")) {
			setStatus(State.QUIT);

		}
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

	public void showInfo() {
		System.out.println("INFO");
	}

	public void checkInventory() {
		//TODO implement
		for (LegendsHero h : player.getTeam()) {
			h.getInventory().printInventory();
		}
	}

	public void reset() {
		initPlayers();
		updateStatus();
	}

}