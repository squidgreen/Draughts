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
   * description: Print the current board to stdout row by row, space separated
   */
  public void displayBoard() {
    System.out.print("   "); // 3 spaces of padding for column numbers
    for(int k = 0; k < DIMENSION; k++) {
      System.out.print("  " + k); // 2 spaces in between each column number
    }
    System.out.println();

    for(int i = 0; i < DIMENSION; i++) {
      System.out.print("[" + i + "] ");
      for(int j = 0; j < DIMENSION; j++) {
        int val = board[i][j]; // value of current piece

        if(val >= 0) { // non-negative numbers are preceded with a space
          System.out.print(" " + val);
        } else {
          System.out.print(val);
        }

        if(j < 7) {
          System.out.print(" ");
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

  /*
   * name: selectLocation
   * description: The location to move a previously selected piece.
   * parameters: int row/int col - the row and col of the pieces original
   *             location
   */
  public boolean selectLocation(int row, int col) {
    System.out.println("Enter the coordinates of where to move the piece:");

    Scanner input = new Scanner(System.in);
    int moveRow = input.nextInt();
    int moveCol = input.nextInt();
    
    board[moveRow][moveCol] = board[row][col]; // fill new space with old value
    board[row][col] = 0; // mark previous space as empty

    return true;
  }

} // end GameBoard class
