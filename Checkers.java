import java.util.Scanner;

public class Checkers {

  public static void main(String [] args) {
    GameBoard gameBoard = new GameBoard();
    
    gameBoard.displayBoard();

    gameBoard.selectPiece();
    gameBoard.selectLocation();
   /* 
    int[][] gameBoard = 
    {
      {-1, 1, -1, 1, -1, 1, -1, 1},
      {1, -1, 1, -1, 1, -1, 1, -1},
      {-1, 1, -1, 1, -1, 1, -1, 1},
      {0, -1, 0, -1, 0, -1, 0, -1},
      {-1, 0, -1, 0, -1, 0, -1, 0},
      {2, -1, 2, -1, 2, -1, 2, -1},
      {-1, 2, -1, 2, -1, 2, -1, 2},
      {2, -1, 2, -1, 2, -1, 2, -1},
    };
    */

    //displayBoard(gameBoard);
  } // end of main

  /*
   * Name: displayBoard
   * Description: Prints out the current board row by row
   */
  public static void displayBoard(int[][] gameBoard) {
    for(int i = 0; i < 8; i++) {
      for(int j = 0; j < 8; j++) {
        if(j < 7) {
          System.out.print(gameBoard[i][j] + ", ");
        } else {
          System.out.print(gameBoard[i][j]);
        }
      }
      System.out.println(); // newline after each array is printed
    }
  }

  public static void selectPiece(int player) {
    // prompt user
    System.out.println("Please enter the position of the piece to move:");

    Scanner sc = new Scanner(System.in); // grab user input
    int row = sc.nextInt();
    int col = sc.nextInt();

  }

}
