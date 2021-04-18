package Map.Places;

import Entities.LegendsEntity;
import Game.LegendsOfValor;
import Map.Tracks.Track;
import Util.Token;

public class Nature extends Place {

	public Nature(Track track, int row, int col, Token natureToken) {
		super(track, row, col, false, natureToken);
	}

	public void activatePlace(LegendsEntity e, LegendsOfValor game) {
		System.out.println("These woods give you an eerie feeling. Better keep out.");
	}

	@Override
	public void showInfo() {
		
	}

}