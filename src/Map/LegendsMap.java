package Map;

public class LegendsMap {
	public Place[][] map;
	public Place currCell;
	public Token teamToken;
	public int mapDimen;
	public int totalCells;
	public int currRow;
	public int currCol;

	public Map(int mapDimen, Token teamToken){
	    this.mapDimen = mapDimen;
	    totalCells = mapDimen*mapDimen;
	    this.teamToken = teamToken;
	    initBoard();
	    
	    
	  }

	public int getMapDimen() {
		return mapDimen;
	}

	public void initBoard() {
		map = new Place[mapDimen][mapDimen];
		currRow = 1;
		currCol = 1;
		for (int r = 0; r < mapDimen; r++) {
			for (int c = 0; c < mapDimen; c++) {
				Place p = generateLocation(r, c);
				map[r][c] = p;
			}
		}
		currCell = map[currRow][currCol];
		currCell.setActive(true);
	}

	public void updateBoard(int nextRow, int nextCol) {
		currCell.setActive(false);
		currRow = nextRow;
		currCol = nextCol;
		currCell = map[nextRow][nextCol];
		currCell.setActive(true);
	}

	public Place generateLocation(int r, int c) {
		double rng = Math.random() * 10;
		if (rng > 5) {
			return new Path(r, c, teamToken);
		} else if (rng > 2) {
			return new Market(r, c, teamToken);
		} else {
			return new Nature(r, c, teamToken);
		}
	}

	public Place getCurrCell() {
		return currCell;
	}

	public Place getCell(int row, int col) {
		return map[row][col];
	}

	// Print out board in nice fashion
	public void print() {
		for (int i = 0; i < mapDimen; i++) {
			System.out.print("+-----");
		}
		System.out.println("+");
		for (int row = 0; row < mapDimen; row++) {
			System.out.print("| ");
			for (int col = 0; col < mapDimen; col++) {
				if (map[row][col].isActive()) {
					map[row][col].printActiveToken();
				} else {
					map[row][col].printRegToken();
				}
				System.out.print(" | ");
			}
			System.out.println("");
			if (row < mapDimen) {
				System.out.print("+");
				for (int i = 0; i < mapDimen; i++) {
					System.out.print("-----+");
				}
			}
			System.out.println("");
		}
	}
}