Preface:
I want it to be clear that this is not an assignment that I'm particularly proud of. 
I am more than grateful for the extensions that were given, and I don't want the lack of observed effort to reflect any notion of disrespect.
I am also not writing this as an excuse but moreso an explanation for the resulting submission. 
My grandmother passed away recently, and as a result I had to fly home for the funeral services. This loss really affected me more than I anticipated.
I really thought that I could juggle both my responsibilities to my family and my academic responsibilities, but this proved harder than I expected.
I also felt selfish when considering asking for more time since we were already generously given another week. 
What I have kept in mind is that I am taking this class to learn and practice my coding skills, and I still did that with this initial attempt.
I particularly struggled to use generic methods or wildcards when coding the market sequences, because I am sure there is a way to avoid all of the repetitive procedures.
When grading this submission, if you could focus a bit more on the design of the elements that do exist (like the market sequence) rather than those that I was unable to fully implement (like the fight sequence) I would really appreciate it.
While I was unable to dedicate my full time and effort to this assignment, I am looking forward to your feedback and advice for the latter 70% of the assignment. 
My sincere appologies.

Explanation of Classes:

LegendsAndHearos.java - a class used to run the Legends and Heros game.
Game.java - an abstract class representing the functions of a turn-based game.
RPG.java - a class specifying the elements of a Role-Playing Game, including a Player with a team of Characters
Player.java - a class representing the functions of a Player in a game setting
RPG_Player.java - a class specifying the elements of a Player in a role-playing game, including managing aspects of characters and manipulating turns
Character.java - a class representing the aspects of in-game characters, such as Monsters and Heros
Monster.java - a class representing a Monster character in the game, including its specific stats
Hero.java - a class representing a Hero character in the game, including its specific stats and items held in inventory.

Item.java - an abstract class representing an object of use in an RPG, including its stats
Armor.java - a child class of Item specifying stats for Armor in the game
Weapon.java - a child class of Item specifying stats for Weapons in the game
Potion.java - a child class of Item specifying stats for Potions in the game
Spell.java - a child class of Item specifying stats for Spells in the game

Inventory.java - a class representing a selection menu of items that a player may view in a game, or may represent a market's stock

Map.java - a class housing the game board for an RPG, including specific cells for different locations
Token.java - an class that holds generic information for the design of a location or cell in a boardgame.
Cell.java - an abstract class for a generic cell in a board game, including info about its location and token
Place.java - a type of Cell that holds locational information in an RPG, including how that place should be interacted with by the player
Market.java - a type of place that includes functionality for buying and selling of items, also holds info about this specific market's stock
Path.java - a type of place that includes functionality for monster fights and equipability. Underdeveloped due to circumstance.
Nature.java - a type of place that adds design to the boardfor inaccessible areas

State.java = enum for different game states such as playing or quitting
ItemType.java = enum for different types of items in the game
HeroType.java = enum for different types of heros in the game
MonsterType.java = enum for different types of monsters in the game

Addition files:

In this directory there is also a directory for Additionals. These text files were included as a means to make the game more user friendly. 
If a user wanted to add new Items, Monsters, Heros, etc. into the game, they do not need to enter the code to do so. Adding the info to these 
text files will implement them into the game automatically when the items are instantiated. The format is important, but otherwise I thought it was a neat edition.

introduction.txt is another included file that lists a few lines giving some nice story elements to the game. This, like the additionals,
can be modified and the game will adapt dynamically. I just thought it was cute.


How to run:
In the main directory in this zip folder, compile and run LegendsAndHeros.java. The game will be instantiated from the instructor and run from there.

Implementation Notes:

While I was not able to implement the fight sequence, I left this part until the end because for the most part the code to run the fight sequence is extremely similar
to the code used elsewhere in the project already. The only difference is adding in helper functions to allow the character's stats to reflect their current level/skill/ability.
Generating the monsters would have been just the same as generating characters, with the randomization aspect that is included in the instantiation of Items at the market.
The rest sequence would allow for the player to enable items much like they do when they purchase items at the market.

As mentioned before, my biggest struggle was creating generic methods to eleminate repetitive code, specifically in the Market sequences. 
I experimented with several different designs for this but for the sake of time and knowledge, I ended up repeating certain segments.
I look forward to learning what I might have been missing/overlooked to make these classes more replicable and clean. 

Similarly, I tried very hard to make sure that the higher level classes held the most general data for each child object group, 
and slowly got more specific with child classes. I do think that there is room for more specificity (as in potentially creating classes for different
heros/monsters or spells) and I know there could be more room ofr abstraction (i.e. elements of map could be in a general board for a game). I will explore this in the latter implementation.
The best example of abstraction for my current implementation was how easy it is to change a token for a place, or add a place to the map. 


I did learn how to use java's formatting system though, so I hope you enjoy the few graphics I added to make the process look better. 


