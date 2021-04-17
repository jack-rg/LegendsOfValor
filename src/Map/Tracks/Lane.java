package Map.Tracks;

import Map.Places.MonsterNexus;
import Map.Places.Place;
import Map.Places.PlayerNexus;
import Map.Places.Plains.Bush;
import Map.Places.Plains.Cave;
import Map.Places.Plains.Koulou;
import Map.Places.Plains.Plains;
import Util.Token;

//Class that holds a two-column track of places, starting and ending with a row of Nexuses. Monster Nexus spawn first on top of the column.
public class Lane extends Track {
	private Place[][] places;
	private int length;
	private boolean isActive;
	
	public Lane(int laneID, int length) {
		super(laneID);
		this.length = length;
		isActive = false;
		initPlaces();
	}

	private void initPlaces() {
		places = new Place[length][2];
		places[0][0] = new MonsterNexus(this, 0, 0, new Token("~M~"));
		places[0][1] = new MonsterNexus(this, 0, 1, new Token("~M~"));
		for (int r = 1; r < places.length - 1; r++) {
			for (int c = 0; c < places[r].length; c++) {
				Place p = generateLocation(r, c);
				places[r][c] = p;
			}
		}
		places[length - 1][0] = new PlayerNexus(this, length - 1, 0, new Token("~H~"));
		places[length - 1][1] = new PlayerNexus(this, length - 1, 1, new Token("~H~"));
	}

	public Place generateLocation(int r, int c) {
		double rng = Math.random() * 10;
		if (rng > 6) {
			return new Plains(this, r, c, new Token("==="), "None");
		} else if (rng > 4) {
			return new Bush(this, r, c, new Token("***"));
		} else if (rng > 2) {
			return new Koulou(this, r, c, new Token("K-K"));
		} else {
			return new Cave(this, r, c, new Token("CCC"));
		}
	}

	public Place getPlace(int row, int col) {
		if(row >= length || col >= 2){
			return null;
		}
		return places[row][col];
	}

	public Place[][] getRawPlaces() {
		return places;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean activity) {
		isActive = activity;
	}

	public int getLength() {return length;}

	public void setLength(int i) {length=i;}

	public void printTrack() {
		System.out.println("insert print pls");
	}
}