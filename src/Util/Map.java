package Util;

import Map.Places.Place;
import Map.Tracks.Boundary;
import Map.Tracks.Lane;
import Map.Tracks.Track;

public abstract class Map {
	public Track[] map;
	public int numTracks;
	public Token teamToken;
	public int mapDimen;
	public int totalCells;

	public Map(int numTracks, int length) {
		this.mapDimen = length;
		this.numTracks = numTracks;
		totalCells = mapDimen * mapDimen;
		this.teamToken = new Token("\\o/");
		initBoard();
	}

	public abstract void initBoard();

	public int getMapDimen() {
		return mapDimen;
	}

	public Track[] getRawTracks() {
		return map;
	}

	public Place getPlace(int laneID, int row, int col) {
		return map[laneID].getPlace(row, col);
	}

	// Print out board in nice fashion
	public void print() {
		for (int k = 0; k < mapDimen; k++) {
			/* TOP ROW */
			for (int i = 0; i < mapDimen; i++) {
				System.out.print("+-------+");
			}
			/* TOP ROW */

			/* HELPER METHOD */
			String[] placeTokens = new String[mapDimen];
			String[] monsterTokens = new String[mapDimen];
			String[] heroTokens = new String[mapDimen];

			int d = 0;
			for (int i = 0; i < numTracks; i++) {

				Track currentTrack = map[i];
				if (currentTrack instanceof Lane) {
					placeTokens[d] = (currentTrack.getPlace(k, 0).getToken().getDesign());
					placeTokens[d + 1] = (currentTrack.getPlace(k, 1).getToken().getDesign());
					if (currentTrack.getPlace(k, 0).getMonstersOnCell().size() > 0)
						monsterTokens[d] = "VoV";
					if (currentTrack.getPlace(k, 1).getMonstersOnCell().size() > 0)
						monsterTokens[d + 1] = "VoV";
					if (currentTrack.getPlace(k, 0).getHeroesOnCell().size() > 0)
						heroTokens[d] = "\\o/";
					if (currentTrack.getPlace(k, 1).getHeroesOnCell().size() > 0)
						heroTokens[d + 1] = "\\o/";
					d += 2;
				}
				if (currentTrack instanceof Boundary) {
					placeTokens[d] = (currentTrack.getPlace(k, 0).getToken().getDesign());
					d++;
				}

			}

			/* HELPER METHOD */

			/* MIDDLE ROW */
			System.out.println();

			for (int i = 0; i < mapDimen; i++) {
				if (placeTokens[i] != null) {
					System.out.print("|  " + placeTokens[i] + "  |");
				} else {
					System.out.print("|       |");
				}
			}
			System.out.println();

			for (int i = 0; i < mapDimen; i++) {
				if (monsterTokens[i] != null) {
					System.out.print("|" + monsterTokens[i] + " ");
				} else {
					System.out.print("|    ");
				}
				if (heroTokens[i] != null) {
					System.out.print(heroTokens[i] + "|");
				} else {
					System.out.print("   |");
				}
			}
			System.out.println();
			/* MIDDLE ROW */
		}
		/* BOTTOM ROW */
		for (int i = 0; i < mapDimen; i++) {
			System.out.print("+-------+");
		}
		/* BOTTOM ROW */
		System.out.println();
	}

}