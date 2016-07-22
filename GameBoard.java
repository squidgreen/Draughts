public class GameBoard {
  private int[][] board;
  private static final int DIMENSION = 8;

  /* 
   * make its own class. won't need to pass the board around to everything.
   * methods: makeBoard, displayBoard, selectPiece(int player 1 or 2), movePiece
   */

  public GameBoard() {
    makeBoard(); // Make a board
  }

  /*
   * name: makeBoard
   * description: Initializes the checkers board
   * TODO: later add an input parameter that allows for different board sizes
   */
  public void makeBoard() {
    board = new int[][] {
      {-1, 1, -1, 1, -1, 1, -1, 1},
      {1, -1, 1, -1, 1, -1, 1, -1},
      {-1, 1, -1, 1, -1, 1, -1, 1},
      {0, -1, 0, -1, 0, -1, 0, -1},
      {-1, 0, -1, 0, -1, 0, -1, 0},
      {2, -1, 2, -1, 2, -1, 2, -1},
      {-1, 2, -1, 2, -1, 2, -1, 2},
      {2, -1, 2, -1, 2, -1, 2, -1},
    };
  }

  /*
   * name: displayBoard
   * description: Print the current board to stdout row by row, comma separated
   */
  public void displayBoard() {

    for(int i = 0; i < DIMENSION; i++) {
      System.out.print(" ");
      for(int j = 0; j < DIMENSION; j++) {
        System.out.print(board[i][j]);

        if(j < 7) {
          System.out.print(", ");
        }
      }
      System.out.println(); // print each row on a new line
    }

  }

} // end GameBoard class
