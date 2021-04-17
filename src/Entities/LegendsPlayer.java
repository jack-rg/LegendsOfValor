package Entities;

import java.util.Scanner;

import Entities.Util.Player.LegendsPlayerHeroTeam;
import Game.LegendsHero;
import Game.Util.LegendsGamePlayerHeroes;
import Game.Util.LegendsPlayerGameStats;
import Util.Player;
import Util.Token;

public class LegendsPlayer extends Player {
	public static Scanner in = new Scanner(System.in);
	private LegendsPlayerHeroTeam team;
	private Token token;

	public LegendsPlayer(int ID, Token token) {
		super(ID);
		this.setToken(token);
		team = new LegendsPlayerHeroTeam();
	}
	
	public LegendsPlayer(int ID, String name, Token token) {
		super(ID, name);
		this.setToken(token);
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

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}
}
