import java.util.Scanner;

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
    System.out.print("  ");
    for(int k = 0; k < DIMENSION; k++) {
//      System.out.print(" [" + k + "]");
    }
    System.out.println();

    for(int i = 0; i < DIMENSION; i++) {
      System.out.print("[" + i + "] ");
      for(int j = 0; j < DIMENSION; j++) {
        System.out.print("[" + board[i][j] + "]");

        if(j < 7) {
          System.out.print(", ");
        }
      }
      System.out.println(); // print each row on a new line
    }

  } // end displayBoard

  /*
   * name: selectPiece -- eventually selectPiece(int player)
   * description: Allows the specified player to select a piece to move.
   */
  public boolean selectPiece() {
    System.out.println("Enter the coordinates of a piece to move:");

    Scanner input = new Scanner(System.in);
    int row = input.nextInt();
    int col = input.nextInt();

    // compare int at given position in grid to player's number
    System.out.println("Piece selected belongs to player " + board[row][col]);

    return true;
  }

} // end GameBoard class
