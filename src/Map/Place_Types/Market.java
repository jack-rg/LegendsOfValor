package Map.Place_Types;

import java.io.File;
import java.util.*;

import Entities.LegendsHero;
import Entities.Util.Hero.LegendsHeroInventory;
import Game.LegendsOfValor;
import Items.LegendsArmour;
import Items.LegendsItem;
import Items.LegendsPotion;
import Items.LegendsSpell;
import Items.LegendsWeapon;
import Map.Location;
import Util.Token;

public class Market extends Place {
  public ArrayList<LegendsItem> inventory;

  public Market(int row, int col, Token marketToken) {
    super(row, col, true, marketToken);
    inventory = new ArrayList<LegendsItem>();
    // TODO 
    // Generate Random Items
  }
  
  public void activatePlace(LegendsOfValor game) {
    game.getMap().updateBoard(this.getRowID(), this.getColID());
    System.out.println("Your party stumbles past the town market!");
    System.out.println("Would you like to enter? [Y/N]");
    while (true) {
      try {
        String input = in.nextLine();
        if (input.equalsIgnoreCase("Y")) {
          marketSequence(game);
          break;
        } else if (input.equalsIgnoreCase("N")) {
          break;
        } else {
          System.out.println("Please input a valid response");
        }
      } catch (Exception e) {
        System.out.println("Please input a valid response");
        in.nextLine();
      }
    }

  }

  public void marketSequence(RPG game) {
    System.out.println("Welcome to the shop!");
    while (true) {
      System.out.println("Please choose one of the following actions:");
      printActions();
      try {
        String input = in.nextLine();
        if (input.equalsIgnoreCase("1")) {
          shopSequence(game);
        } else if (input.equalsIgnoreCase("2")) {
          sellSequence(game);
        } else if (input.equalsIgnoreCase("i")) {
          game.showInfo();
        } else if (input.equalsIgnoreCase("m")) {
          game.getMap().print();
        } else if (input.equalsIgnoreCase("q")) {
          game.quit();
          break;
        } else if (input.equalsIgnoreCase("0")) {
          break;
        } else {
          System.out.println("Please input a valid action here.");
        }

      } catch (Exception e) {
        System.out.println("Please input a valid response there");
        in.nextLine();
      }
    }

  }

  public void shopSequence(RPG game) {
    System.out.println("Who doesn't love shopping!");
    inventory.printInventory();
    while (true) {
      Hero activeHero = game.player.chooseHero();
      if (activeHero == null) {
        break;
      }
      ItemType activeItems = chooseCategory(this.inventory);
      if (activeItems == null) {
        break;
      }
      if (activeItems == ItemType.WEAPON) {
        attemptPurchaseWeapon(activeHero);
      } else if (activeItems == ItemType.ARMOR) {
        attemptPurchaseArmor(activeHero);
      } else if (activeItems == ItemType.POTION) {
        attemptPurchasePotion(activeHero);
      } else if (activeItems == ItemType.SPELL) {
        attemptPurchaseSpell(activeHero);
      } else {
        System.out.println("Error in type setting");
        break;
      }
    }
    System.out.println("Thanks for shopping!");
  }

  public void attemptPurchaseWeapon(Hero activeHero) {
    while (true) {
      System.out.println("What would you like to purchase? Input the corresponding int, or input -1 to go back.");
      inventory.printWeapons();
      try {
        int input = in.nextInt();
        if (input == -1) {
          break;
        } else {
          Weapon selection = inventory.getWeapons().get(input);
          System.out.println("You chose " + selection.getName());
          if (selection.getPrice() <= activeHero.getMoney()) {
            if (selection.getMinLevel() <= activeHero.getLevel()) {
              Weapon item = inventory.getWeapons().remove(input);
              activeHero.accessInventory().addWeapon(item);
              activeHero.updateMoney(-1 * selection.getPrice());
              System.out.println("Thank you for your purchase!");
            } else {
              System.out.println("This Hero is not ready for this item. You need more levels. ");
            }
          } else {
            System.out.println("This Hero is not ready for this item. You need more money.");
          }
        }
      } catch (Exception e) {
        System.out.println("Please input a valid int selection");
        in.nextLine();
      }
    }
  }

  public void attemptPurchaseArmor(Hero activeHero) {
    while (true) {
      System.out.println("What would you like to purchase? Input the corresponding int, or input -1 to go back.");
      inventory.printArmors();
      try {
        int input = in.nextInt();
        if (input == -1) {
          break;
        } else {
          Armor selection = inventory.getArmors().get(input);
          System.out.println("You chose " + selection.getName());
          if (selection.getPrice() <= activeHero.getMoney()) {
            if (selection.getMinLevel() <= activeHero.getLevel()) {
              Armor item = inventory.getArmors().remove(input);
              activeHero.accessInventory().addArmor(item);
              activeHero.updateMoney(-1 * selection.getPrice());
              System.out.println("Thank you for your purchase!");
            } else {
              System.out.println("This Hero is not ready for this item. You need more levels. ");
            }
          } else {
            System.out.println("This Hero is not ready for this item. You need more money.");
          }
        }
      } catch (Exception e) {
        System.out.println("Please input a valid int selection");
        in.nextLine();
      }
    }

  }

  public void attemptPurchasePotion(LegendsHero activeHero) {
    while (true) {
      System.out.println("What would you like to purchase? Input the corresponding int, or input -1 to go back.");
      inventory.printPotions();
      try {
        int input = in.nextInt();
        if (input == -1) {
          break;
        } else {
          LegendsPotion selection = inventory.getPotions().get(input);
          System.out.println("You chose " + selection.getName());
          if (selection.getPrice() <= activeHero.getMoney()) {
            if (selection.getMinLevel() <= activeHero.getLevel()) {
              LegendsPotion item = inventory.getPotions().remove(input);
              activeHero.accessInventory().addPotion(item);
              activeHero.updateMoney(-1 * selection.getPrice());
              System.out.println("Thank you for your purchase!");
            } else {
              System.out.println("This Hero is not ready for this item. You need more levels. ");
            }
          } else {
            System.out.println("This Hero is not ready for this item. You need more money.");
          }
        }
      } catch (Exception e) {
        System.out.println("Please input a valid int selection");
        in.nextLine();
      }
    }

  }

  public void attemptPurchaseSpell(LegendsHero activeHero) {
    while (true) {
      System.out.println("What would you like to purchase? Input the corresponding int, or input -1 to go back.");
      inventory.printSpells();
      try {
        int input = in.nextInt();
        if (input == -1) {
          break;
        } else {
          LegendsSpell selection = inventory.getSpells().get(input);
          System.out.println("You chose " + selection.getName());
          if (selection.getPrice() <= activeHero.getMoney()) {
            if (selection.getMinLevel() <= activeHero.getLevel()) {
              LegendsSpell item = inventory.getSpells().remove(input);
              activeHero.accessInventory().addSpell(item);
              activeHero.updateMoney(-1 * selection.getPrice());
              System.out.println("Thank you for your purchase!");
            } else {
              System.out.println("This Hero is not ready for this item. You need more levels. ");
            }
          } else {
            System.out.println("This Hero is not ready for this item. You need more money.");
          }
        }
      } catch (Exception e) {
        System.out.println("Please input a valid int selection");
        in.nextLine();
      }
    }
  }

  public ItemType chooseCategory(LegendsHeroInventory activeInventory) {
    System.out.println("What would you like to look at?");
    while (true) {
      System.out.println("1. Weapons   2. Armor   3. Potions   4. Spells   0. Back");
      try {
        int input = in.nextInt();
        if (input == 1) {
          return ItemType.WEAPON;
        } else if (input == 2) {
          return ItemType.ARMOR;
        } else if (input == 3) {
          return ItemType.POTION;
        } else if (input == 4) {
          return ItemType.SPELL;
        } else if (input == 0) {
          return null;
        } else {
          System.out.println("Please input a valid value");
        }
      } catch (Exception e) {
        System.out.println("Please input a valid value");
        in.nextLine();
      }

    }

  }

  public void sellSequence(LegendsOfValor game) {

    System.out.println("Ooo, whatcha got?!?!");
    while (true) {
    	LegendsHero activeHero = game.player.chooseHero();
      if (activeHero == null) {
        break;
      }

      ItemType activeItems = chooseCategory(activeHero.accessInventory());
      if (activeItems == null) {
        break;
      }
      switch (activeItems) {
        case WEAPON:
          attemptSellWeapon(activeHero);
          break;
        case ARMOR:
          attemptSellArmor(activeHero);
          break;
        case POTION:
          attemptSellPotion(activeHero);
          break;
        case SPELL:
          attemptSellSpell(activeHero);
          break;

      }

    }
    System.out.println("Thanks for helping out the shop!");

  }

  public void attemptSellWeapon(LegendsHero activeHero) {
    while (true) {
      System.out.println("What would you like to part with? Input the corresponding int, or input -1 to go back.");
      activeHero.accessInventory().printWeapons();
      try {
        int input = in.nextInt();
        if (input == -1) {
          break;
        } else {
          LegendsWeapon selection = activeHero.accessInventory().getWeapons().get(input);
          System.out.println("You chose " + selection.getName() + ". Press Y to complete to transaction, or press anything else to go back.");
          in.nextLine();
          String confirm = in.nextLine();
          if (confirm.equalsIgnoreCase("Y")) {
            activeHero.updateMoney(selection.getPrice() / 2);
            inventory.addWeapon(activeHero.accessInventory().getWeapons().remove(input));
            System.out.println("Thank you for your purchase!");
          } else {
            System.out.println("That's okay, we all get cold feet sometimes.");
          }
        }
      } catch (Exception e) {
        System.out.println("Please input a valid int selection");
        in.nextLine();
      }
    }
  }

  public void attemptSellArmor(LegendsHero activeHero) {
    while (true) {
      System.out.println("What would you like to part with? Input the corresponding int, or input -1 to go back.");
      activeHero.accessInventory().printArmors();
      try {
        int input = in.nextInt();
        if (input == -1) {
          break;
        } else {
          LegendsArmour selection = activeHero.accessInventory().getArmors().get(input);
          System.out.println("You chose " + selection.getName() + ". Press Y to complete to transaction, or press anything else to go back.");
          in.nextLine();
          String confirm = in.nextLine();
          if (confirm.equalsIgnoreCase("Y")) {
            activeHero.updateMoney(selection.getPrice() / 2);
            inventory.addArmor(activeHero.accessInventory().getArmors().remove(input));
            System.out.println("Thank you for your purchase!");
          } else {
            System.out.println("That's okay, we all get cold feet sometimes.");
          }
        }
      } catch (Exception e) {
        System.out.println("Please input a valid int selection");
        in.nextLine();
      }
    }
  }

  public void attemptSellPotion(LegendsHero activeHero) {
    while (true) {
      System.out.println("What would you like to part with? Input the corresponding int, or input -1 to go back.");
      activeHero.accessInventory().printPotions();
      try {
        int input = in.nextInt();
        if (input == -1) {
          break;
        } else {
          LegendsPotion selection = activeHero.accessInventory().getPotions().get(input);
          System.out.println("You chose " + selection.getName() + ". Press Y to complete to transaction, or press anything else to go back.");
          in.nextLine();
          String confirm = in.nextLine();
          if (confirm.equalsIgnoreCase("Y")) {
            activeHero.updateMoney(selection.getPrice() / 2);
            inventory.addPotion(activeHero.accessInventory().getPotions().remove(input));
            System.out.println("Thank you for your purchase!");
          } else {
            System.out.println("That's okay, we all get cold feet sometimes.");
          }
        }
      } catch (Exception e) {
        System.out.println("Please input a valid int selection");
        in.nextLine();
      }
    }
  }

  
  public void attemptSellSpell(LegendsHero activeHero) {
    while (true) {
      System.out.println("What would you like to part with? Input the corresponding int, or input -1 to go back.");
      activeHero.accessInventory().printSpells();
      try {
        int input = in.nextInt();
        if (input == -1) {
          break;
        } else {
          LegendsSpell selection = activeHero.accessInventory().getSpells().get(input);
          System.out.println("You chose " + selection.getName()
              + ". Press Y to complete to transaction, or press anything else to go back.");
              in.nextLine();
          String confirm = in.nextLine();
          if (confirm.equalsIgnoreCase("Y")) {
            activeHero.updateMoney(selection.getPrice() / 2);
            inventory.addSpell(activeHero.accessInventory().getSpells().remove(input));
            System.out.println("Thank you for helpin us out!");
          } else {
            System.out.println("That's okay, we all get cold feet sometimes.");
          }
        }
      } catch (Exception e) {
        System.out.println("Please input a valid int selection");
        in.nextLine();
      }
    }
  }


  public void printActions() {
    String leftAlignFormat = "| %-15s | %-4s |%n";

    System.out.format("+------------------------+%n");
    System.out.format("|         ACTIONS        |%n");
    System.out.format("+-----------------+------+%n");
    System.out.format(leftAlignFormat, "SHOP", "1");
    System.out.format(leftAlignFormat, "SELL", "2");
    System.out.format(leftAlignFormat, "LEAVE", "0");
    System.out.format("+-----------------+------+%n");

  }

}