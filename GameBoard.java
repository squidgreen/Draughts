public class GameBoard {
  Piece[][] board;
  int dimension = 8; // the width and height of the board
  private static final int INVALID_POS = -1; // invalid board position

  /*
  public void setupBoard() {
    board = new Piece[][] {
      {new Piece(0, 0, -1), new Piece(0, 1, 1), new Piece(0, 2, -1), 
       new Piece(0, 3, 1), new Piece(0, 4, -1), new Piece(0, 5, 1), 
       new Piece(0, 6, -1), new Piece(0, 7, 1)},
      {new Piece(1, 0, 1), new Piece(1, 1, -1), new Piece(1, 2, 1)
       new Piece(1, 3, -1), new Piece(1, 4, 1), new Piece(1, 5, -1),
       new Piece(1, 6, 1), new Piece(1, 7, -1)},
      {new Piece(2, 0, -1), new Piece(2, 1, 1), new Piece(2, 2, -1),
       new Piece(2, 3, 1), new Piece(2, 4, -1), new Piece(2, 5, 1),
       new Piece(2, 6, -1), new Piece(2, 7, 1)},
      {new Piece(3, 0, 0), new Piece(3, 1, -1), new Piece(3, 2, 0),
       new 
    };
  }
  */

  /*
   * future --> Later this may take in a dimension for board size.
   * name: setupBoard()
   * description: Allocates and initializes memory for the board object.
   */
  public void setupBoard() {
    board = new Piece[dimension][dimension]; // create memory for board

    /* Initialize */

    // Rows zero through two - Alternate between player one's number and
    // invalid board position markers
    int team = -1;
    for(int row = 0; row < 3; row++) {
      for(int col = 0; col < dimension; col++) {
        board[row][col] = new Piece(row, col, team);
        team *= -1; // Next board position should be the negative of previous
      }
      team *= -1;
    }

    // Rows three through four - Alternate between empty space and invalid
    // board position markers
    int ticker = 0; // 
    for(int row = 3; row < 5; row++) {
      for(int col = 0; col < dimension; col++) {
        if(ticker % 2 == 0) {
          team = 0;
        } else {
          team = INVALID_POS;
        }
        board[row][col] = new Piece(row, col, team);
        ticker++; // alternate ticker for next board position
      }
      ticker++; // increment once more so that the next row starts at -1, not 0
    }

    /* 
     * Rows five through seven - Alternate between player two's number and
     * invalid board position markers
     */
    ticker = 0; // reset ticker to start Piece's with player two's number
    for(int row = 5; row < dimension; row++) {
      for(int col = 0; col < dimension; col++) {
        if(ticker % 2 == 0) {
          team = 2;
        } else {
          team = INVALID_POS;
        }
        board[row][col] = new Piece(row, col, team);
        ticker++; // alternate ticker for next board position
      }
      ticker++; // increment ticker once more so that next row repeats last num
    }
  }

  /*
   * name: displayBoard
   * description: Print the current board to stdout row by row, space separated
   */
  public void displayBoard() {
    System.out.print("   "); // Three spaces of padding for column numbers
    for(int k = 0; k < dimension; k++) {
      System.out.print("  " + k); // Two spaces in between each column number    
    }
    System.out.println();

    for(int row = 0; row < dimension; row++) { // we pick a row...
      System.out.print("[" + row + "] ");
      for(int col = 0; col < dimension; col++) { // then go through each column
        int val = board[row][col].getTeam(); // Current Piece's team number
        
        if(val >= 0) { // non-negative numbers are preceded with a space
          System.out.print(" " + val);
        } else {
          System.out.print(val);
        }

        System.out.print(" "); // TODO find out what this is for haha
        //System.out.print(board[row][col].getTeam() + " "); // print team number
      }
      System.out.println(); // Print each row on a new line
    }

  } // end displayBoard

  /* 
   * make its own class. won't need to pass the board around to everything.
   * methods: makeBoard, displayBoard, selectPiece(int player 1 or 2), movePiece
   */

}
