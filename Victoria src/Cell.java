public class Cell {
    //market, open, or blocked cells
    public String contains;
    public int type;


    public Cell(int cellType) {
        if (cellType == 0) {
            //blocked type
            type = 0;
            contains = "| B |";
        } else if (cellType == 1) {
            //market access type cell
            type = 1;
            contains = "| M |";
        } else if (cellType == 2) {
            //open cell, maybe fight or maybe safe
            type = 2;
            contains = "|   |";
        } else if  (cellType == 3) {
            //player location
            type = 3;
            contains = "| & |";
        }
    }
}
