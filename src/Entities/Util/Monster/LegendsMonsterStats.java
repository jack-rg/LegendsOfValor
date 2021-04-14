package Entities.Util.Monster;

import Entities.Util.LegendsEntityStats;

public class LegendsMonsterStats extends LegendsEntityStats {
	private int defense;
	private int strength;
	private double dodge;

	public LegendsMonsterStats(int exp, int level, int maxHP, int defense, int strength, double dodge) {
		super(exp, level, maxHP);
		this.defense = defense;
		this.strength = strength;
		this.dodge = dodge;
	}

	public int getDefense() {
		return defense;
	}

	public int getStrength() {
		return strength;
	}

	public double getDodge() {
		return dodge;
	}

	@Override
	public void resetStats() {
		super.resetStats();
		this.defense = 0;
		this.dodge = 0;
		this.strength = 0;
	}
}
