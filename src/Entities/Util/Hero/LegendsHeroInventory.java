package Entities.Util.Hero;

import java.util.ArrayList;

import Items.LegendsItem;
import Items.LegendsSpell;
import Items.LegendsWeapon;

public class LegendsHeroInventory {

	private LegendsWeapon equippedWeapon;
	private LegendsHeroArmour equippedArmour;

	private ArrayList<LegendsSpell> knownSpells;

	private int balance;

	private ArrayList<LegendsItem> items;

	public LegendsHeroInventory() {
		this.equippedArmour = null;
		this.equippedArmour = new LegendsHeroArmour();

		this.knownSpells = new ArrayList<LegendsSpell>();

		this.balance = 100;

		this.items = new ArrayList<LegendsItem>();
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

	public ArrayList<LegendsItem> getRawInventory() {
		return this.items;
	}

	public void printInventory() {
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
		System.out.format(this.equippedWeapon + "%n");
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
		printItems(this.items);
	}

	private void printItems(ArrayList<?> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(i + ": " + list.get(i));
		}
	}
}
