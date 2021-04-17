package Game;

import java.util.*;

import Entities.LegendsHero;
import Entities.LegendsMonster;
import Entities.LegendsPlayer;
import Map.LegendsMap;
import Map.Places.MonsterNexus;
import Map.Places.Nexus;
import Map.Places.PlayerNexus;
import Map.Places.Plains.Plains;
import Util.Game;
import Util.Random;
import Util.State;
import Util.Creation.EntityGenerator;

import java.io.*;

public class LegendsOfValor extends RPG {
	public static int ENTITY_IDS;
	public static int ITEM_IDS;

	public LegendsMap map;
	public LegendsPlayer player;
	public ArrayList<LegendsMonster> monsters;
	private int monsterIndex;

	public Iterator<LegendsHero> itr;
	private static Scanner in = new Scanner(System.in); // player input scanner

	public void initObjects() {
		map = new LegendsMap(5, 8);
		itr = player.getTeam().iterator();
		monsters = new ArrayList<LegendsMonster>();
		generateMonsters(3);
		monsterIndex = 0;
	}

	public void generateMonsters(int toGenerate) {
		ArrayList<LegendsMonster> allMonsters = new ArrayList<LegendsMonster>();
		allMonsters = EntityGenerator.generateMonster(5);
		for (int i = 0; i < toGenerate; i++)
			monsters.add(allMonsters.remove(Random.randomInt(0, allMonsters.size() - 1)));
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

		if (map.getCurrCell() instanceof Plains)
			System.out.format(leftAlignFormat, "fight monster", "f");

		if (map.getCurrCell() instanceof Nexus)
			System.out.format(leftAlignFormat, "enter market", "e");

		System.out.format(leftAlignFormat, "quit", "q");
		System.out.format("+-----------------+------+%n");

	}

	public void processUserInput() {
		LegendsHero currHero = itr.next();
		while (true) {
			map.print();
			System.out.println("What would you like to do?");
			printActions();
			String input = in.nextLine();
			switch (input.toLowerCase()) {
			case "w":
				if (currHero.getCurrPlace().getRowID() != 0) {
					this.map.updateBoard(map.getCurrCell().getRowID(), map.getCurrCell().getColID() + 1);
					this.map.getCurrCell().activatePlace(currHero, this);
				}
				break;
			case "s":
				if (currHero.getCurrPlace().getRowID() != map.getMapDimen() - 1) {
					this.map.updateBoard(map.getCurrCell().getRowID(), map.getCurrCell().getColID() + 1);
					this.map.getCurrCell().activatePlace(currHero, this);
				}
				break;
			case "a":
				if (currHero.getCurrPlace().getRowID() != 0) {
					this.map.updateBoard(map.getCurrCell().getRowID(), map.getCurrCell().getColID() + 1);
					this.map.getCurrCell().activatePlace(currHero, this);
				}
				break;
			case "d":
				if (currHero.getCurrPlace().getRowID() != map.getMapDimen() - 1) {

					this.map.updateBoard(map.getCurrCell().getRowID(), map.getCurrCell().getColID() + 1);
					this.map.getCurrCell().activatePlace(currHero, this);
				}
				break;
			case "i":
				showInfo();
				break;
			case "m":
				break;
			case "e":
				if (currHero.getCurrPlace() instanceof Nexus) {
					this.map.getCurrCell().activatePlace(currHero, this);
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
				if (currHero.getCurrPlace() instanceof Plains) {
					map.getCurrCell().activatePlace(currHero, this);
				}
			default:
				System.out.println("This move is currently invalid. Please input a proper value");
				break;
			}
		}
	}

	public void moveMonster() {
		LegendsMonster currMonster = monsters.get(monsterIndex);

	}

	public void updateStatus() {
		moveMonster();
		for (LegendsHero h : player.getTeam().getHeroes()) {
			if (h.getEntityStats().getCurrHP() <= 0) {
				h.respawn();
			} else if (h.getCurrPlace() instanceof MonsterNexus) {
				this.setStatus(State.WIN);
			}
		}

		for (int i = 0; i < monsters.size(); i++) {
			if (monsters.get(i).getEntityStats().getCurrHP() <= 0) {
				monsters.remove(i);
				i--;
				generateMonsters(1);
			} else if (monsters.get(i).getCurrPlace() instanceof PlayerNexus) {
				this.setStatus(State.LOSE);
			}
		}

		// We can also use this method to implement stats for these games that we would
		// print after user quits
		// Gets updated every turn after player input is processed
	}
}
