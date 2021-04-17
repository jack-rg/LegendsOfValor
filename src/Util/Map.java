package Util;

import Map.Places.Place;
import Map.Tracks.Path;
import Map.Tracks.Track;

public class Map {
	public Track[] map;
	public Place currCell;
	public Track currTrack;
	public int numTracks;
	public Token teamToken;
	public int mapDimen;
	public int totalCells;
	public int currRow;
	public int currCol;

	public Map(int numTracks, int length) {
		this.mapDimen = length;
		this.numTracks = numTracks;
		totalCells = mapDimen * mapDimen;
		this.teamToken = new Token("\\o/");
		initBoard();
	}

	public void initBoard() {
		map = new Path[mapDimen];
		for (int p = 0; p < mapDimen; p++) {
			map[p] = new Path(p, mapDimen);
		}
		currTrack = map[0]; // first track is default
		currCell = currTrack.getCurrPlace();
		currCell.setActive(true);
		currCol = currCell.getColID();
		currRow = currCell.getRowID();
	}

	public void updateBoard(int nextRow, int nextCol) {
		currCell.setActive(false);
		currRow = nextRow;
		currCol = nextCol;
		currTrack.setCurrPlace(nextRow, nextCol);
		currCell = currTrack.getCurrPlace();
		currCell.setActive(true);
	}

	public int getMapDimen() {
		return mapDimen;
	}

	public Place getCurrCell() {
		return currCell;
	}

	public Place getPlace(int laneID, int row, int col) {
		return map[laneID].getPlace(row, col);
	}

	// Print out board in nice fashion
	public void print() {
		for (Track t : map) {
			t.printTrack();
		}

	}

}