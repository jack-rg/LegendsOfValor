import java.util.ArrayList;
import java.util.Scanner;

public class Legends extends Game{
    //Main class for running legends game
    public static void main(String[] args) { startGame(); }

    public static void startGame() {
        Scanner scan= new Scanner(System.in);
        ArrayList<Monsters> spawnedMonsters;

        // Initializing variables
        String numHeroes=" ";
        String typeHero = " ";
        String nameHero= "";
        String move= " ";
        String enterMarket= " ";
        String chooseShoppingHero= " ";
        String shopOrSell= " ";
        int nameHeroInt=1;
        int highestHeroLevel;
        double willWeFight=0;
        boolean inMarket=true;
        boolean fighting=true;
        boolean valid =true;
        boolean valid2=true;
        Monsters monster1;
        Monsters monster2;
        Monsters monster3;

        Heroes fighter1=null;
        Heroes fighter2=null;
        Heroes fighter3=null;

        System.out.println("Welcome to Legends!\n" +
                "You can quit by entering q at any time\n" +
                "You can move around the world by using the WASD/wasd keys\n" +
                "You can view the map at any time by entering 'map' \n" +
                "You may display hero info at any time by entering i/I \n" +
                "Let's start by entering how many heroes you would like to use");

        while (valid) {
            System.out.println("You must enter between 1 and 3 heroes");
            numHeroes= scan.nextLine();
            if (numHeroes.equals("1") || numHeroes.equals("2") ||numHeroes.equals("3")) {
                valid=false;
            } else if (numHeroes.equals("q") || numHeroes.equals("Q")) {
                //quitting game
                System.out.println("Quitting game");
                return;
            }
        }
        System.out.println("You chose to start with " + numHeroes +" Heroes!");

        //taking num of heroes from input
        int num = Integer.parseInt(numHeroes);

        for (int i =1; i<num+1; i++ ) {
            //setting up all heroes
            valid=true;
            valid2=true;
            while (valid) {
                System.out.println("What type do you want hero " + i + " to be?");
                System.out.println("Enter 1 for a Warrior, enter 2 for a Sorcerer, enter 3 for a Paladin.");
                typeHero= scan.nextLine();

                if (typeHero.equals("1")) {
                    while (valid2) {
                        System.out.println("Which Warrior would you like to fight with?\n" +
                                "enter integer next to hero name you want to use\n" +
                                "   Name               mana  strength agility dexterity  starting money starting experience\n" +
                                "(1) Gaerdal_Ironhand    100     700     500     600            1354            7\n" +
                                "(2) Sehanine_Monnbow    600     700     800     500            2500            8\n" +
                                "(3) Muamman_Duathall    300     900     500     750            2546            6\n" +
                                "(4) Flandal_Steelskin   200     750     650     700            2500            7\n" +
                                "(5) Undefeated_Yoj      400     800     400     700            2500            7\n" +
                                "(6) Eunoia_Cyn          400     700     800     600            2500            6");
                        nameHero= scan.nextLine();
                        if (nameHero.equals("1")|| nameHero.equals("2") ||nameHero.equals("3") || nameHero.equals("4") || nameHero.equals("5")|| nameHero.equals("6")) {
                            valid2=false;
                            valid=false;

                        } else if (nameHero.equals("q") || nameHero.equals("Q")) {
                            System.out.println("Quitting game");
                            return;
                        }
                    }

                    valid=false;
                } else if (typeHero.equals("2")) {
                    while (valid2) {
                        System.out.println("Which Sorcerer would you like to fight with?\n" +
                                "enter integer next to hero name you want to use\n" +
                                "Name                     mana    strength agility dexterity starting money starting experience\n" +
                                "(1)Rillifane_Rallathil     1300    750     450     500             2500        9\n" +
                                "(2)Segojan_Earthcaller     900     800     500     650             2500        5\n" +
                                "(3)Reign_Havoc             800     800     800     800             2500        8\n" +
                                "(4)Reverie_Ashels          900     800     700     400             2500        7\n" +
                                "(5)Kalabar                 800     850     400     600             2500        6\n" +
                                "(6)Skye_Soar               1000    700     400     500             2500        5");
                        nameHero = scan.nextLine();
                        if (nameHero.equals("1") || nameHero.equals("2") || nameHero.equals("3") || nameHero.equals("4") || nameHero.equals("5") || nameHero.equals("6")) {
                            valid2 = false;
                            valid=false;
                        } else if (nameHero.equals("q") || nameHero.equals("Q")) {
                            System.out.println("Quitting game");
                            return;
                        }
                    }

                } else if (typeHero.equals("3")) {
                    while (valid2) {
                        System.out.println("Which Paladin would you like to fight with?\n" +
                                "enter integer next to hero name you want to use\n" +
                                "Name                   mana  strength agility dexterity starting money starting experience\n" +
                                "(1)Parzival             300     750     650     700     2500           7\n" +
                                "(2)Sehanine_Moonbow     300     750     700     700     2500           7\n" +
                                "(3)Skoraeus_Stonebones  250     650     600     350     2500           4\n" +
                                "(4)Garl_Glittergold     100     600     500     400     2500           5\n" +
                                "(5)Amaryllis_Astra      500     500     500     500     2500           5\n" +
                                "(6)Caliber_Heist        400     400     400     400     2500           8");
                        nameHero = scan.nextLine();
                        if (nameHero.equals("1") || nameHero.equals("2") || nameHero.equals("3") || nameHero.equals("4") || nameHero.equals("5") || nameHero.equals("6")) {
                            valid2 = false;
                            valid=false;
                        } else if (nameHero.equals("q") || nameHero.equals("Q")) {
                            System.out.println("Quitting game");
                            System.exit(0);
                            return;
                        }
                    }

                } else if (typeHero.equals("q") || typeHero.equals("Q")) {
                    //quitting game
                    System.out.println("Quitting game");
                    System.exit(0);
                    return;
                }

            }
            //typeHero and nameHero hold choices for fighters
            //num= typeHero int, nameHeroInt
            //initialized fighters
            nameHeroInt= Integer.parseInt(nameHero);
            if (i==1) {
                fighter1= Heroes.getHeroes(num,nameHeroInt);
            } else if (i==2) {
                fighter2= Heroes.getHeroes(num, nameHeroInt);
            } else if (i==3) {
                fighter3= Heroes.getHeroes(num, nameHeroInt);
            }
        }

        //created fighters for player, printing board next
        Board gameBoard = new Board();


        boolean playing= true;
        boolean choice= true;

        while (playing) {
            //loop for moving and playing game after initializing

            Board.printBoard(gameBoard);
            choice=true;

            //choosing next move
            while (choice) {
                System.out.println("\n");
                System.out.println("Please enter where you would like to move, the '&' shows your current position");
                move= scan.nextLine();
                if (move.equals("q")|| move.equals("Q")) {
                    System.out.println("Quitting game");
                    System.exit(0);
                }
                choice= Board.validInput(move);
            }

            if (move.equals("map")) {
                Board.printBoard(gameBoard);
            } else if (move.equals("info")) {
                //print hero info/stats, heroes method
                //if hero exists, print stats
                Heroes.printStat(fighter1);
                if (fighter2!= null) {
                    Heroes.printStat(fighter2);
                }
                if (fighter3!=null) {
                    Heroes.printStat(fighter3);
                }

            } else {
                //movement of piece on board, will return with updated board
                choice=true;
                while(choice){
                    choice= Board.makeMove(gameBoard, move);
                    if (choice==true) {
                        System.out.println("Invalid move, please enter a different move, either W, A, S or D");
                        move= scan.nextLine();
                    }

                }

            }

            //board has been updated, checking type of spot player is in
            if (gameBoard.currentSpotType == 1) {
                //player is on a market, may shop
                Board.printBoard(gameBoard);
                System.out.println(" ");
                System.out.println("Hello! You have entered a market space.");
                choice=true;
                while(choice) {
                    System.out.println("Would you like to enter the market?\n" +
                            "(1) yes\n" +
                            "(2) no");
                    enterMarket= scan.nextLine();
                    if (enterMarket.equals("1") || enterMarket.equals("2")) {
                        choice= false;
                    }
                }

                //for market entry
                if (enterMarket.equals("1")) {
                    //start market shopping, large loop for all purchases and selling
                    inMarket=true;
                    while(inMarket) {
                        choice=true;
                        while (choice) {
                            System.out.println("Which hero would you like to shop/sell for?");
                            System.out.println("(1) "+ fighter1.name +" hero Level: " + fighter1.heroLevel + " health points: " + fighter1.hp + " money: " + fighter1.money);
                            if (fighter2!= null) {
                                System.out.println("(2) "+ fighter2.name +" hero Level: " + fighter2.heroLevel + " health points: " + fighter2.hp + "money: " + fighter2.money);
                            }
                            if (fighter3!=null) {
                                System.out.println("(3) "+ fighter3.name +" hero Level: " + fighter3.heroLevel + " health points: " + fighter3.hp + "money: " + fighter3.money);
                            }
                            System.out.println("(4) Done shopping");
                            chooseShoppingHero= scan.nextLine();
                            if (chooseShoppingHero.equals("1") || chooseShoppingHero.equals("2") || chooseShoppingHero.equals("3")) {
                                choice=false;
                            } else {
                                //exit market
                                System.out.println("Exiting market.");
                                choice=false;
                                break;
                            }
                        }

                        if (!chooseShoppingHero.equals("1") && !chooseShoppingHero.equals("2") && !chooseShoppingHero.equals("3")) {
                            System.out.println("Exiting market, continuing game.");
                            choice=false;
                            inMarket=false;
                            continue;
                        }
                        //in market, player has chosen a hero to work with
                        choice=true;
                        while (choice) {
                            System.out.println("What would you like to do?\n" +
                                    "(1) Buy\n" +
                                    "(2) Sell\n");
                            shopOrSell= scan.nextLine();
                            if (shopOrSell.equals("1") || shopOrSell.equals("2")) {
                                choice=false;
                            }else if (shopOrSell.equals("q")|| shopOrSell.equals("Q")) {
                                System.out.println("Quitting game.");
                                System.exit(0);
                            }
                        }
                        //sends corresponding hero for purchase or selling items
                        if (shopOrSell.equals("1")) {
                            //start buying method
                            if (chooseShoppingHero.equals("1")) {
                                //send fighter1
                                Inventory.shopping(fighter1);
                            } else if (chooseShoppingHero.equals("2")) {
                                //send fighter2
                                Inventory.shopping(fighter2);
                            } else if(chooseShoppingHero.equals("3")) {
                                //send fighter3
                                Inventory.shopping(fighter3);
                            }
                        } else {
                            //start selling method
                            if (chooseShoppingHero.equals("1")) {
                                //send fighter1
                                Inventory.selling(fighter1);
                            } else if (chooseShoppingHero.equals("2")) {
                                //send fighter2
                                Inventory.selling(fighter2);
                            } else if(chooseShoppingHero.equals("3")) {
                                //send fighter3
                                Inventory.selling(fighter3);
                            }
                        }

                    }

                } else if (enterMarket.equals("q")) {
                    System.out.println("Quitting game.");
                    System.exit(0);
                } else {
                        //continue if not entering market
                        System.out.println("Exiting market, continuing game");
                        continue;
                }

            } else if (gameBoard.currentSpotType==2) {
                //player on an open cell, may have to fight or be safe
                willWeFight= Math.random();
                //30% chance of being in a fight

                if (willWeFight<=.3) {
                    //start fight
                    System.out.println(ANSI_RED + "Monsters are approaching you here!! You must fight to move on!" + ANSI_RESET);

                    highestHeroLevel=1;
                    //using highestHeroLevel to determine level of the monsters
                    if (fighter1.heroLevel> highestHeroLevel) {
                        highestHeroLevel= fighter1.heroLevel;
                    }
                    if (fighter2!=null && fighter2.heroLevel>highestHeroLevel) {
                        highestHeroLevel= fighter2.heroLevel;
                    }
                    if (fighter3!=null && fighter3.heroLevel>highestHeroLevel) {
                        highestHeroLevel= fighter3.heroLevel;
                    }
                    //integer 'num' is number of monsters that should be spawned, equal to number of heroes
                    //new Monsters monster1;


                    //spawnedMonsters= new ArrayList<>();
                    //spawnedMonsters.add();



                    fighting=true;
                    while(fighting) {

                    }


                } else{
                    //no fight, continue
                    System.out.println("You are in a safe space this time!\n" +
                            "Continuing the game.");
                }


            } else if (gameBoard.currentSpotType==3) {
                //player is on spawning spot, will not start a fight
            }


        }



    }

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";


}
