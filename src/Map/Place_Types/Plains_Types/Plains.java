package Map.Place_Types.Plains_Types;

//Common Tile Place in an RPG
import java.util.*;

import Entities.LegendsHero;
import Entities.LegendsMonster;
import Game.LegendsOfValor;
import Map.Place_Types.Place;
import Util.Token;

public class Plains extends Place {

	public Plains(int row, int col, Token plainToken) {
		super(row, col, true, plainToken);
	}

	public void activatePlace(LegendsOfValor game) {
		game.getMap().updateBoard(this.getRowID(), this.getColID());
		System.out.println("Your party sets out along the road!");
		if (dangerCheck()) {
			fightSequence(game);
		}
	}

	public boolean dangerCheck() {
		double rng = Math.random() * 10;
		return rng < 3;
	}

	public void fightSequence(LegendsOfValor game) {
		System.out.println("Oh no! A Monster Ambush!");
		ArrayList<LegendsMonster> monsters = generateMonsters();
		ArrayList<LegendsHero> availableHeros = game.player.getTeam();
		while (isFighting(monsters, availableHeros)) {
			// heroFight();
			// monsterFight();
		}
	}

	public ArrayList<LegendsMonster> generateMonsters() {
		ArrayList<LegendsMonster> monsters = new ArrayList<LegendsMonster>();
		return monsters;
	}

	public boolean isFighting(ArrayList<LegendsMonster> monsters, ArrayList<LegendsHero> availableHeros) {
		boolean flagMonster = false;
		boolean flagHero = false;
		for (LegendsMonster m : monsters) {
			if (m.isAlive()) {
				flagMonster = true;
			}
		}
		for (LegendsHero h : availableHeros) {
			if (h.isAlive()) {
				flagHero = true;
			}
		}
		return flagHero && flagMonster;
	}
}