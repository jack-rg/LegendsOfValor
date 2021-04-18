package Game;

import java.util.*;

import Entities.LegendsHero;
import Entities.LegendsMonster;
import Map.LegendsMap;
import Map.Places.MonsterNexus;
import Map.Places.Nexus;
import Map.Places.Place;
import Map.Places.PlayerNexus;
import Util.Random;
import Util.State;
import Util.Token;
import Util.Creation.EntityGenerator;

public class LegendsOfValor extends RPG {
	public static int ENTITY_IDS;
	public static int ITEM_IDS;

	public ArrayList<LegendsMonster> monsters;

	private int roundCounter;

	public Iterator<LegendsHero> itr;
	private static Scanner in = new Scanner(System.in); // player input scanner

	public void initObjects() {
		map = new LegendsMap(5, 8);
		itr = player.getTeam().iterator();
		monsters = new ArrayList<LegendsMonster>();
		generateMonsters(3);
		for (LegendsMonster m : monsters) {
			System.out.println(m.getName());
		}
		spawnEntities();
	}

	private void spawnEntities() {
		int trackCounter = 0;
		for (int i = 0; i < 3; i++) {
			Place heroSpawnPlace = map.getPlace(trackCounter, map.getMapDimen() - 1, 0);
			Place monsterSpawnPlace = map.getPlace(trackCounter, 0, 0);
			player.getTeam().getHeroes().get(i).setCurrPlace(heroSpawnPlace);
			heroSpawnPlace.addHeroOnCell(player.getTeam().getHeroes().get(i));
			player.getTeam().getHeroes().get(i).setSpawnPlace(heroSpawnPlace);
			monsters.get(i).setCurrPlace(monsterSpawnPlace);
			monsterSpawnPlace.addMonsterOnCell(monsters.get(i));
			monsters.get(i).setSpawnPlace(monsterSpawnPlace);

			trackCounter += 2;
		}
	}

	public void generateMonsters(int toGenerate) {
		ArrayList<LegendsMonster> allMonsters = new ArrayList<LegendsMonster>();
		allMonsters = EntityGenerator.generateMonster(5);
		for (int i = 0; i < toGenerate; i++) {
			monsters.add(allMonsters.remove(Random.randomInt(0, allMonsters.size() - 1)));
			monsters.get(i).setToken(new Token("VoV"));
			monsters.get(i).setName(monsters.get(i).getName());
		}
	}

	public void printActions(LegendsHero currHero) {
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

		if (currHero.getCurrPlace() instanceof Nexus)
			System.out.format(leftAlignFormat, "enter market", "e");

		System.out.format(leftAlignFormat, "quit", "q");
		System.out.format("+-----------------+------+%n");

	}

	public void processUserInput() {
		for (LegendsMonster m : monsters) {
			System.out.println(m.getName());
		}

		this.roundCounter++;

		if (roundCounter % (3 * 10) == 0)
			spawnNewMonsters();
		if (roundCounter % (3 * 15) == 0)
			respawnHeroes();

		LegendsHero currHero = itr.next();
		int currRowID = currHero.getCurrPlace().getRowID();
		int currColID = currHero.getCurrPlace().getColID();

		if (currHero.getEntityStats().getCurrHP() <= 0)
			return;

		boolean cont = true;
		while (cont) {
			System.out.println();
			map.print();
			// System.out.println(currRowID + " " + currColID);
			System.out.println("What would you like to do with " + currHero.getName() + "?");
			printActions(currHero);
			String input = in.nextLine();
			System.out.println();
			switch (input.toLowerCase()) {
			case "w":
				if (currRowID != 0) {
					currHero.updatePosition(currRowID - 1, currColID, this);
					cont = false;
				} else {
					System.out.println("You can't reach this location! Try moving elsewhere.");
				}
				break;
			case "s":
				if (currRowID != map.getMapDimen() - 1) {
					currHero.updatePosition(currRowID + 1, currColID, this);
					cont = false;
				} else {
					System.out.println("You can't reach this location! Try moving elsewhere.");
				}
				break;
			case "a":
				if (currColID != 0) {
					currHero.updatePosition(currRowID, currColID - 1, this);
					cont = false;
				} else {
					System.out.println("You can't reach this location! Try moving elsewhere.");
				}
				break;
			case "d":
				if (currColID != map.getMapDimen() - 1) {
					currHero.updatePosition(currRowID, currColID + 1, this);
					cont = false;
				} else {
					System.out.println("You can't reach this location! Try moving elsewhere.");
				}
				break;
			case "i":
				showInfo();
				cont = false;
				break;
			case "m":
				break;
			case "e":
				if (currHero.getCurrPlace() instanceof Nexus) {
					currHero.getCurrPlace().activatePlace(currHero, this);
				}
				break;
			case "c":
				checkInventory(currHero);
				break;
			case "q":
				quit();
				cont = false;
				break;
			case "t":
				currHero.teleport(this);
				cont = false;
				break;
			case "b":
				currHero.resetPosition();
				cont = false;
				break;
			default:
				System.out.println("This move is currently invalid. Please input a proper value");
				break;
			}
		}

		if (currHero.getID() == player.getTeam().getHeroes().get(player.getTeam().getHeroes().size() - 1).getID()) {
			this.moveMonsters();
		}
	}

	private void showInfo() {
		System.out.format("+------------------------+%n");
		System.out.format("|        HERO INFO       |%n");
		System.out.format("+------------------------+%n");
		helperLine(127);
		System.out.printf(
				"|                        NAME                        | LEVEL |  HP   |  MANA   |  COINS  |  EXP  |   DEX   | AGILITY | STRENGTH | %n");
		helperLine(127);
		for (LegendsHero h : player.getTeam().getHeroes()) {
			System.out.print(h);
			helperLine(127);
		}

		System.out.println();

		System.out.format("+------------------------+%n");
		System.out.format("|       MONSTER INFO     |%n");
		System.out.format("+------------------------+%n");
		helperLine(105);
		System.out.printf(
				"|                        NAME                        | LEVEL |  HP   |  EXP  | DODGE | DEFENSE | STRENGTH | %n");
		helperLine(105);
		for (LegendsMonster m : monsters) {
			System.out.print(m);
			helperLine(105);
		}
	}

	private void respawnHeroes() {
		for (LegendsHero h : player.getTeam().getHeroes()) {
			if (h.getEntityStats().getCurrHP() <= 0) {
				h.respawn();
			}
		}
	}

	private void spawnNewMonsters() {
		int priorSize = monsters.size();
		this.generateMonsters(3);
		int trackCounter = 0;
		for (int i = priorSize; i < 3 + priorSize; i++) {
			Place monsterSpawnPlace = map.getPlace(trackCounter, 0, 0);
			monsters.get(i).setCurrPlace(monsterSpawnPlace);
			monsters.get(i).setSpawnPlace(monsterSpawnPlace);
			monsterSpawnPlace.addMonsterOnCell(monsters.get(i));

			trackCounter += 2;
		}
	}

	public void moveMonsters() {
		System.out.println("Monster Size: " + monsters.size());
		for (LegendsMonster m : monsters) {
			System.out.println("Current place: " + m.getCurrPlace());
			m.updatePosition(m.getCurrPlace().getRowID() + 1, m.getCurrPlace().getColID(), this);
		}
	}

	public void updateStatus() {
		for (LegendsHero h : player.getTeam().getHeroes()) {
			if (h.getEntityStats().getCurrHP() <= 0) {
				h.getCurrPlace().removeHeroOnCell(h);
			} else if (h.getCurrPlace() instanceof MonsterNexus) {
				this.setStatus(State.WIN);
			}
		}

		for (int i = 0; i < monsters.size(); i++) {
			if (monsters.get(i).getEntityStats().getCurrHP() <= 0) {
				monsters.get(i).getCurrPlace().removeMonsterOnCell(monsters.get(i));
				monsters.remove(i);

				i--;
			} else if (monsters.get(i).getCurrPlace() instanceof PlayerNexus) {
				this.setStatus(State.LOSE);
			}
		}
	}

	public static void helperLine(int amount) {
		System.out.print("+");
		for (int i = 0; i < amount; i++) {
			System.out.print("-");
		}
		System.out.println("+");

	}
}
