package Map.Places;

import java.util.*;
import Entities.LegendsEntity;
import Entities.LegendsHero;
import Entities.LegendsMonster;
import Game.LegendsOfValor;
import Items.LegendsArmour;
import Items.LegendsItem;
import Items.LegendsPotion;
import Items.LegendsSpell;
import Items.LegendsWeapon;
import Map.Tracks.Track;
import Util.Token;
import Util.Creation.ItemGenerator;

public class Market extends Place {
	public ArrayList<LegendsItem> inventory;

	public Market(Track track, int row, int col, Token marketToken) {
		super(track, row, col, true, marketToken);
		inventory = ItemGenerator.generateItems(10);
	}

	public void activatePlace(LegendsEntity e, LegendsOfValor game) {
		if (e instanceof LegendsMonster) {
			this.addMonsterOnCell(((LegendsMonster) e));
			// Optional discourse for monsters
		} else {
			this.addHeroOnCell(((LegendsHero) e));
			System.out.println("Your hero " + e.getName() + " stumbles past the town market!");
			System.out.println("Would you like to enter? [Y/N]");
			while (true) {
				try {
					String input = in.nextLine();
					if (input.equalsIgnoreCase("Y")) {
						marketSequence(((LegendsHero) e), game);
						break;
					} else if (input.equalsIgnoreCase("N")) {
						break;
					} else {
						System.out.println("Please input a valid response");

					}
				} catch (Exception ex) {
					System.out.println("Please input a valid response");
				}
			}
		}
	}

	public String concatLine(int numSpaces, String toPrint) {
		String ret = "";
		for (int i = 0; i < numSpaces; i++) {
			ret += toPrint;
		}
		return ret;
	}

	public void printHelperLine() {
		System.out.println("+" + concatLine(6, "-") + "+" + concatLine(52, "-") + "+" + concatLine(6, "-") + "+"
				+ concatLine(5, "-") + "+" + concatLine(12, "-") + "+" + concatLine(9, "-") + "+" + concatLine(8, "-")
				+ "+" + concatLine(9, "-") + "+" + concatLine(12, "-") + "+" + concatLine(12, "-") + "+"
				+ concatLine(6, "-") + "+");

	}

	public void printShopInventory(ArrayList<LegendsItem> inventory) {
		String weaponsFormat = "| [%-2d] | %-50s | %-4d | %-3d | %-10s | %-6s  |  %-4d  |  %-5b  | %-10s |   %-6s   | %-4s | %n";
		String armourFormat = "| [%-2d] | %-50s | %-4d | %-3d | %-10s | %.4f  |  %-4s  |  %-5s  | %-10s |   %-6s   | %-4s | %n";
		String spellFormat = "| [%-2d] | %-50s | %-4d | %-3d | %-10s | %-6s  |  %-4d  |  %-5s  | %-10s |   %2.4f   | %-4d | %n";
		String potionFormat = "| [%-2d] | %-50s | %-4d | %-3d | %-10s | %-6s  |  %-4s  |  %-5s  | %-10s |   %2.4f   | %-4s | %n";
		String headerFormat = "| %-4s | %-50s | %-4s | %-3s | %-10s | %-6s | %-4s | %-5s | %-10s | %-6s | %-4s | %n";

		int numSpaces = 147;
		System.out.println("+" + concatLine(numSpaces, "-") + "+");
		System.out.println("|" + concatLine(numSpaces, " ") + "|");
		System.out.println(
				"|" + concatLine((numSpaces / 2) - 4, " ") + "INVENTORY " + concatLine((numSpaces / 2) - 5, " ") + "|");
		System.out.println("|" + concatLine(numSpaces, " ") + "|");
		printHelperLine();
		System.out.printf(headerFormat, "##", concatLine(23, " ") + "NAME" + concatLine(23, " "), "COST", "LVL",
				"   CLASS  ", "DEFENSE", "DAMAGE", "2 HAND?", "  ABILITY ", "MULTIPLIER", "MANA");
		printHelperLine();

		for (int i = 0; i < inventory.size(); i++) {
			LegendsItem currItem = inventory.get(i);
			if (currItem instanceof LegendsWeapon) {
				System.out.printf(weaponsFormat, i, currItem.getName(), currItem.getCost(), currItem.getMinLevel(),
						"WEAPON", "", ((LegendsWeapon) currItem).getDamage(),
						((LegendsWeapon) currItem).getDualHanded(), "", "", "");
			} else if (currItem instanceof LegendsArmour) {
				System.out.printf(armourFormat, i, currItem.getName(), currItem.getCost(), currItem.getMinLevel(),
						"ARMOR", ((LegendsArmour) currItem).getDefenseMultiplier(), "", "", "", "", "");
			} else if (currItem instanceof LegendsSpell) {
				System.out.printf(spellFormat, i, currItem.getName(), currItem.getCost(), currItem.getMinLevel(),
						"SPELL", "", ((LegendsSpell) currItem).getMaxDamage(), "",
						((LegendsSpell) currItem).getTargetAbility(), ((LegendsSpell) currItem).getMultiplier(),
						((LegendsSpell) currItem).getManaRequired());
			} else if (currItem instanceof LegendsPotion) {
				System.out.printf(potionFormat, i, currItem.getName(), currItem.getCost(), currItem.getMinLevel(),
						"POTION", "", "", "", ((LegendsPotion) currItem).getTargetAbility(),
						((LegendsPotion) currItem).getMultiplier(), "");
			}
			printHelperLine();
		}
	}

	public void marketSequence(LegendsHero h, LegendsOfValor game) {
		if (inventory.size() == 0)
			inventory = ItemGenerator.generateItems(10);

		System.out.println();
		System.out.println("Welcome to the shop!");
		while (true) {
			System.out.println("Please choose one of the following actions:");
			printActions();
			try {
				String input = in.nextLine();
				if (input.equalsIgnoreCase("1")) {
					shopSequence(h);
					in.nextLine();
				} else if (input.equalsIgnoreCase("2")) {
					sellSequence(h);
					in.nextLine();
				} else if (input.equalsIgnoreCase("i")) {
					showInfo(h);
				} else if (input.equalsIgnoreCase("q")) {
					game.quit();
					break;
				} else if (input.equalsIgnoreCase("0")) {
					break;
				} else {
					System.out.println("Please input a valid action here.");
				}
				
			} catch (Exception e) {
				System.out.println("Please input a valid response there" + e);
			}
		}

	}

	private void sellSequence(LegendsHero h) {
		System.out.println("Ooo, whatcha got?!?!");

		while (true) {
			System.out.println("Please pick what you'd like to buy! [Or enter -1 to leave]");

			printShopInventory(h.getInventory().getRawInventory());

			int itemChoice = in.nextInt();

			if (itemChoice == -1)
				break;
			else if (itemChoice >= 0 && itemChoice < h.getInventory().getRawInventory().size()) {
				attemptSellItem(h.getInventory().getRawInventory().remove(itemChoice), h);
				break;
			} else
				System.out.println("Invalid choice! Attempting again!");
		}
		System.out.println("Thanks for shopping!");
		System.out.println();

	}

	private void attemptSellItem(LegendsItem item, LegendsHero h) {
		System.out.println("Thank you for your business!");
		if (item instanceof LegendsArmour) {
			((LegendsArmour) item).regenDurability(1);
		} else if (item instanceof LegendsWeapon) {
			((LegendsWeapon) item).regenDurability(1);
		}

		System.out.println("You have sold " + item.getName());
		System.out.println();

		inventory.add(item);
	}

	public void shopSequence(LegendsHero h) {
		System.out.println("Who doesn't love shopping!");
		int choice;

		while (true) {
			System.out.println("Please pick what you'd like to buy! [Or enter -1 to leave]");

			printShopInventory(inventory);
			choice = in.nextInt();

			if (choice == -1)
				break;
			else if (choice >= 0 && choice < this.inventory.size()) {
				attemptPurchaseItem(this.inventory.remove(choice), h);
				break;
			} else
				System.out.println("Invalid choice! Attempting again!");
		}
		System.out.println("Thanks for shopping!");
		System.out.println();
	}

	private void attemptPurchaseItem(LegendsItem item, LegendsHero h) {
		if (h.getInventory().getBalance() < item.getCost()) {
			System.out.println("You do not have enough funds!");
			this.inventory.add(item);
			return;
		}

		if (h.getEntityStats().getLevel() < item.getMinLevel()) {
			System.out.println("You are not high enough of a level!");
			this.inventory.add(item);
			return;
		}

		System.out.println("You have purchased " + item.getName());
		System.out.println();

		if (item instanceof LegendsSpell) {
			h.getInventory().learnSpell((LegendsSpell) item);
		} else {
			h.getInventory().addItem(item);
		}
	}

	private void showInfo(LegendsHero h) {
		// TODO show info
	}

	public void printActions() {
		String leftAlignFormat = "| %-15s | %-4s |%n";

		System.out.format("+------------------------+%n");
		System.out.format("|         ACTIONS        |%n");
		System.out.format("+-----------------+------+%n");
		System.out.format(leftAlignFormat, "SHOP", "1");
		System.out.format(leftAlignFormat, "SELL", "2");
		System.out.format(leftAlignFormat, "LEAVE", "0");
		System.out.format("+-----------------+------+%n");

	}
}