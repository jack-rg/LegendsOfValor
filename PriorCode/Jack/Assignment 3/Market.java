import java.io.File;
import java.util.*;

public class Market extends Place {
  public Inventory inventory;

  public Market(int row, int col, Token teamToken) {
    super(row, col, true, Location.MARKET, new Token("i^i"), teamToken);
    inventory = new Inventory();
    loadItems(3);
  }

  public void loadItems(int numRequestedItems) {

    String[] params = new String[0];
    for (int i = 0; i < numRequestedItems; i++) {
      
      params = initItems(new File("Additionals/Weaponry.txt"));
      inventory.addWeapon(new Weapon(params));

      params = initItems(new File("Additionals/Armory.txt"));
      inventory.addArmor(new Armor(params));

      params = initItems(new File("Additionals/Spells.txt"));
      inventory.addSpell(new Spell(params));

      params = initItems(new File("Additionals/Potions.txt"));
      inventory.addPotion(new Potion(params));

    }
  }

  public String[] initItems(File file) {
    try {
      List<String> lines = readLines(file);
      lines.remove(0); // remove header
      Random random = new Random();
      String[] parameters = lines.get(random.nextInt(lines.size())).split("\\s+");
      return parameters;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  public ArrayList<String> readLines(File file) {
    try {
      ArrayList<String> l = new ArrayList<String>();
      Scanner input = new Scanner(file);
      while (input.hasNextLine()) {
        l.add(input.nextLine());
      }
      input.close();
      return l;
    } catch (Exception e) {
      System.out.println("File not found");
      return null;
    }
  }

  public void activatePlace(RPG game) {
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

  public void attemptPurchasePotion(Hero activeHero) {
    while (true) {
      System.out.println("What would you like to purchase? Input the corresponding int, or input -1 to go back.");
      inventory.printPotions();
      try {
        int input = in.nextInt();
        if (input == -1) {
          break;
        } else {
          Potion selection = inventory.getPotions().get(input);
          System.out.println("You chose " + selection.getName());
          if (selection.getPrice() <= activeHero.getMoney()) {
            if (selection.getMinLevel() <= activeHero.getLevel()) {
              Potion item = inventory.getPotions().remove(input);
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

  public void attemptPurchaseSpell(Hero activeHero) {
    while (true) {
      System.out.println("What would you like to purchase? Input the corresponding int, or input -1 to go back.");
      inventory.printSpells();
      try {
        int input = in.nextInt();
        if (input == -1) {
          break;
        } else {
          Spell selection = inventory.getSpells().get(input);
          System.out.println("You chose " + selection.getName());
          if (selection.getPrice() <= activeHero.getMoney()) {
            if (selection.getMinLevel() <= activeHero.getLevel()) {
              Spell item = inventory.getSpells().remove(input);
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

  public ItemType chooseCategory(Inventory activeInventory) {
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

  public void sellSequence(RPG game) {

    System.out.println("Ooo, whatcha got?!?!");
    while (true) {
      Hero activeHero = game.player.chooseHero();
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

  public void attemptSellWeapon(Hero activeHero) {
    while (true) {
      System.out.println("What would you like to part with? Input the corresponding int, or input -1 to go back.");
      activeHero.accessInventory().printWeapons();
      try {
        int input = in.nextInt();
        if (input == -1) {
          break;
        } else {
          Weapon selection = activeHero.accessInventory().getWeapons().get(input);
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

  public void attemptSellArmor(Hero activeHero) {
    while (true) {
      System.out.println("What would you like to part with? Input the corresponding int, or input -1 to go back.");
      activeHero.accessInventory().printArmors();
      try {
        int input = in.nextInt();
        if (input == -1) {
          break;
        } else {
          Armor selection = activeHero.accessInventory().getArmors().get(input);
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

  public void attemptSellPotion(Hero activeHero) {
    while (true) {
      System.out.println("What would you like to part with? Input the corresponding int, or input -1 to go back.");
      activeHero.accessInventory().printPotions();
      try {
        int input = in.nextInt();
        if (input == -1) {
          break;
        } else {
          Potion selection = activeHero.accessInventory().getPotions().get(input);
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

  
  public void attemptSellSpell(Hero activeHero) {
    while (true) {
      System.out.println("What would you like to part with? Input the corresponding int, or input -1 to go back.");
      activeHero.accessInventory().printSpells();
      try {
        int input = in.nextInt();
        if (input == -1) {
          break;
        } else {
          Spell selection = activeHero.accessInventory().getSpells().get(input);
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