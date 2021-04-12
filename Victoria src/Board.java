import java.util.*;

public class Board {
    //board and marker held here
    //first create rows of cell strings
    ArrayList<Cell[]> rows;
    Cell columns[];
    int currentX= 7;
    int currentY=7;
    int currentSpotType=2;

    public Board() {
        //creating 8x8 board
        //ArrayList<Cell[]> rows= new ArrayList<Cell[]>();
        rows = new ArrayList<>();
        columns= new Cell[8];
        int[] types= {0,0,1,1,2,2,2,2};
        int rndPick;

        for (int rowNum=0; rowNum<8; rowNum++) {
            //shuffling types to create board of random cell spots, 50% open, 25% blocked, 25% markets
            //Collections.shuffle(Arrays.asList(types));
            columns= new Cell[8];
            for (int colNum =0; colNum<8; colNum++) {
                if (rowNum==7 && colNum==7) {
                    //prints player location
                    columns[colNum]= new Cell(3);
                } else if (rowNum==7) {
                    //whole first row will have open cells
                    columns[colNum]= new Cell(2);
                } else {
                    Random generator= new Random();
                    rndPick = generator.nextInt(types.length);
                    columns[colNum]= new Cell(types[rndPick]);
                }
            }
            rows.add(columns);
        }



    }

    //creating methods
    public static boolean makeMove(Board thisBoard, String movingTo) {
        //how player makes movements around the board
        Cell[] theRow;
        Cell theCol;
        int newRow;
        Cell newCell;

        //bad moves return true, good moves return false
        if (movingTo.equals("w") || movingTo.equals("W")) {
            //move up
            if (thisBoard.currentY == 0) {
                System.out.println("Cannot move up, at top of map already");
                return true;
            }

            newRow = thisBoard.currentY - 1;
            theRow = thisBoard.rows.get(newRow);
            theCol = theRow[thisBoard.currentX];
            if (theCol.type == 0) {
                //blocked cell type
                System.out.println("This cell is blocked, please choose a different direction.");
                return true;
            }

            //updating old cell to change to new
            if (thisBoard.currentSpotType==3) {
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].contains= "|   |";
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].type= 2;
            } else if (thisBoard.currentSpotType==2) {
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].contains= "|   |";
            } else if (thisBoard.currentSpotType==1) {
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].contains= "| M |";
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].type= 1;
            }

            thisBoard.currentY = thisBoard.currentY - 1;
            thisBoard.currentSpotType = theCol.type;
            thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].contains= "| & |";

            return false;
        } else if (movingTo.equals("a") || movingTo.equals("A")) {
            //move left
            if (thisBoard.currentX == 0) {
                System.out.println("Cannot move left, at side of map already");
                return true;
            }

            newRow = thisBoard.currentY;
            theRow = thisBoard.rows.get(newRow);
            theCol = theRow[thisBoard.currentX - 1];
            if (theCol.type == 0) {
                //blocked cell type
                System.out.println("This cell is blocked, please choose a different direction.");
                return true;
            }
            //updating old cell to change to new
            if (thisBoard.currentSpotType==3) {
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].contains= "|   |";
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].type= 2;
            } else if (thisBoard.currentSpotType==2) {
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].contains= "|   |";
            } else if (thisBoard.currentSpotType==1) {
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].contains= "| M |";
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].type= 1;
            }

            thisBoard.currentX = thisBoard.currentX - 1;
            thisBoard.currentSpotType = theCol.type;
            thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].contains= "| & |";
            return false;
        } else if (movingTo.equals("s") || movingTo.equals("S")) {
            //move down
            if (thisBoard.currentY == 7) {
                System.out.println("Cannot move down, at bottom of map already");
                return true;
            }

            newRow = thisBoard.currentY + 1;
            theRow = thisBoard.rows.get(newRow);
            theCol = theRow[thisBoard.currentX];
            if (theCol.type == 0) {
                //blocked cell type
                System.out.println("This cell is blocked, please choose a different direction.");
                return true;
            }

            //updating old cell to change to new
            if (thisBoard.currentSpotType==3) {
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].contains= "|   |";
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].type= 2;
            } else if (thisBoard.currentSpotType==2) {
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].contains= "|   |";
            } else if (thisBoard.currentSpotType==1) {
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].contains= "| M |";
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].type= 1;
            }

            thisBoard.currentY = thisBoard.currentY + 1;
            thisBoard.currentSpotType = theCol.type;
            thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].contains= "| & |";

            return false;
        } else if (movingTo.equals("d") || movingTo.equals("D")) {
            //move right
            if (thisBoard.currentY == 7) {
                System.out.println("Cannot move right, at side of map already");
                return true;
            }

            newRow = thisBoard.currentY;
            theRow = thisBoard.rows.get(newRow);
            theCol = theRow[thisBoard.currentX + 1];
            if (theCol.type == 0) {
                //blocked cell type
                System.out.println("This cell is blocked, please choose a different direction.");
                return true;
            }

            //updating old cell to change to new
            if (thisBoard.currentSpotType==3) {
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].contains= "|   |";
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].type= 2;
            } else if (thisBoard.currentSpotType==2) {
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].contains= "|   |";
            } else if (thisBoard.currentSpotType==1) {
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].contains= "| M |";
                thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].type= 1;
            }

            thisBoard.currentX = thisBoard.currentX + 1;
            thisBoard.currentSpotType = theCol.type;
            thisBoard.rows.get(thisBoard.currentY)[thisBoard.currentX].contains= "| & |";
            return false;
        } else {
            return true;
        }
    }



    public static void getCellType(int theRow, int theColumn,Board thisBoard) {
        //getting type of new cell on board, either market, open, or blocked



    }

    public static void printBoard(Board thisBoard) {
        for (int p=0; p<8;p++) {
            for (int m=0; m<8; m++) {
                Cell[] printing= thisBoard.rows.get(p);
                Cell printed = printing[m];
                if (m==0) {
                    System.out.print("\n");
                }
                System.out.print(printed.contains);
            }
        }
    }


    //checks that input is valid choice or quits
    public static boolean validInput(String inputting) {
        //making sure user input is valid
        if (inputting=="w" || inputting=="W" || inputting=="s" || inputting=="S" || inputting =="A"|| inputting =="a") {
            return true;
        } else if(inputting=="d" || inputting=="d" || inputting=="info" || inputting=="map"|| inputting =="1"|| inputting=="2" ||inputting =="3") {
            return true;
        } else if (inputting== "q" || inputting=="Q") {
            System.out.println("Quitting game");
            System.exit(0);
            return false;
        }else {
            return false;
        }
    }



}
