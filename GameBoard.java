import java.util.Scanner;
import java.util.ArrayList;

public class GameBoard {
  Piece[][] board;
  int dimension = 8; // the width and height of the board
  private static final int INVALID_POS = -1;  // invalid board position
  private static final int EMPTY_POS = 0;     // empty board position
  private static final int PLAYER_ONE = 1;
  private static final int PLAYER_TWO = 2;

  /**
   * future --> Later this may take in a dimension for board size.
   * name: setupBoard()
   * description: Allocates and initializes memory for the board object.
   */
  public void setupBoard() {
    board = new Piece[dimension][dimension]; // create memory for board

    /* Initialize */

    /*
     * Rows zero through two - Alternate between player one's number and
     * invalid board position markers
     */
    int team = -1;
    for(int row = 0; row < 3; row++) {
      for(int col = 0; col < dimension; col++) {
        board[row][col] = new Piece(row, col, team);
        team *= -1; // Next board position should be the negative of previous
      }
      team *= -1;
    }

    /*
     * Rows three through four - Alternate between empty space and invalid
     * board position markers
     */
    int ticker = 0; // To flip between each board position's marker
    for(int row = 3; row < 5; row++) {
      for(int col = 0; col < dimension; col++) {
        if(ticker % 2 == 0) {
          team = EMPTY_POS;
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

        System.out.print(" "); // Print a space between each Piece
      }
      System.out.println(); // Print each row on a new line
    }

  } // end displayBoard

  /**
   * name: selectPiece
   * description: Asks the user to input a board position and ensures that
   *              position contains a piece belonging to that player.
   */
  public Piece selectPiece(int playersTeam) {
    Scanner sc = new Scanner(System.in); // Grab input from the user
    int teamChoice = 0; // Team of piece chosen by user
    int row; // Row of piece chosen
    int col; // Column of piece chosen

    // Prompt the user until they chose a piece on their team
    while(teamChoice != playersTeam) {
      System.out.println("Enter the position of the piece you want to move:");

      row = sc.nextInt();
      col = sc.nextInt();

      teamChoice = board[row][col].getTeam();

      if(teamChoice != playersTeam) {
        System.out.println("That is not your piece!\n");
      } else {
        return board[row][col]; // Return the player's piece
      }
    }

    return new Piece(-1,-1,-1); // TODO Invalid piece - find a better way to do
    // this than returning some bogus piece. rework logic
  }

  /**
   * name: movePiece
   * description: Move a given piece to a location the player chooses
   *
   * plan: TODO 
   */
  public void movePiece(Piece mover) {
    ArrayList<Pair> validLocs = new ArrayList<Pair>();
    int row = mover.getLoc().getX(); // row and col location of piece to be moved
    int col = mover.getLoc().getY();

    if(mover.getTeam() == PLAYER_ONE) {
      // spaceA is down and left of any piece player 1 wants to move
      int spaceARow = row + 1; // row of spaceA
      int spaceACol = col - 1; // column of spaceA

      // spaceB is down and right of any piece player 1 wants to move
      int spaceBRow = row + 1; // row of spaceB
      int spaceBCol = col + 1; // column of spaceB

      // check if position given is within board boundaries
      if(Utils.inRange(spaceARow, 0, dimension) &&
         Utils.inRange(spaceACol, 0, dimension)) {

        // if position is empty, add as a valid location to move the piece
        if(board[spaceARow][spaceACol].getTeam() == EMPTY_POS) {

          validLocs.add(new Pair(spaceARow, spaceACol); 
        } else if(board[spaceA.getX()][spaceA.getY()].getTeam() == PLAYER_TWO) { 
          if(board[spaceA.getX
          // if the position holds a piece of the opposite team,
        //we need to check behind the piece for an empty position to jump to

        }
      }
      
      if(Utils.inRange(spaceB.getX(), 0, dimension) &&
         Utils.inRange(spaceB.getY(), 0, dimension)) {

        if(board[spaceB.getX()][spaceB.getY()].getTeam() == EMPTY_POS) {
          validLocs.add(spaceB);
        } else if( ) { //check for opposing player's piece

        }
      }

        System.out.println("Valid locations");
        for(int i = 0; i < 2; i++) {
          System.out.println("\n\n" + validLocs.get(i).getX() + ", " + 
                              validLocs.get(i).getY());
        }
      

    } else if(mover.getTeam() == PLAYER_TWO) {

    }
  }

  /* 
   * TODO movement -> relies on selecting a piece and choosing where to move
   * it. method written in here and called from Checkers class.
   */

  /* 
   * make its own class. won't need to pass the board around to everything.
   * methods: makeBoard, displayBoard, selectPiece(int player 1 or 2), movePiece
   */

}
