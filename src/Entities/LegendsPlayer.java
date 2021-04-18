package Entities;

import java.util.Scanner;

import Entities.Util.Player.LegendsPlayerHeroTeam;
import Util.Player;

public class LegendsPlayer extends Player {
	public static Scanner in = new Scanner(System.in);
	private LegendsPlayerHeroTeam team;

	public LegendsPlayer(int ID) {
		super(ID);
		team = new LegendsPlayerHeroTeam();
	}
	
	public LegendsPlayer(int ID, String name) {
		super(ID, name);
		team = new LegendsPlayerHeroTeam();
	}

	public void addHero(LegendsHero hero) {
		this.team.addHero(hero);
	}

	public void printTeam() {
		System.out.format("+------------------------+%n");
		System.out.format("|        Your Team       |%n");
		System.out.format("+------------------------+%n");
		int i = 0;
		for (LegendsHero h : team) {
			System.out.format("%3d: " + h + "%n", i);
			i++;
		}
	}

	public void printTeamNames() {
		System.out.format("+------------------------+%n");
		System.out.format("|        Your Team       |%n");
		System.out.format("+------------------------+%n");
		int i = 0;
		for (LegendsHero h : team) {
			System.out.format("%3d: " + h.getName() + "%n", i);
			i++;
		}
	}
	
	public LegendsPlayerHeroTeam getTeam() {
		return team;
	}
}
