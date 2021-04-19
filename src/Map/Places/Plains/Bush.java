/*=====================================================*/
/* Project Title: Legends Of Valor                     */
/* Course Name: GRS CS611                              */
/* Semester: Spring '21                                */
/* Project Authors:                                    */
/*    - Jack Giunta                                    */
/*    - Victoria-Rose Burke                            */
/*    - Victor Vicente                                 */
/*=====================================================*/

package Map.Places.Plains;

import Util.Token;
import Util.Abstraction.Track;

public class Bush extends Plains {

	/* =================== */
	/* Constructor Methods */
	/* =================== */
	
	public Bush(Track track, int row, int col, Token plainToken) {
		super(track, row, col, plainToken, "Dexterity");
	}

}