import java.util.*;
import java.io.*;

public class RPG extends Game {
	public Map map;
	public RPG_Player player;
	private static Scanner in = new Scanner(System.in); // player input scanner
	public EventHandler eventHandler;

	public Map getMap() {
		return map;
	}

	public void initObjects() {
		map = new Map(8, player.getToken());
		chooseCharacters();
	}

	public void initPlayers() {
		System.out.println("Welcome adventurer! What is your name?");
		String name = in.nextLine();
		player = new RPG_Player(name, new Token("\\o/"));
		initObjects();
		readLines("introduction.txt");
	}

	public void playGame() {
		processUserInput();
	}

	public void chooseCharacters() {
		ArrayList<Hero> heroSelection = new ArrayList<Hero>();
		loadCharacters(heroSelection);
		System.out.println(
				"In this game you may choose 1-3 heros to adventure with. Warriors are renowned for their strength and speed; paladins, for their speed and power; sorcerers, for their power and strength. Choose wisely... ");
		boolean flag = true;
		while (player.getTeam().size() < 3 && flag) {
			printCharacters(heroSelection);
			System.out.println("Please select a character to add to your team.");
			if (player.getTeam().size() >= 1) {
				System.out.println("Or, enter -1 to begin your quest!");
			}
			try {
				int input = in.nextInt();
				if (input == -1 && player.getTeam().size() >= 1) {
					System.out.println("Off you go!");
					flag = false;
				} else {
					Hero selection = heroSelection.remove(input);
					System.out.println("You chose " + selection.getName() + ".");
					player.addToTeam(selection);
				}
			} catch (Exception e) {
				System.out.println("Please select a valid option.");
				in.nextLine();
			}
		}
		player.printTeamNames();
		in.nextLine();
	}

	public void printCharacters(ArrayList<Hero> heroSelection) {
		System.out.format(
				"  |      HERO NAME      | LEVEL |  HP  |  MANA  | MONEY | EXP | DEXTERITY  |  AGILITY  |  STRENGTH  |%n");
		int i = 0;
		for (Hero h : heroSelection) {
			System.out.println(i + ": " + h);
			i++;
		}
	}

	public void loadCharacters(ArrayList<Hero> heroSelection) {
		initItems(new File("Additionals/Paladins.txt"), heroSelection, HeroType.PALADIN);
		initItems(new File("Additionals/Sorcerers.txt"), heroSelection, HeroType.SORCERER);
		initItems(new File("Additionals/Warriors.txt"), heroSelection, HeroType.WARRIOR);
	}

	public void initItems(File file, ArrayList<Hero> heroSelection, HeroType id) {
		try {
			List<String> lines = readLines(file);
			lines.remove(0); // remove header
			for (int i = 0; i < lines.size(); i++) {
				String[] parameters = lines.get(i).split("\\s+");
				heroSelection.add(new Hero(parameters, id));
			}
		} catch (Exception e) {
		}
	}

	public ArrayList<String> readLines(File file) {
		try {
			ArrayList<String> l = new ArrayList<String>();
			Scanner input = new Scanner(file);
			while (input.hasNextLine()) {
				l.add(input.nextLine());
			}
			input.close();
			return l;
		} catch (Exception e) {
			System.out.println("File not found");
			return null;
		}
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
		if (map.getCurrCell().getLocation() == Location.PATH) {
			System.out.format(leftAlignFormat, "check inventory", "c");
		}
		if (map.getCurrCell().getLocation() == Location.MARKET) {
			System.out.format(leftAlignFormat, "enter market", "e");
		}
		System.out.format(leftAlignFormat, "quit", "q");
		System.out.format("+-----------------+------+%n");

	}

	public void processUserInput() {
		while (true) {
			try {
				map.print();
				System.out.println("What would you like to do?");
				printActions();
				String input = in.nextLine();
				if (input.equalsIgnoreCase("w") && map.getCurrCell().getRowID() != 0) {
					map.getCell(map.getCurrCell().getRowID() - 1, map.getCurrCell().getColID()).activatePlace(this);
					break;
				} else if (input.equalsIgnoreCase("s") && map.getCurrCell().getRowID() != map.getMapDimen() - 1) {
					map.getCell(map.getCurrCell().getRowID() + 1, map.getCurrCell().getColID()).activatePlace(this);
					break;
				} else if (input.equalsIgnoreCase("a") && map.getCurrCell().getColID() != 0) {
					map.getCell(map.getCurrCell().getRowID(), map.getCurrCell().getColID() - 1).activatePlace(this);
					break;
				} else if (input.equalsIgnoreCase("d") && map.getCurrCell().getColID() != map.getMapDimen() - 1) {
					map.getCell(map.getCurrCell().getRowID(), map.getCurrCell().getColID() + 1).activatePlace(this);
					break;
				} else if (input.equalsIgnoreCase("i")) {
					showInfo();
				} else if (input.equalsIgnoreCase("m")) {
					continue;
				} else if (input.equalsIgnoreCase("e") && map.getCurrCell().getLocation() == Location.MARKET) {
					map.getCurrCell().activatePlace(this);
				} else if (input.equalsIgnoreCase("c") && map.getCurrCell().getLocation() == Location.PATH) {
					checkInventory();
				} else if (input.equalsIgnoreCase("q")) {
					quit();
					break;
				} else {
					System.out.println("This move is currently invalid. Please input a proper value");
				}
			} catch (Exception e) {
				System.out.println("Please input a correct value");
				in.nextLine();
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
		System.out.println("Inventory");
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

	}

	public void reset() {

	}

}