package Entities.Util.Hero;

import java.util.ArrayList;
import java.util.Scanner;

import Items.LegendsArmour;
import Items.LegendsItem;
import Items.LegendsSpell;
import Items.LegendsWeapon;
import Util.Inventory;

public class LegendsHeroInventory extends Inventory {

	private LegendsWeapon equippedWeapon;
	private LegendsHeroArmour equippedArmour;

	private ArrayList<LegendsSpell> knownSpells;

	private int balance;

	private ArrayList<LegendsItem> items;

	public LegendsHeroInventory() {
		this.equippedArmour = null;
		this.equippedArmour = new LegendsHeroArmour();

		this.knownSpells = new ArrayList<LegendsSpell>();

		this.balance = 100000;

	}
	
	public void learnSpell(LegendsSpell spell) {
		this.knownSpells.add(spell);
	}
	
	public void spendMoney(int toSpend) {
		this.balance -= toSpend;
	}
	
	public void gainMoney(int toGain) {
		this.balance += toGain;
	}
	
	public int getBalance() {
		return this.balance;
	}

	public LegendsWeapon getEquippedWeapon() {
		return this.equippedWeapon;
	}

	public LegendsHeroArmour getEquippedArmour() {
		return this.equippedArmour;
	}

	public ArrayList<LegendsSpell> getKnownSpells() {
		return this.knownSpells;
	}
	
	public void replaceEquippedWeapon(LegendsWeapon weapon) {
		if (equippedWeapon != null && equippedWeapon.getCurrentDurability() > 0)
			items.add(equippedWeapon);
		
		equippedWeapon = weapon;
	}
	
	public void switchArmour(LegendsArmour armour) {
		if (armour.getSlot().equals("Head")) {
			LegendsArmour toSwitch = this.getEquippedArmour().getHeadPiece();
			if (toSwitch != null)
				this.items.add(toSwitch);
			
			this.equippedArmour.setHeadPiece(armour);
		} else if (armour.getSlot().equals("Chest")) {
			LegendsArmour toSwitch = this.getEquippedArmour().getChestPiece();
			if (toSwitch != null)
				this.items.add(toSwitch);
			
			this.equippedArmour.setChestPiece(armour);
		} else if (armour.getSlot().equals("Legs")) {
			LegendsArmour toSwitch = this.getEquippedArmour().getLegPiece();
			if (toSwitch != null)
				this.items.add(toSwitch);
			
			this.equippedArmour.setLegPiece(armour);
		} else if (armour.getSlot().equals("Feet")) {
			LegendsArmour toSwitch = this.getEquippedArmour().getFeetPiece();
			if (toSwitch != null)
				this.items.add(toSwitch);
			
			this.equippedArmour.setFeetPiece(armour);
		} else {
			System.out.println("Invalid armour slot! Cannot Equip!");
		}
		
	}
	
	public LegendsItem accessInventory() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		
		while (true) {
			System.out.println("What would you like to do?");
			System.out.println("[1] View Inventory");
			System.out.println("[2] Use Item");
			System.out.println("[3] Exit");
			
			choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				printHeroInventory();
				break;
			case 2:
				return this.useItem();
			case 3:
				return null;
			default:
				System.out.println("Invalid input! Trying again!");
			}
		}
	}
	
	public LegendsItem useItem() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		
		while (true) {
			System.out.println("Please pick an item!");
			System.out.println();
			
			this.printGeneralItems();
			choice = scanner.nextInt();
			
			if (choice >= 0 && choice < this.size()) {
				return this.remove(choice);
			}
			
			System.out.println("Invalid selection! Trying again!");
		}
	}
	
	public LegendsSpell pickSpell() {
		if (this.knownSpells.size() == 0) {
			System.out.println("You know no spells!");
			return null;
		}
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		
		while (true) {
			System.out.println("Please pick a spell!");
			System.out.println();
			
			this.printKnownSpells();;
			choice = scanner.nextInt();
			
			if (choice >= 0 && choice < this.knownSpells.size()) {
				return this.knownSpells.get(choice);
			}
			
			System.out.println("Invalid selection! Trying again!");
		}
	}

	public void printHeroInventory() {
		System.out.format("+------------------------+%n");
		System.out.format("|        INVENTORY       |%n");
		System.out.format("+------------------------+%n");
		printBalance();
		printEquipped();
		printKnownSpells();
		printGeneralItems();
	}

	private void printBalance() {
		System.out.format("Current Balance: " + this.balance + "%n");
	}


	private void printEquipped() {
		System.out.format("+-------------------------------+%n");
		System.out.format("|          Equipped Gear        |%n");
		System.out.format("+-------------------------------+%n");
		System.out.format("Equipped Armour:%n");
		System.out.format(this.equippedArmour + "%n");
		System.out.format("%n");
		System.out.format("Equipped Weapon:%n");
		if(this.equippedWeapon != null){
		   System.out.format(this.equippedWeapon + "%n");
		}
		else{
		   System.out.format("No weapon equipped.%n");
		}
	}
	private void printKnownSpells() {
		System.out.format("+------------------------+%n");
		System.out.format("|          SPELLS        |%n");
		System.out.format("+------------------------+%n");
		printItems(this.knownSpells);
	}

	private void printGeneralItems() {
		System.out.format("+-------------------------------+%n");
		System.out.format("|          General Items        |%n");
		System.out.format("+-------------------------------+%n");
		printItems(this.getRawInventory());
	}

	private void printItems(ArrayList<?> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(i + ": " + list.get(i));
		}
	}

}
