package Entities.Util.Hero;

import java.util.ArrayList;
import java.util.Arrays;

import Items.LegendsArmour;

public class LegendsHeroArmour {

	private LegendsArmour headPiece;
	private LegendsArmour chestPiece;
	private LegendsArmour legPiece;
	private LegendsArmour feetPiece;

	/* =================== */
	/* Constructor Methods */
	/* =================== */

	public LegendsHeroArmour() {
		this.resetSlots();
	}

	/* ============ */
	/* Game Methods */
	/* ============ */

	/*
	 * This take damage method is special, since the equipped armour takes damage as
	 * a while, but the damage is split between each in regards to a specific
	 * percentage, it also deals with pieces breaking
	 */
	public void takeDamage(int damage) {
		int damageToHead = (int) Math.round(damage * 0.2);
		int damageToChest = (int) Math.round(damage * 0.4);
		int damageToLegs = (int) Math.round(damage * 0.3);
		int damageToFeet = (int) Math.round(damage * 0.1);

		if (this.getHeadPiece() != null) {
			boolean brokeHeadPiece = this.getHeadPiece().loseDurability(damageToHead);
			if (brokeHeadPiece) {
				System.out.println("You just broke your " + this.getHeadPiece());
				this.removeHeadPiece();
			}
		}

		if (this.getChestPiece() != null) {
			boolean brokeChestPiece = this.getChestPiece().loseDurability(damageToChest);
			if (brokeChestPiece) {
				System.out.println("You just broke your " + this.getHeadPiece());
				this.removeChestPiece();
			}
		}

		if (this.getLegPiece() != null) {
			boolean brokeLegPiece = this.getLegPiece().loseDurability(damageToLegs);
			if (brokeLegPiece) {
				System.out.println("You just broke your " + this.getHeadPiece());
				this.removeLegPiece();
			}
		}

		if (this.getFeetPiece() != null) {
			boolean brokeFeetPiece = this.getFeetPiece().loseDurability(damageToFeet);
			if (brokeFeetPiece) {
				System.out.println("You just broke your " + this.getHeadPiece());
				this.removeFeetPiece();
			}
		}

	}

	/* ===================== */
	/* Getter/Setter Methods */
	/* ===================== */

	public void resetSlots() {
		this.headPiece = null;
		this.chestPiece = null;
		this.legPiece = null;
		this.feetPiece = null;
	}

	public void removeHeadPiece() {
		this.headPiece = null;
	}

	public void removeChestPiece() {
		this.chestPiece = null;
	}

	public void removeLegPiece() {
		this.legPiece = null;
	}

	public void removeFeetPiece() {
		this.feetPiece = null;
	}

	public LegendsArmour getHeadPiece() {
		return this.headPiece;
	}

	public LegendsArmour getChestPiece() {
		return this.chestPiece;
	}

	public LegendsArmour getLegPiece() {
		return this.legPiece;
	}

	public LegendsArmour getFeetPiece() {
		return this.feetPiece;
	}

	public ArrayList<LegendsArmour> getArmour() {
		return new ArrayList<LegendsArmour>(
				Arrays.asList(new LegendsArmour[] { this.headPiece, this.chestPiece, this.legPiece, this.feetPiece }));
	}

	public void setHeadPiece(LegendsArmour newPiece) {
		if (!newPiece.getSlot().equals("Head")) {
			System.out.println("Invalid Armour Type Provided!");
			return;
		}

		this.headPiece = newPiece;
	}

	public void setChestPiece(LegendsArmour newPiece) {
		if (!newPiece.getSlot().equals("Chest")) {
			System.out.println("Invalid Armour Type Provided!");
			return;
		}

		this.chestPiece = newPiece;
	}

	public void setLegPiece(LegendsArmour newPiece) {
		if (!newPiece.getSlot().equals("Legs")) {
			System.out.println("Invalid Armour Type Provided!");
			return;
		}

		this.legPiece = newPiece;
	}

	public void setFeetPiece(LegendsArmour newPiece) {
		if (!newPiece.getSlot().equals("Feet")) {
			System.out.println("Invalid Armour Type Provided!");
			return;
		}

		this.feetPiece = newPiece;
	}
}
