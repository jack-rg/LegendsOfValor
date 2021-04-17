package Map;

import Map.Tracks.Boundary;
import Map.Tracks.Lane;
import Map.Tracks.Track;
import Util.Map;
import Util.Token;

public class LegendsMap extends Map {
	public int totalCells;

	public Token teamToken;

	public LegendsMap(int numTracks, int length) {
		super(numTracks, length);
	}

	public void initBoard() {
		map = new Track[numTracks];
		map[0] = new Lane(0, mapDimen);
		for (int i = 1, index = 1; i < numTracks; i += 2, index++) {
			map[i] = new Boundary(-1, mapDimen);
			map[i + 1] = new Lane(index, mapDimen);
		}
	}

	public int getTotalCells() {return totalCells;}

	public void setTotalCells(int i) {totalCells=i;}

	public Token getTeamToken() {return teamToken;}

	public void setTeamToken(Token i) {teamToken=i;}

}