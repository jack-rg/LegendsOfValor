# Assignment Details

**Title**: Legends Of Valor

**Class**: CGS CS 611

**Semester**: Spring '21

**Authors**:
- Jack Giunta
- Victoria-Rose Burke
- Victor Vicente



## How to Run

**WARNING** This code makes use of the _latest_ version of java and the JDK, and it might not run properly on older versions!

Compilation (On Windows, in the original folder): javac *.java

Run: (On Windows, in the original folder): java Main.java



## Class Description

- Main.java - Access Class for the game
- README.MD - This file, which holds compiling/running details, class descriptions, and an essay length Implementation Detailing
- /Entities/
  - LegendsEntity.java - Abstract Entity Class with basic functionality for all game Entities (Heroes/Monsters)
  - LegendsHero.java - Main Hero Object Class (extends LegendsEntity Abstract Class), includes basic functionality/properties for Heroes
  - LegendsMonster.java - Main Monster Object Class (extends LegendsEntity Abstract Class), includes basic functionality/properties for Monsters
  - LegendsPlayer.Java - Main Player Object Class (extends Player Class), includes functionality for PLAYERS, clearly distinct from Heroes
  - /Classes/
    - LegendsEntityClass.java - Abstract Entity Class Object that holds/maintains/sets out the basis for an Entity Class
	- LegendsHeroClass.java - Class Object for Hero classes (extends LegendsEntityClass Abstract Class), maintains/holds specific Hero class details
	- LegendsMonsterClass.java - Class Object for Monster classes (extends LegendsEntityClass Abstract Class), maintains/holds specific Monster class details
	- /Instances/
	  - Dragon.java - Class Object for specific details of Dragon Monster Class (extends LegendsMonsterClass Class)
	  - Exoskeleton.java - Class Object for specific details of Exoskeleton Monster Class (extends LegendsMonsterClass Class)
	  - Paladin.java - Class Object for specific details of Paladin Hero Class (extends LegendsHeroClass Class)
	  - Sorcerer.java - Class Object for specific details of Sorcerer Hero Class (extends LegendsHeroClass Class)
	  - Spirit.java - Class Object for specific details of Spirit Monster Class (extends LegendsMonsterClass Class)
	  - Warrior.java - Class Object for specific details of Warrior Hero Class (extends LegendsHeroClass Class)
  - /Util/
    - LegendsEntityStats.java - Abstract Stats Class Object for Entities, it holds/maintains/sets out the basis for all Entity Stats Objects
	- /Hero/
	  - LegendsHeroArmour.java - Class Object that holds/maintains the currently Equipped Armour for a specific Hero
	  - LegendsHeroInventory.java - Class Object that holds/maintains the current inventory for a specific Hero, keeping track of all stored items, balance, known spells, and currently equipped items
	  - LegendsHeroStats.java - Class Object for Hero Stats (extends LegendsEntityStats Abstract Class), maintains/holds the in-game statistics specific of Heroes
	- /Monster/
	  - LegendsMonsterStats.java - Class Object for Monster Stats (extends LegendsEntityStats Abstract Class), maintains/holds the in-game statistics specific of Monsters
	- /Player/
	  - LegendsPlayerHeroTeam.java - Class Object for the Hero Team of a specific Player (implements the Iterable Interface), maintains/holds/manipulates the Hero Team
- /Game/
  - LegendsOfValor.java - Main Class Object for the LegendsOfValor RPG Game (extends RPG Abstract Class), includes the needed tools to actually play the game
  - RPG.java - Abstract Class Object that holds the basic functionality for any RPG style game (extends Game Abstract Class)
- /Items/
  - LegendsArmour.java - Class Object for all Armour Items in the game (extends LegendsItem Abstract Class), includes basic functionality for the use of the Armour item
  - LegendsItem.java - Abstract Class Object for all Items used by the LegendsGame, holds/maintains the basic info/functionality shared by all items
  - LegendsPotion.java - Class Object for all Potion Items in the game (extends LegendsItem Abstract Class), includes basic functionality for the use of the Potion item
  - LegendsSpell.java - Class Object for all Spell Items in the game (extends LegendsItem Abstract Class), includes basic functionality for the use of the Spell item
  - LegendsWeapon.java - Class Object for all Weapon Items in the game (extends LegendsItem Abstract Class), includes basic functionality for the use of the Weapon item
- /Map/
  - LegendsMap.java - Class Object for the Legends Game Map (extends Map Abstract Class), includes basic functionality required of the game map
  - /Places/
    - Nature.java - Class Object for the "inaccessible" cells (extends Place Abstract Class), has little functionality outside of the inaccessible status
	- Place.java - Abstract Class Object for all Place cells (extends Cell Class), includes/sets out the basic functionality shared by all Place cells
	- /Market/
	  - Market.java - Class Object for the Market Cells (extends Place Abstract Class), holds all the functionality needed to run the Market Cells
	  - MonsterNexus.java - Class Object for Monster Nexus Cells (extends Nexus Class), specified for the winning/losing conditions
	  - Nexus.java - Class Object for the Nexus Cells (extends Market Class), specified for the specific naming implementation
	  - PlayerNexus.java - Class Object for Player Nexus Cells (extends Nexus Class), specified for the winning/losing conditions
	- /Plains/
	  - Bush.java - Class Object for specific details of the Bush Plains Cell (extends Plains Class)
	  - Cave.java - Class Object for specific details of the Cave Plains Cell (extends Plains Class)
	  - Koulou.java - Class Object for specific details of the Koulou Plains Cell (extends Plains Class)
	  - Plains.java - Class Object for the basic Plains Cells (extends Place Abstract Class), holds all the functionality needed to run the Plains Cells and their subtypes
  - /Tracks/
    - Boundary.java - Class Object for the specific details of a Boundary Track (extends Track Abstract Class), holds the required functionality to stop movement into it
	- Lane.java - Class Object for the specific details of a Lane Track (extends Track Abstract Class), holds the required functionality of the Lanes in the LegendsOfValor game
	- Path.java - Class Object for the specific details of a Path Track (extends Track Abstract Class), holds the most basic info needed of a general Track
	- Track.java - Abstract Class Object for all Map Tracks, holds/sets out the basic functionality shared by all Tracks
- /Util/
  - Printer.java - Static Class to allow for more consistent/clean printing throughout the game
  - Random.java - Static Class to hold basic modified random number generators
  - State.java - Enum Class to hold all the possible State types for any game
  - Token.java - Class Object to hold the displayable Token of an Entity/Cell
  - /Abstraction/
    - Cell.java - Class Object for all Game Map Cells, holds the most basic functionality needed of a general Cell
	- Entity.java - Abstract Class Object for all game Playable Entities, holds the basic functionality needed of any Playable Object
	- Game.java - Abstract Class Object for a generalized Game, holds the basic functionality needed of all Games
	- Inventory.java - Abstract Class Object for a generalized Inventory, holds the basic functionality needed for this Collection class
	- Map.java - Abstract Class Object for a generalized Game Map, holds the basic functionality shared by all Game Maps
	- Player.java - Abstract Class Object for a generalized Game Player, holds the basic functionality shared by all Players
  - /Creation/
    - EntityGenerator.java - Static Class to allow randomized creation of Entities for the LegendsOfValor Game
	- ItemGenerator.java - Static Class to allow randomized creation of Items for the LegendsOfValor Game
	- Names.java - Static Class to get a randomized name for an Entity or Item
	- /Config/
	  - NameListsArmour.java - Static List of all names for LegendsArmour Items
	  - NameListsEntities.java - Static List of all names for LegendsEntities Entities
	  - NameListsPotions.java - Static List of all names for LegendsPotion Items
	  - NameListsSpells.java - Static List of all names for LegendsSpell Items
	  - NameListsWeapons.java - Static List of all names for LegendsWeapon Items




## Implementation Detailing

COMING SOON