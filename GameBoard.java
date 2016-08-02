public class GameBoard {
  Piece[][] board;

  /*
   * future --> Later this may take in a dimension for board size.
   */
  public void setupBoard() {
    board = new Piece[][] {
      {new Piece(0,0,1), new Piece(1,1,1)},
      {new Piece(2,2,2), new Piece(3,3,2)}
    };
  }

  /* 
   * make its own class. won't need to pass the board around to everything.
   * methods: makeBoard, displayBoard, selectPiece(int player 1 or 2), movePiece
   */

}
