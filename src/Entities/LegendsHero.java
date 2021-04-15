package Entities;

import Entities.Classes.LegendsEntityClass;
import Entities.Classes.LegendsHeroClass;
import Entities.Util.LegendsEntityStats;
import Entities.Util.Hero.LegendsHeroInventory;
import Entities.Util.Hero.LegendsHeroStats;

public class LegendsHero extends LegendsEntity {

	private LegendsHeroInventory inventory;
	private LegendsHeroStats stats;
	private LegendsHeroClass heroClass;

	public LegendsHero(int ID, String name, LegendsHeroStats stats, LegendsHeroClass heroClass) {
		super(ID, name);
		inventory = new LegendsHeroInventory();
		this.stats = stats;
		this.heroClass = heroClass;
	}
	
	public void levelUp() {
		this.stats.levelUp(this.heroClass);
		
		this.inventory.gainMoney(100);
		
		System.out.println(this.getName() + " has leveled up to level " + this.stats.getLevel() + "!");
	}
	
	@Override
	public LegendsEntityClass getEntityClass() {
		return this.heroClass;
	}

	@Override
	public void setEntityClass(LegendsEntityClass eClass) {
		if (!(eClass instanceof LegendsHeroClass)) {
			System.out.println("Invalid Entity Class Type!");
			return;
		}

		this.heroClass = (LegendsHeroClass) eClass;
	}
	
	@Override
	public LegendsEntityStats getEntityStats() {
		return this.stats;
	}

	@Override
	public void setLegendsEntityStats(LegendsEntityStats eStats) {
		if (!(eStats instanceof LegendsHeroStats)) {
			System.out.println("Invalid Entity Stats Type!");
			return;
		}

		this.stats = (LegendsHeroStats) eStats;
	}
	
	public LegendsHeroInventory getInventory() {
		return this.inventory;
	}
	
	public void setInventory(LegendsHeroInventory inventory) {
		this.inventory = inventory;
	}

	public String toString() {
		return String.format("%-20s | %-5d | %-5d | %-5d | %-5d | %-5d | %-5d | %-5d | %-5d |", getName(),
				stats.getLevel(), stats.getCurrHP(), stats.getCurrMana(), inventory.getBalance(), stats.getEXP(),
				stats.getDexterity(), stats.getAgility(), stats.getStrength());
	}

}
