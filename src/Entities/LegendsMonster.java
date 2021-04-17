package Entities;

import Entities.Classes.LegendsEntityClass;
import Entities.Classes.LegendsMonsterClass;
import Entities.Util.LegendsEntityStats;
import Entities.Util.Monster.LegendsMonsterStats;
import Game.LegendsOfValor;
import Map.Places.Place;
import Map.Places.Plains.Plains;

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
	public void resetPosition() {
		this.getCurrPlace().removeMonsterOnCell(this);
		this.setCurrPlace(this.getSpawnPlace());
		this.getCurrPlace().removeMonsterOnCell(this);
	}
	
	@Override
	public void updatePosition(int x, int y, LegendsOfValor game) {
		int z = 0;
		if (y == 0)
			z = 1;
		
		Place toMoveTo = this.getCurrPlace().getCurrTrack().getPlace(x, y);
		Place sideCell = this.getCurrPlace().getCurrTrack().getPlace(x, z);
		
		if (toMoveTo != null && toMoveTo.isAccessible()) {
			if ((toMoveTo.getHeroesOnCell().size() > 0) && (toMoveTo instanceof Plains)) {
				// Do Stuff
				this.getCurrPlace().removeMonsterOnCell(this);
				this.setCurrPlace(toMoveTo);
				this.getCurrPlace().activatePlace(this, game);
			} else if ((sideCell.getHeroesOnCell().size() > 0) && (sideCell instanceof Plains)) {
				// Do Stuff
				this.getCurrPlace().removeMonsterOnCell(this);
				this.setCurrPlace(sideCell);
				this.getCurrPlace().activatePlace(this, game);
			} else if ((toMoveTo.getHeroesOnCell().size() == 0) && (sideCell.getHeroesOnCell().size() == 0)) {
				// Do Stuff
				this.getCurrPlace().removeMonsterOnCell(this);
				this.setCurrPlace(toMoveTo);
				this.getCurrPlace().activatePlace(this, game);
			} else {
				System.out.println("You can't reach this location! Try moving elsewhere.");
			}
		} else {
			System.out.println("You can't reach this location! Try moving elsewhere.");
		}
	}
	
	@Override
	public void respawn() {
		this.setCurrPlace(this.getSpawnPlace());
		this.getCurrPlace().addMonsterOnCell(this);
		this.stats.regenHealth(1);
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
