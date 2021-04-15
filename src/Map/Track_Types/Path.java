package Map.Track_Types;

import Map.Place_Types.Market;
import Map.Place_Types.Nature;
import Map.Place_Types.Place;
import Map.Place_Types.Plains_Types.Plains;
import Util.Token;

//Basic, single column track. Used in first part of the game
public class Path extends Track {

	private Place[] places;
	private Place currPlace;
	private int currRowID;
	private int currColID;
	private int length;
	private boolean isActive;

	public Path(int laneID, int length) {
		super(laneID);
		this.length = length;
		places = new Place[length];
		isActive = false;
		initPlaces();
	}

	private void initPlaces() {
		for (int r = 1; r < places.length - 1; r++) {
			Place p = generateLocation(r, 0);
			places[r] = p;
		}

		currRowID = 0;
		currColID = 0;
		currPlace = places[currRowID];
	}

	public Place generateLocation(int r, int c) {
		double rng = Math.random() * 10;
		if (rng > 5) {
			return new Plains(r, c, new Token("==="));
		} else if (rng > 2) {
			return new Market(r, c, new Token("i^i"));
		} else {
			return new Nature(r, c, new Token("XXX"));
		}
	}

	public Place getPlace(int row, int col) {
		return places[row];
	}

	public Place getCurrPlace() {
		return currPlace;
	}

	public void setCurrPlace(int row, int col) {
		currPlace = places[row];
	}

	public Place[] getRawPlaces() {
		return places;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean activity) {
		isActive = activity;
	}

	public void printTrack() {
		System.out.println("insert print pls");
	}

}
