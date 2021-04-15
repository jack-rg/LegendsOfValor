package Entities;

import Entities.Classes.LegendsEntityClass;
import Entities.Classes.LegendsMonsterClass;
import Entities.Util.LegendsEntityStats;
import Entities.Util.Monster.LegendsMonsterStats;

public class LegendsMonster extends LegendsEntity {

	private LegendsMonsterStats stats;
	private LegendsMonsterClass monsterClass;

	public LegendsMonster(int ID, String name, LegendsMonsterStats stats, LegendsMonsterClass monsterClass) {
		super(ID, name);
		this.stats = stats;
		this.monsterClass = monsterClass;
	}

	public void levelUp() {
		this.stats.levelUp(this.monsterClass);
		
		System.out.println(this.getName() + " has leveled up to level " + this.stats.getLevel() + "!");
	}
	
	@Override
	public LegendsEntityClass getEntityClass() {
		return monsterClass;
	}

	@Override
	public void setEntityClass(LegendsEntityClass eClass) {
		if (!(eClass instanceof LegendsMonsterClass)) {
			System.out.println("Invalid Entity Class Type!");
			return;
		}

		this.monsterClass = (LegendsMonsterClass) eClass;
	}

	@Override
	public LegendsEntityStats getEntityStats() {
		return this.stats;
	}

	@Override
	public void setLegendsEntityStats(LegendsEntityStats eStats) {
		if (!(eStats instanceof LegendsMonsterStats)) {
			System.out.println("Invalid Entity Stats Type!");
			return;
		}

		this.stats = (LegendsMonsterStats) eStats;
	}

}
