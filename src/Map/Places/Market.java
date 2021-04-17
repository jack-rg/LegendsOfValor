package Map.Places;

import java.io.File;
import java.util.*;

import Entities.LegendsEntity;
import Entities.LegendsHero;
import Entities.LegendsMonster;
import Entities.Util.Hero.LegendsHeroInventory;
import Game.LegendsOfValor;
import Items.LegendsArmour;
import Items.LegendsItem;
import Items.LegendsPotion;
import Items.LegendsSpell;
import Items.LegendsWeapon;
import Util.Token;
import Util.Creation.ItemGenerator;

public class Market extends Place {
	public ArrayList<LegendsItem> inventory;

	public Market(int row, int col, Token marketToken) {
		super(row, col, true, marketToken);
		inventory = ItemGenerator.generateItems(10);
	}

	public void activatePlace(LegendsEntity e, LegendsOfValor game) {
		if (e instanceof LegendsMonster) {
			//Optional discourse for monsters
		} else {
			game.getMap().updateBoard(this.getRowID(), this.getColID());
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
					in.nextLine();
				}
			}
		}
	}

	public void marketSequence(LegendsHero h, LegendsOfValor game) {
		if (inventory.size() == 0)
			inventory = ItemGenerator.generateItems(10);
		
		System.out.println("Welcome to the shop!");
		while (true) {
			System.out.println("Please choose one of the following actions:");
			printActions();
			try {
				String input = in.nextLine();
				if (input.equalsIgnoreCase("1")) {
					shopSequence(h);
				} else if (input.equalsIgnoreCase("2")) {
					sellSequence(h);
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
				System.out.println("Please input a valid response there");
				in.nextLine();
			}
		}

	}

	private void sellSequence(LegendsHero h) {
		System.out.println("Ooo, whatcha got?!?!");
		int choice;
		
		while (true) {
			System.out.println("Please pick what you'd like to buy! [Or enter -1 to leave]");
			
			for (int i = 0; i < h.getInventory().getRawInventory().size(); i++)
				System.out.println("[" + i + "] " + h.getInventory().getRawInventory().get(i));
			
			choice = in.nextInt();
			
			if (choice == -1)
				break;
			else if (choice >= 0 && choice < h.getInventory().getRawInventory().size())
				attemptSellItem(h.getInventory().getRawInventory().remove(choice), h);
			else 
				System.out.println("Invalid choice! Attempting again!");
		}
		System.out.println("Thanks for shopping!");
		
	}

	private void attemptSellItem(LegendsItem item, LegendsHero h) {
		System.out.println("Thank you for your business!");
		if (item instanceof LegendsArmour) {
			((LegendsArmour) item).regenDurability(1);
		} else if (item instanceof LegendsWeapon) {
			((LegendsWeapon) item).regenDurability(1);
		}
		
		inventory.add(item);
	}

	public void shopSequence(LegendsHero h) {
		System.out.println("Who doesn't love shopping!");
		int choice;
		
		while (true) {
			System.out.println("Please pick what you'd like to buy! [Or enter -1 to leave]");
			
			for (int i = 0; i < inventory.size(); i++)
				System.out.println("[" + i + "] " + inventory.get(i));
			
			choice = in.nextInt();
			
			if (choice == -1)
				break;
			else if (choice >= 0 && choice < this.inventory.size())
				attemptPurchaseItem(this.inventory.remove(choice), h);
			else 
				System.out.println("Invalid choice! Attempting again!");
		}
		System.out.println("Thanks for shopping!");
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
		
		if (item instanceof LegendsSpell) {
			h.getInventory().learnSpell((LegendsSpell) item);
		} else {
			h.getInventory().addItem(item);
		}
	}


	private void showInfo(LegendsHero h) {
		//TODO show info
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