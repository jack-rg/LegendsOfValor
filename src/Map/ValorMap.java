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

}