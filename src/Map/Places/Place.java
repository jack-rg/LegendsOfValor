package Map.Places;

import java.util.ArrayList;

import Entities.LegendsEntity;
import Entities.LegendsHero;
import Entities.LegendsMonster;
import Game.LegendsOfValor;
import Map.Cell;
import Map.Tracks.Track;
import Util.Token;

//Specifies the components of a location in an RPG
public abstract class Place extends Cell {
	private ArrayList<LegendsHero> heroesOnCell;
	private ArrayList<LegendsMonster> monstersOnCell;
	public boolean accessiblity;
	public Track currTrack;

	public Place(Track track, int row, int col, boolean accessiblity, Token design) {
		super(row, col, design);
		this.accessiblity = accessiblity;
		currTrack = track;
		heroesOnCell = new ArrayList<LegendsHero>();
		monstersOnCell = new ArrayList<LegendsMonster>();
	}

	public Place(int row, int col, boolean accessiblity, Token design, Token activeDesign) {
		super(row, col, design, activeDesign);
		this.accessiblity = accessiblity;
	}

	public void addHeroOnCell(LegendsHero h) {
		heroesOnCell.add(h);
		System.out.println(heroesOnCell.size());
	}
	
	public void addMonsterOnCell(LegendsMonster m) {
		monstersOnCell.add(m);
		System.out.println(monstersOnCell.size());
	}
	
	public void removeHeroOnCell(LegendsHero h) {
		heroesOnCell.remove(h);
		System.out.println(heroesOnCell.size());
	}
	
	public void removeMonsterOnCell(LegendsMonster m) {
		monstersOnCell.remove(m);
		System.out.println(monstersOnCell.size());
	}
	
	public abstract void activatePlace(LegendsEntity e, LegendsOfValor game);

	public boolean isAccessible() {
		return accessiblity;
	}

	public void setAccessibility(boolean accessiblity) {
		this.accessiblity = accessiblity;
	}

	public void setCurrTrack(Track newTrack) {
		currTrack = newTrack;
	}

	public Track getCurrTrack() {
		return currTrack;
	}

	public ArrayList<LegendsHero> getHeroesOnCell() {
		return heroesOnCell;
	}

	public ArrayList<LegendsMonster> getMonstersOnCell() {
		return monstersOnCell;
	}

}