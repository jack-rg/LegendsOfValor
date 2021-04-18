package Game;

import java.util.*;

import Entities.LegendsHero;
import Entities.LegendsPlayer;
import Items.LegendsArmour;
import Items.LegendsItem;
import Items.LegendsWeapon;
import Map.LegendsMap;
import Util.Game;
import Util.State;

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
		player = new LegendsPlayer(1);
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

	public void checkInventory(LegendsHero h) {
		LegendsItem item = h.getInventory().accessInventory();

		if (item instanceof LegendsWeapon) {
			h.getInventory().replaceEquippedWeapon((LegendsWeapon) item);
		} else if (item instanceof LegendsArmour) {
			LegendsArmour castedItem = (LegendsArmour) item;
			LegendsArmour priorItem = null;

			switch (castedItem.getSlot()) {
			case "Head":
				priorItem = h.getInventory().getEquippedArmour().getHeadPiece();
				h.getInventory().getEquippedArmour().setHeadPiece(castedItem);
				break;
			case "Chest":
				priorItem = h.getInventory().getEquippedArmour().getChestPiece();
				h.getInventory().getEquippedArmour().setChestPiece(castedItem);
				break;
			case "Legs":
				priorItem = h.getInventory().getEquippedArmour().getLegPiece();
				h.getInventory().getEquippedArmour().setLegPiece(castedItem);
				break;
			case "Feet":
				priorItem = h.getInventory().getEquippedArmour().getFeetPiece();
				h.getInventory().getEquippedArmour().setFeetPiece(castedItem);
				break;
			}

			if (priorItem != null)
				h.getInventory().add(priorItem);
		} else {
			System.out.println("You cannot use this item here!");
		}
	}

	public void reset() {
		initPlayers();
		updateStatus();
	}

}