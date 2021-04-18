package Map.Places;

import Entities.LegendsEntity;
import Entities.LegendsHero;
import Entities.LegendsMonster;
import Game.LegendsOfValor;
import Items.LegendsArmour;
import Items.LegendsItem;
import Items.LegendsSpell;
import Items.LegendsWeapon;
import Map.Tracks.Track;
import Util.Inventory;
import Util.Token;

public class Market extends Place {
	public Inventory inventory;

	public Market(Track track, int row, int col, Token marketToken) {
		super(track, row, col, true, marketToken);
		inventory = new Inventory(10);
	}

	public void activatePlace(LegendsEntity e, LegendsOfValor game) {
		if (e instanceof LegendsMonster) {
			// Optional discourse for monsters
		} else {
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

	

	public void marketSequence(LegendsHero h, LegendsOfValor game) {
		if (inventory.isEmpty())
			inventory = new Inventory(10);

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
					showInfo();
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

			h.getInventory().printInventory();

			int itemChoice = in.nextInt();

			if (itemChoice == -1)
				break;
			else if (itemChoice >= 0 && itemChoice < h.getInventory().size()) {
				attemptSellItem(h.getInventory().remove(itemChoice), h);
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

		h.getInventory().remove(item);
	}

	public void shopSequence(LegendsHero h) {
		System.out.println("Who doesn't love shopping!");
		int choice;

		while (true) {
			System.out.println("Please pick what you'd like to buy! [Or enter -1 to leave]");

			inventory.printInventory();
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
			h.getInventory().add(item);
		}
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

	@Override
	public void showInfo() {
		System.out.format("+------------------------+%n");
		System.out.format("|        HERO INFO       |%n");
		System.out.format("+------------------------+%n");
		LegendsOfValor.helperLine(127);
		System.out.printf(
				"|                        NAME                        | LEVEL |  HP   |  MANA   |  COINS  |  EXP  |   DEX   | AGILITY | STRENGTH | %n");
		LegendsOfValor.helperLine(127);
		for (LegendsHero h : getHeroesOnCell()) {
			System.out.print(h);
			LegendsOfValor.helperLine(127);
		}

		
	}
}