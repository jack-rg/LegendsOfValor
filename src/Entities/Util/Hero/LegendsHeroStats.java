package Entities.Util.Hero;

import Entities.Util.LegendsEntityStats;

public class LegendsHeroStats extends LegendsEntityStats {

	private int dexterity;
	private int strength;
	private int agility;
	
	private int mana;
	private int maxMana;

	public LegendsHeroStats(int exp, int level, int maxHP, int maxMana, int dexterity, int strength, int agility) {
		super(exp, level, maxHP);
		this.mana = maxMana;
		this.maxMana = maxMana;
		this.dexterity = dexterity;
		this.strength = strength;
		this.agility = agility;
	}
	
	public void increaseMaxMana(int toIncrease) {
		this.maxMana += toIncrease;
	}
	
	public void regenMana(double toRegen) {
		this.mana = Math.min(this.maxMana, ((int) Math.round(this.maxMana * toRegen)) + this.mana);
	}
	
	public boolean spendMana(int toSpend) {
		if (this.mana - toSpend < 0)
			return false;
		
		this.mana -= toSpend;
		
		return true;
	}

	public int getCurrMana() {
		return this.mana;
	}
	
	public int getMaxMana() {
		return this.maxMana;
	}
	
	public int getDexterity() {
		return dexterity;
	}

	public int getStrength() {
		return strength;
	}

	public int getAgility() {
		return agility;
	}

	@Override
	public void resetStats() {
		super.resetStats();
		this.dexterity = 0;
		this.agility = 0;
		this.strength = 0;
	}

}
