public class GameBoard {
  Piece[][] board;
  int dimension = 2; // the width and height of the board

  /*
   * future --> Later this may take in a dimension for board size.
   */
  public void setupBoard() {
    board = new Piece[][] {
      {new Piece(0,0,1), new Piece(1,1,1)},
      {new Piece(2,2,2), new Piece(3,3,2)}
    };
  }

  public void displayBoard() {
    for(int row = 0; row < dimension; row++) { // we pick a row...
      for(int col = 0; col < dimension; col++) { // then go through each column
        System.out.print(board[row][col].getTeam() + " "); // print team number
      }
      System.out.println();
    }
  }

  /* 
   * make its own class. won't need to pass the board around to everything.
   * methods: makeBoard, displayBoard, selectPiece(int player 1 or 2), movePiece
   */

}
