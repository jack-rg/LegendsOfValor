package Map;

import Map.Places.Place;
import Map.Tracks.Boundary;
import Map.Tracks.Lane;
import Map.Tracks.Track;
import Util.Map;
import Util.Token;

public class ValorMap extends Map {
	public int mapDimen;
	public int numTracks;
	public int totalCells;

	public Track[] map;
	public Token teamToken;

	public Place currCell;
	public Track currTrack;
	public int currRow;
	public int currCol;

	public ValorMap(int numTracks, int length) {
		super(numTracks, length);
	}

	@Override
	public void initBoard() {
		map = new Track[numTracks];
		map[0] = new Lane(0, mapDimen);
		for (int i = 1, index = 1; i < numTracks; i += 2, index++) {
			map[i] = new Boundary(-1, mapDimen);
			map[i + 1] = new Lane(index, mapDimen);
		}

		currTrack = map[0]; // first track is default
		currCell = currTrack.getCurrPlace();
		currCell.setActive(true);
		currCol = currCell.getColID();
		currRow = currCell.getRowID();
	}

	public int getmapDimen() { return mapDimen;}

	public void setmapDimen(int i) { mapDimen=i;}

	public int getnumTracks() {return numTracks;}

	public void setNumTracks(int i) { numTracks=i;}

	public int getTotalCells() {return totalCells;}

	public void setTotalCells(int i) {totalCells=i;}

	public Token getTeamToken() {return teamToken;}

	public void setTeamToken(Token i) {teamToken=i;}

	public Place getcurrCell() { return currCell;}

	public void setCurrCell(Place i) { currCell=i; }

	public Track getCurrTrack() {return currTrack;}

	public void setCurrTrack(Track i) {currTrack=i;}

	public int getCurrRow() {return currRow;}

	public void setCurrRow(int i) {currRow=i;}

	public int getCurrCol() {return currCol;}

	public void setCurrCol(int i) {currCol=i;}

}