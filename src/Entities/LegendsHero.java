package Entities;

import java.util.Scanner;

import Entities.Classes.LegendsEntityClass;
import Entities.Classes.LegendsHeroClass;
import Entities.Util.LegendsEntityStats;
import Entities.Util.Hero.LegendsHeroInventory;
import Entities.Util.Hero.LegendsHeroStats;
import Game.LegendsOfValor;
import Map.Places.Place;
import Map.Places.Plains.Plains;
import Map.Tracks.Lane;

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
	public void updatePosition(int x, int y, LegendsOfValor game) {
		int z = 0;
		if (y == 0)
			z = 1;

		Place toMoveTo = this.getCurrPlace().getCurrTrack().getPlace(x, y);
		Place sideCell = this.getCurrPlace().getCurrTrack().getPlace(x, z);

		if (toMoveTo != null && toMoveTo.isAccessible()) {
			if ((toMoveTo.getMonstersOnCell().size() > 0) && (toMoveTo instanceof Plains)) {
				// Do Stuff
				this.getCurrPlace().removeHeroOnCell(this);
				this.setCurrPlace(toMoveTo);
				this.getCurrPlace().addHeroOnCell(this);
				this.getCurrPlace().activatePlace(this, game);
			} else if ((sideCell.getMonstersOnCell().size() > 0) && (sideCell instanceof Plains)) {
				// Do Stuff
				this.getCurrPlace().removeHeroOnCell(this);
				this.setCurrPlace(sideCell);
				this.getCurrPlace().addHeroOnCell(this);
				this.getCurrPlace().activatePlace(this, game);
			} else if ((toMoveTo.getMonstersOnCell().size() == 0) && (sideCell.getMonstersOnCell().size() == 0)) {
				// Do Stuff
				this.getCurrPlace().removeHeroOnCell(this);
				this.setCurrPlace(toMoveTo);
				this.getCurrPlace().addHeroOnCell(this);
				this.getCurrPlace().activatePlace(this, game);
			} else {
				System.out.println("You can't reach this location! Try moving elsewhere.");
			}
		} else {
			System.out.println("You can't reach this location! Try moving elsewhere.");
		}
	}

	@Override
	public void resetPosition() {
		this.getCurrPlace().removeHeroOnCell(this);
		this.setCurrPlace(this.getSpawnPlace());
		this.getCurrPlace().addHeroOnCell(this);
	}

	@Override
	public void respawn() {
		this.setCurrPlace(this.getSpawnPlace());
		this.stats.regenHealth(1);
		this.stats.regenMana(1);
		this.getCurrPlace().addHeroOnCell(this);
	}

	@Override
	public LegendsEntityClass getEntityClass() {
		return this.heroClass;
	}

	public void teleport(LegendsOfValor game) {

		int[] coords = this.tpCoord(game);
		if (coords == null)
			return;

		Place toTPTo = game.getMap().getPlace(coords[0], coords[1], coords[2]);

		if (toTPTo.getCurrTrack() instanceof Lane && toTPTo instanceof Plains) {
			Place[][] rawPlaces = ((Lane) toTPTo.getCurrTrack()).getRawPlaces();
			int minRow = -1;
			for (int i = rawPlaces.length - 1; i > -1; i--) {
				if (rawPlaces[i][0].getMonstersOnCell().size() > 0 || rawPlaces[i][1].getMonstersOnCell().size() > 0) {
					minRow = i;
					break;
				}
			}
			System.out.println(minRow);
			if (minRow > coords[1]) {
				System.out.println("You can't reach this location! Try moving elsewhere.");
			} else if (minRow == coords[1]) {
				if ((rawPlaces[minRow][0].getMonstersOnCell().size() > 0)) {
					this.getCurrPlace().removeHeroOnCell(this);
					this.setCurrPlace(rawPlaces[minRow][0]);
					this.getCurrPlace().addHeroOnCell(this);
					this.getCurrPlace().activatePlace(this, game);
				} else if ((rawPlaces[minRow][1].getMonstersOnCell().size() > 0)) {
					this.getCurrPlace().removeHeroOnCell(this);
					this.setCurrPlace(rawPlaces[minRow][1]);
					this.getCurrPlace().addHeroOnCell(this);
					this.getCurrPlace().activatePlace(this, game);
				} else {
					System.out.println("You can't reach this location! Try moving elsewhere.");
				}
			} else {
				this.getCurrPlace().removeHeroOnCell(this);
				this.setCurrPlace(toTPTo);
				this.getCurrPlace().addHeroOnCell(this);
				this.getCurrPlace().activatePlace(this, game);
			}
		} else {
			System.out.println("You can't reach this location! Try moving elsewhere.");
		}

	}

	private int[] tpCoord(LegendsOfValor game) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		boolean leave = false;

		String laneResponse = "";
		int laneRow = 0;
		int laneCol = 0;

		boolean contOne = true;
		while (contOne) {
			System.out.println("Please enter the Lane you'd like to teleport to? ['Top'/'Mid'/'Bot'/'Leave']");
			laneResponse = in.nextLine();

			switch (laneResponse) {
			case "Top":
			case "Mid":
			case "Bot":
				contOne = false;
				break;
			case "Leave":
				contOne = false;
				leave = true;
				break;
			default:
				System.out.println("Invalid response! Trying again!");
			}
		}
		int numLane = 0;
		if (laneResponse.equals("Mid"))
			numLane = 2;
		else if (laneResponse.equals("Bot"))
			numLane = 4;

		if (leave)
			return null;

		boolean contTwo = true;
		while (contTwo) {
			System.out.println("Please enter the Row # you'd like to teleport to? [Or -1 to leave]");

			laneRow = in.nextInt();

			if (laneRow == -1) {
				leave = true;
				contTwo = false;
			} else if (laneRow >= 0 && laneRow < game.getMap().getMapDimen()) {
				contTwo = false;
			} else
				System.out.println("Invalid input! Trying again!");
		}

		if (leave)
			return null;

		boolean contThree = true;
		while (contThree) {
			System.out.println("Please enter the Col # you'd like to teleport to? [Or -1 to leave]");

			laneCol = in.nextInt();

			if (laneCol == -1) {
				leave = true;
				contThree = false;
			} else if ((game.getMap().getRawTracks()[numLane] instanceof Lane) && (laneCol >= 0 && laneCol < 2)) {
				contThree = false;
			} else if ((game.getMap().getRawTracks()[numLane] instanceof Lane) && (laneCol >= 0 && laneCol < 1)) {
				contThree = false;
			} else
				System.out.println("Invalid input! Trying again!");
		}

		if (leave)
			return null;

		return new int[] { numLane, laneRow, laneCol };
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
		return String.format("| %-50s | %-5d | %-5d | %-7d | %-7d | %-5d | %-7d | %-7d | %-7d  | %n", getName(),
				stats.getLevel(), stats.getCurrHP(), stats.getCurrMana(), inventory.getBalance(), stats.getEXP(),
				stats.getDexterity(), stats.getAgility(), stats.getStrength());
	}

}
