package Entities;

import java.util.ArrayList;
import java.util.Scanner;

import Util.Player;
import Util.Token;

public class LegendsPlayer extends Player {
	public static Scanner in = new Scanner(System.in);
	public ArrayList<Hero> team;
	private Token token;

	public LegendsPlayer(int ID, String name, Token token) {
		super(ID, name);
		this.token = token;
		team = new ArrayList<Hero>();
	}

	public void addToTeam(Hero hero) {
		team.add(hero);
	}

	public ArrayList<Hero> getTeam() {
		return team;
	}

	public void printTeam() {
		System.out.format("+------------------------+%n");
		System.out.format("|        Your Team       |%n");
		System.out.format("+------------------------+%n");
		int i = 0;
		for (Hero h : team) {
			System.out.format("%3d: " + h + "%n", i);
			i++;
		}
	}

	public void printTeamNames() {
		System.out.format("+------------------------+%n");
		System.out.format("|        Your Team       |%n");
		System.out.format("+------------------------+%n");
		int i = 0;
		for (Hero h : team) {
			System.out.format("%3d: " + h.getName() + "%n", i);
			i++;
		}
	}
}
