package Map.Places;

import Entities.LegendsEntity;
import Entities.LegendsHero;
import Game.LegendsOfValor;
import Map.Tracks.Track;
import Util.Token;

public class MonsterNexus extends Nexus {

	public MonsterNexus(Track track, int row, int col, Token nexusType) {
		super(track, row, col, nexusType);
	}
	
	@Override
	public void activatePlace(LegendsEntity h, LegendsOfValor game){
		if (h instanceof LegendsHero)
			System.out.println("You have reached an Enemy Nexus!"); 
	}
}
