package Map.Places.Plains;

//Common Tile Place in an RPG
import java.util.*;

import Entities.LegendsEntity;
import Entities.LegendsHero;
import Entities.Util.Hero.LegendsHeroStats;
import Entities.Util.Monster.LegendsMonsterStats;
import Entities.LegendsMonster;
import Game.LegendsOfValor;
import Items.LegendsArmour;
import Items.LegendsItem;
import Items.LegendsPotion;
import Items.LegendsSpell;
import Items.LegendsWeapon;
import Map.Places.Place;
import Util.Token;
import Util.Creation.ItemGenerator;
import Util.Random;
import Util.State;

public class Plains extends Place {
	public static final ArrayList<String> POSSIBLE_BUFFS = new ArrayList<String>(
			Arrays.asList(new String[] { "Dexterity", "Strength", "Agility", "None" }));

	private String statToBoost;

	private ArrayList<LegendsHero> heroesOnCell;
	private ArrayList<LegendsMonster> monstersOnCell;

	private ArrayList<LegendsHero> leftOverHeroes;
	private ArrayList<LegendsMonster> leftOverMonsters;
	private ArrayList<LegendsHero> deadHeroes;

	HashMap<LegendsHero, LegendsMonster> matchings;

	HashMap<LegendsEntity, HashMap<String, Integer>> effectCounters;

	public Plains(int row, int col, Token plainToken, String statToBoost) {
		super(row, col, true, plainToken);
		this.setStatToBoost(statToBoost);

		heroesOnCell = new ArrayList<LegendsHero>();
		monstersOnCell = new ArrayList<LegendsMonster>();

		leftOverHeroes = new ArrayList<LegendsHero>();
		leftOverMonsters = new ArrayList<LegendsMonster>();

		deadHeroes = new ArrayList<LegendsHero>();

		matchings = new HashMap<LegendsHero, LegendsMonster>();
		effectCounters = new HashMap<LegendsEntity, HashMap<String, Integer>>();
	}

	public void activatePlace(LegendsEntity e, LegendsOfValor game) {
		game.getMap().updateBoard(this.getRowID(), this.getColID());

		if (e instanceof LegendsHero)
			heroesOnCell.add((LegendsHero) e);
		else if (e instanceof LegendsMonster)
			monstersOnCell.add((LegendsMonster) e);

		System.out.println("Your party sets out along the road!");

		if (heroesOnCell.size() >= 1 && monstersOnCell.size() >= 1) {
			fightSequence(game);
		}
	}

	public void fightSequence(LegendsOfValor game) {
		System.out.println("Oh no! A Monster Ambush!");

		makeMatchings();

		while (!matchings.isEmpty() && (!leftOverHeroes.isEmpty() || !leftOverMonsters.isEmpty())
				&& game.getStatus().equals(State.PLAYING)) {
			if (!leftOverHeroes.isEmpty() && !leftOverMonsters.isEmpty())
				reMatch();

			for (LegendsHero h : matchings.keySet())
				heroFight(h, matchings.get(h), game);
		}
	}

	private void heroFight(LegendsHero h, LegendsMonster m, LegendsOfValor game) {
		String nextMove = this.processUserInput();
		preformMove(nextMove, h, m, game);

		if (m.getEntityStats().getCurrHP() > 0) {
			attackHero(h, m);

			if (h.getEntityStats().getCurrHP() > 0) {
				h.getEntityStats().regenHealth(0.1);
				((LegendsHeroStats) h.getEntityStats()).regenMana(0.1);
			} else {
				this.leftOverMonsters.add(m);
				this.deadHeroes.add(h);

				this.matchings.remove(h);

				m.getEntityStats().addEXP(10 * h.getEntityStats().getLevel());
				if (m.getEntityStats().getEXP() >= m.getEntityStats().getLevel() * 10)
					m.levelUp();
			}
		} else {
			h.getEntityStats().regenHealth(1);
			((LegendsHeroStats) h.getEntityStats()).regenMana(1);
			this.leftOverHeroes.add(h);

			this.matchings.remove(h);

			h.getEntityStats().addEXP(10 * m.getEntityStats().getLevel());
			if (h.getEntityStats().getEXP() >= h.getEntityStats().getLevel() * 10)
				h.levelUp();
		}

		this.dealWithEffects();
	}

	private void dealWithEffects() {
		for (LegendsEntity e : this.effectCounters.keySet()) {
			for (String ability : this.effectCounters.get(e).keySet()) {
				Integer curr = this.effectCounters.get(e).get(ability);
				if (curr == 1)
					this.effectCounters.get(e).remove(ability);
				else
					this.effectCounters.get(e).put(ability, curr - 1);

				if (this.effectCounters.get(e).isEmpty())
					this.effectCounters.remove(e);
			}
		}
	}

	private void attackHero(LegendsHero h, LegendsMonster m) {

		double agilityMultiplier = (statToBoost.equals("Agility")) ? 1.10 : 1.0;
		double dodgeChance = ((LegendsHeroStats) h.getEntityStats()).getAgility() * agilityMultiplier * 0.002;

		if (Math.random() > dodgeChance) {
			double defenseMultiplier = h.getInventory().getEquippedArmour().getMultiplier();

			int damage = ((LegendsMonsterStats) m.getEntityStats()).getStrength()
					- ((int) Math.round(((LegendsMonsterStats) m.getEntityStats()).getStrength() * defenseMultiplier));

			if (damage < 0)
				damage = 0;

			h.getInventory().getEquippedArmour().takeDamage(
					(int) Math.round(((LegendsMonsterStats) m.getEntityStats()).getStrength() * defenseMultiplier));

			h.getEntityStats().takeDamage(damage);

			System.out.println(m.getName() + " has attacked " + h.getName() + " dealing " + damage + " damage!");
		} else {
			System.out.println(h.getName() + " has dodged " + m.getName() + "'s attack!");
		}

	}

	private void preformMove(String nextMove, LegendsHero h, LegendsMonster m, LegendsOfValor game) {
		switch (nextMove) {
		case "i":
			checkInfo();
			break;
		case "c":
			LegendsItem returnItem = h.getInventory().accessInventory();
			if (returnItem != null)
				useItem(returnItem, h, m);
			break;
		case "a":
			attackMonster(h, m);
			break;
		case "s":
			castSpell(h, m);
			break;
		case "r":
			revive(h);
			break;
		case "q":
			game.quit();
			break;
		default:
			System.out.println("This move is currently invalid. Please input a proper value");
			break;
		}
	}

	private void useItem(LegendsItem item, LegendsHero h, LegendsMonster m) {
		if (item instanceof LegendsArmour) {
			h.getInventory().switchArmour((LegendsArmour) item);
		} else if (item instanceof LegendsWeapon) {
			h.getInventory().replaceEquippedWeapon((LegendsWeapon) item);
		} else if (item instanceof LegendsPotion) {
			this.usePotion(((LegendsPotion) item), h, m);
		} else {
			System.out.println("Selected item is unusable!");
		}
	}

	private void usePotion(LegendsPotion p, LegendsHero h, LegendsMonster m) {
		if (p.getIsBuff()) {
			this.usePotionOnFriendly(p, h);
		} else {
			this.usePotionOnEnemy(p, h, m);
		}
	}

	private void usePotionOnEnemy(LegendsPotion p, LegendsHero h, LegendsMonster m) {
		switch (p.getTargetAbility()) {
		case "Strength":
		case "Defense":
		case "Dodge":
			((LegendsMonsterStats) m.getEntityStats()).applyDebuff(p.getTargetAbility(), p.getMultiplier());

			if (this.effectCounters.containsKey(m)) {
				this.effectCounters.get(m).put(p.getTargetAbility(), 5);
			} else {
				HashMap<String, Integer> effectDetails = new HashMap<String, Integer>();
				effectDetails.put(p.getTargetAbility(), 5);

				this.effectCounters.put(m, effectDetails);
			}

			System.out.println(
					h.getName() + " used " + p.getName() + " to debuff " + m.getName() + " 's " + p.getTargetAbility());
			break;
		default:
			System.out.println("ERROR!!!");
			break;
		}
	}

	private void usePotionOnFriendly(LegendsPotion p, LegendsHero h) {
		@SuppressWarnings("unused")
		int choice;

		while (true) {
			System.out.println("Please pick an ally to assist!");
			int i = 0;
			for (LegendsHero hero : matchings.keySet()) {
				System.out.println("[" + i + "] " + hero.getName());
				i++;
			}

			choice = in.nextInt();

			if (i >= 0 && i < matchings.keySet().size()) {
				LegendsHero choiceHero = (LegendsHero) matchings.keySet().toArray()[i];

				switch (p.getTargetAbility()) {
				case "Strength":
				case "Defense":
				case "Dodge":
					((LegendsHeroStats) choiceHero.getEntityStats()).applyBuff(p.getTargetAbility(), p.getMultiplier());

					if (this.effectCounters.containsKey(choiceHero)) {
						this.effectCounters.get(choiceHero).put(p.getTargetAbility(), 5);
					} else {
						HashMap<String, Integer> effectDetails = new HashMap<String, Integer>();
						effectDetails.put(p.getTargetAbility(), 5);

						this.effectCounters.put(choiceHero, effectDetails);
					}

					System.out.println(h.getName() + " used " + p.getName() + " to boost " + choiceHero.getName()
							+ " 's " + p.getTargetAbility());
					break;
				default:
					System.out.println("ERROR!!!");
					break;
				}
			} else {
				System.out.println("Invalid option! Trying again!");
			}
		}

	}

	private void revive(LegendsHero h) {
		if (this.deadHeroes.isEmpty()) {
			System.out.println("No heroes are dead!");
			return;
		}

		LegendsHero toRevive = this.pickRevive();

		System.out.println(h.getName() + " has revived " + toRevive.getName());

		((LegendsHeroStats) toRevive.getEntityStats()).regenHealth(1);
		((LegendsHeroStats) toRevive.getEntityStats()).regenMana(1);
		this.leftOverHeroes.add(toRevive);
	}

	private LegendsHero pickRevive() {

		System.out.println("Currently dead Heroes:");

		for (int i = 0; i < this.deadHeroes.size(); i++)
			System.out.println("[" + i + "] " + deadHeroes.get(i).getName());

		System.out.println();
		System.out.println("Please enter the number of the Hero you want to revive:");

		while (true) {
			int picked = in.nextInt();
			if (picked >= 0 && picked < deadHeroes.size()) {
				return deadHeroes.remove(picked);
			}

			System.out.println("Invalid number choosen! Trying again!");
		}
	}

	private void castSpell(LegendsHero h, LegendsMonster m) {
		LegendsSpell spellToCast = h.getInventory().pickSpell();

		if (spellToCast == null)
			return;

		if (spellToCast.getIsBuff()) {
			this.castSpellOnFriendly(spellToCast, h);
		} else {
			this.castSpellOnEnemy(spellToCast, h, m);
		}
	}

	private void castSpellOnFriendly(LegendsSpell spellToCast, LegendsHero h) {
		@SuppressWarnings("unused")
		int choice;

		while (true) {
			System.out.println("Please pick an ally to assist!");
			int i = 0;
			for (LegendsHero hero : matchings.keySet()) {
				System.out.println("[" + i + "] " + hero.getName());
				i++;
			}

			choice = in.nextInt();

			if (i >= 0 && i < matchings.keySet().size()) {
				LegendsHero choiceHero = (LegendsHero) matchings.keySet().toArray()[i];

				switch (spellToCast.getTargetAbility()) {
				case "Strength":
				case "Defense":
				case "Dodge":
					((LegendsHeroStats) choiceHero.getEntityStats()).applyBuff(spellToCast.getTargetAbility(),
							spellToCast.getMultiplier());

					if (this.effectCounters.containsKey(choiceHero)) {
						this.effectCounters.get(choiceHero).put(spellToCast.getTargetAbility(), 5);
					} else {
						HashMap<String, Integer> effectDetails = new HashMap<String, Integer>();
						effectDetails.put(spellToCast.getTargetAbility(), 5);

						this.effectCounters.put(choiceHero, effectDetails);
					}

					System.out.println(h.getName() + " used " + spellToCast.getName() + " to boost "
							+ choiceHero.getName() + " 's " + spellToCast.getTargetAbility());

					break;
				default:
					System.out.println("ERROR!!!");
					break;
				}
			} else {
				System.out.println("Invalid option! Trying again!");
			}
		}

	}

	private void castSpellOnEnemy(LegendsSpell spellToCast, LegendsHero h, LegendsMonster m) {
		double dodgeChance = ((LegendsMonsterStats) m.getEntityStats()).getDodge() * 0.1;

		if (Math.random() > dodgeChance && spellToCast != null) {
			if (((LegendsHeroStats) h.getEntityStats()).getCurrMana() < spellToCast.getManaRequired()) {
				System.out.println(h.getName() + " does not have enough Mana to cast " + spellToCast.getName());
			} else {
				((LegendsHeroStats) h.getEntityStats()).spendMana(spellToCast.getManaRequired());

				int spellBaseDamage = (int) Math.round(spellToCast.getMaxDamage()
						* (h.getEntityStats().getLevel() / ItemGenerator.LEVEL_TO_UNLOCK_EVERYTHING));

				double dexMultiplier = (statToBoost.equals("Dexterity")) ? 1.10 : 1.0;

				int dexDamage = (int) Math.round(spellBaseDamage
						+ ((((LegendsHeroStats) h.getEntityStats()).getDexterity() * dexMultiplier) / 10000.0)
								* spellBaseDamage);

				int damage = dexDamage - ((LegendsMonsterStats) m.getEntityStats()).getDefense();

				System.out.println(h.getName() + " attacked " + m.getName() + " using " + spellToCast.getName()
						+ " dealing " + damage + " damage to them!");

				switch (spellToCast.getTargetAbility()) {
				case "Strength":
				case "Defense":
				case "Dodge":
					((LegendsMonsterStats) m.getEntityStats()).applyDebuff(spellToCast.getTargetAbility(),
							spellToCast.getMultiplier());

					if (this.effectCounters.containsKey(m)) {
						this.effectCounters.get(m).put(spellToCast.getTargetAbility(), 5);
					} else {
						HashMap<String, Integer> effectDetails = new HashMap<String, Integer>();
						effectDetails.put(spellToCast.getTargetAbility(), 5);

						this.effectCounters.put(m, effectDetails);
					}

					System.out.println(h.getName() + " attacked " + m.getName() + " using " + spellToCast.getName()
							+ " and applied a debuff to their " + spellToCast.getTargetAbility());

					break;
				default:
					System.out.println("ERROR!!!");
					break;
				}
			}
		} else {
			System.out.println(m.getName() + " dodged the magic attack from " + h.getName());
		}
	}

	private void attackMonster(LegendsHero h, LegendsMonster m) {
		double dodgeChance = ((LegendsMonsterStats) m.getEntityStats()).getDodge() * 0.1;
		if (Math.random() > dodgeChance) {
			int weaponDamage = 100;
			if (h.getInventory().getEquippedWeapon() != null)
				weaponDamage = h.getInventory().getEquippedWeapon().getDamage();

			double strengthMultiplier = (statToBoost.equals("Strength")) ? 0.15 : 0.05;
			weaponDamage += (int) Math
					.round(((LegendsHeroStats) h.getEntityStats()).getStrength() * strengthMultiplier);

			int finalDamage = weaponDamage - ((LegendsMonsterStats) m.getEntityStats()).getDefense();

			if (finalDamage < 0)
				finalDamage = 0;

			m.getEntityStats().takeDamage(finalDamage);

			String weaponName = "their fists";
			if (h.getInventory().getEquippedWeapon() != null) {
				weaponName = h.getInventory().getEquippedWeapon().getName();

				h.getInventory().getEquippedWeapon().loseDurability(1);

				if (h.getInventory().getEquippedWeapon().getCurrentDurability() <= 0) {
					System.out.println(h.getName() + "'s weapon " + h.getInventory().getEquippedWeapon().getName()
							+ " has been broken!");
					h.getInventory().replaceEquippedWeapon(null);
				}
			}

			System.out.println(h.getName() + " has attacked " + m.getName() + " using " + weaponName + " and dealing "
					+ finalDamage + " damage!");

		} else {
			System.out.println(m.getName() + " has dodged " + h.getName() + "'s attack!");
		}

	}

	private void checkInfo() {
		// TODO Auto-generated method stub
		// Print Hero & Monster info for all heroes/monsters in the tile
		System.out.println("INFO");
	}

	private String processUserInput() {
		while (true) {
			System.out.println("What would you like to do?");
			printActions();
			String input = in.nextLine();
			switch (input.toLowerCase()) {
			case "i":
			case "c":
			case "a":
			case "s":
			case "r":
			case "q":
				return input.toLowerCase();
			default:
				System.out.println("This move is currently invalid. Please input a proper value");
				break;
			}
		}
	}

	public void printActions() {
		String leftAlignFormat = "| %-15s | %-4s |%n";

		System.out.format("+------------------------+%n");
		System.out.format("|         ACTIONS        |%n");
		System.out.format("+-----------------+------+%n");
		System.out.format(leftAlignFormat, "check info", "i");
		System.out.format(leftAlignFormat, "check inventory", "c");
		System.out.format(leftAlignFormat, "attack monster", "a");
		System.out.format(leftAlignFormat, "cast spell", "s");
		System.out.format(leftAlignFormat, "cast spell", "r");
		System.out.format(leftAlignFormat, "quit", "q");
		System.out.format("+-----------------+------+%n");

	}

	public boolean isFighting() {
		boolean flagMonster = false;
		boolean flagHero = false;
		for (LegendsMonster m : monstersOnCell) {
			if (m.getEntityStats().getCurrHP() > 0) {
				flagMonster = true;
			}
		}
		for (LegendsHero h : heroesOnCell) {
			if (h.getEntityStats().getCurrHP() > 0) {
				flagHero = true;
			}
		}
		return flagHero && flagMonster;
	}

	@SuppressWarnings("unchecked")
	private void reMatch() {
		while ((!leftOverHeroes.isEmpty()) && (!leftOverMonsters.isEmpty()))
			this.matchings.put(leftOverHeroes.remove(0), leftOverMonsters.remove(0));
	}

	@SuppressWarnings("unchecked")
	private void makeMatchings() {
		ArrayList<LegendsMonster> copyMonsters = (ArrayList<LegendsMonster>) monstersOnCell.clone();
		ArrayList<LegendsHero> copyHeroes = (ArrayList<LegendsHero>) heroesOnCell.clone();

		while ((!copyHeroes.isEmpty()) && (!copyMonsters.isEmpty())) {
			this.matchings.put(copyHeroes.remove(0), copyMonsters.remove(0));
		}

		for (LegendsHero h : copyHeroes)
			this.leftOverHeroes.add(h);

		for (LegendsMonster m : copyMonsters)
			this.leftOverMonsters.add(m);
	}

	public String getStatToBoost() {
		return statToBoost;
	}

	private void setStatToBoost(String statToBoost) {
		if (Plains.POSSIBLE_BUFFS.indexOf(statToBoost) == -1) {
			System.out.println("Invalid Stat To Boost!");
			return;
		}
		this.statToBoost = statToBoost;
	}
}