package Map.Track_Types;

import Map.Place_Types.Place;

//A column of a map. Can hold different dimensions or lengths
public abstract class Track {
	private int trackID;

	public Track(int trackID) {
		this.trackID = trackID;
	}

	public int getTrackID() {
		return trackID;
	}

	public void setTrackID(int newID) {
		trackID = newID;
	}

	public abstract Place getPlace(int row, int col);

	public abstract Place getCurrPlace();

	public abstract void setCurrPlace(int row, int col);

	public abstract void printTrack();

}