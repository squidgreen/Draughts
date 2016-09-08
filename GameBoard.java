import java.util.Scanner;
import java.util.ArrayList;

public class GameBoard {
  Piece[][] board;                            // holds all pieces in play
  int dimension = 8;                          // the width and height of the board
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
        board[row][col] = new Piece(col, row, team);
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
        board[row][col] = new Piece(col, row, team);
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
        board[row][col] = new Piece(col, row, team);
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

      if(Utils.inRange(row, 0, dimension) &&
         Utils.inRange(col, 0, dimension)) {
        
        teamChoice = board[row][col].getTeam();

        if(teamChoice != playersTeam) {
          System.out.println("That is not your piece!\n");
        } else {
          return board[row][col]; // Return the player's piece
        }
      } else {
        System.out.println("That is not a valid board position!\n");
      }

    } // End while teamChoice

    return new Piece(-1,-1,-1); // TODO Invalid piece - find a better way to do
    // this than returning some bogus piece. rework logic
  }

  /**
   * name: findSpaces
   * description: determines what spaces a Piece can move to
   *
   * @param mover   The piece to look around
   */
  public BoardPositions findSpaces(Piece mover) {
    int moverTeam = mover.getTeam();
    int row = mover.getLoc().getY(); // row piece is in
    int col = mover.getLoc().getX(); // column piece is in

    BoardPositions locations = new BoardPositions(); // where the piece can move

    // TODO the next step is to look at the spaces the piece can move to
    // here is where we branch off and have separate cases for player 1/2

    if(moverTeam == PLAYER_ONE) {
      int spaceARow = row + 1; // row below current piece
      int spaceACol = col - 1; // column left of current piece

      if(Utils.inRange(spaceARow, 0, dimension) &&
         Utils.inRange(spaceACol, 0, dimension) ) {

        int spaceATeam = board[spaceARow][spaceACol].getTeam();

        if(spaceATeam == EMPTY_POS) {
          // X first, then Y
          locations.add(new Pair(spaceACol, spaceARow), "valid");
        } else if(spaceATeam == PLAYER_TWO) {
          // position piece would jump to after eating opposing piece
          int spaceAJumpRow = spaceARow + 1;
          int spaceAJumpCol = spaceACol - 1;
          
          if(Utils.inRange(spaceAJumpRow, 0, dimension) &&
             Utils.inRange(spaceAJumpCol, 0, dimension)) {

            // if empty player1 can jump here and score
            if(board[spaceAJumpRow][spaceAJumpCol].getTeam() == EMPTY_POS) {
              locations.add(new Pair(spaceAJumpCol, spaceAJumpRow), "scoring");
            }
          }

        }
      } // End of spaceA work

      // spaceB coordinates relative to mover
      int spaceBRow = row + 1;
      int spaceBCol = col + 1; // column right of current piece

      if(Utils.inRange(spaceBRow, 0, dimension) &&
         Utils.inRange(spaceBCol, 0, dimension)) {
        
        // check team of spaceB
        int spaceBTeam = board[spaceBRow][spaceBCol].getTeam();

        // Can move here
        if(spaceBTeam == EMPTY_POS) {

          // add the piece as a valid location to move
          locations.add(new Pair(spaceBCol, spaceBRow), "valid");

        // Can jump piece if space behind it is empty
        } else if(spaceBTeam == PLAYER_TWO) {

          // coordinates of position to jump to 
          int spaceBJumpRow = spaceBRow + 1;
          int spaceBJumpCol = spaceBCol + 1;

          if(Utils.inRange(spaceBJumpRow, 0, dimension) &&
             Utils.inRange(spaceBJumpCol, 0, dimension)) {

            // space is empty means we can score if we jump to here
            if(board[spaceBJumpRow][spaceBJumpCol].getTeam() == EMPTY_POS) {
              locations.add(new Pair(spaceBJumpCol, spaceBJumpRow), "scoring"); 
            }
          }

        }
      } // If the position of spaceB is invalid, then we can't move there
    } else if(moverTeam == PLAYER_TWO) {
      int spaceARow = row - 1; // up from current row 
      int spaceACol = col + 1; // to the right of current column

      // check if spaceA is a valid position on the board
      if(Utils.inRange(spaceARow, 0, dimension) &&
         Utils.inRange(spaceACol, 0, dimension)) {
        
        // check what type of piece is at spaceA
        int spaceATeam = board[spaceARow][spaceACol].getTeam();

        if(spaceATeam == EMPTY_POS) {
          // if empty, we can move here
          locations.add(new Pair(spaceACol, spaceARow), "valid");
        } else if(spaceATeam == PLAYER_ONE) {
          // if on the other time, see if we can jump here
          int spaceAJumpRow = spaceARow - 1; // row above
          int spaceAJumpCol = spaceACol + 1; // column to right
          
          // if the space behind is empty, then it is a scoring position
          if(board[spaceAJumpRow][spaceAJumpCol].getTeam() == EMPTY_POS) {
            locations.add(new Pair(spaceAJumpCol, spaceAJumpRow), "scoring");
          } // if the space is not empty, we do nothing
        }

        int spaceBRow = row - 1; // up from current row
        int spaceBCol = col - 1; // left of current column

        if(Utils.inRange(spaceBRow, 0, dimension) &&
           Utils.inRange(spaceBCol, 0, dimension)) {

          // type of piece at spaceB position
          int spaceBTeam = board[spaceBRow][spaceBCol].getTeam();

          if(spaceBTeam == EMPTY_POS) {
            locations.add(new Pair(spaceBCol, spaceBRow), "valid");
          } else if(spaceBTeam == PLAYER_ONE) {
            int spaceBJumpRow = spaceBRow - 1;
            int spaceBJumpCol = spaceBCol - 1;

            // check if the space behind is empty
            if(board[spaceBJumpRow][spaceBJumpCol].getTeam() == PLAYER_TWO) {
              locations.add(new Pair(spaceBJumpCol, spaceBJumpRow), "scoring");
            }
          }
        } // end of player two spaceB work

      }
      
    } // End of player two work TODO what if it isn't player ONE or TWO?!

    return locations;
  }

/* 
 * TODO TODO remember, however the user enters the piece to keep track of x and
 * y properly. row column row column. 
 */

  /**
   * name: movePiece
   * description: Move a given piece to a location the player chooses
   *
   * plan: TODO 
   */
  public void movePiece(Piece mover) {
    // locate possible positions for the piece to move
    BoardPositions moveOptions = findSpaces(mover);
    // TODO here is where we call the extra routine to find the successive jump
    // positions and add them to the BoardPositions list

    Scanner sc = new Scanner(System.in);
    int row;
    int col;

    Pair chosenSpace = new Pair(-1, -1);

    // while space chosen is not contained in moveOptions
    while(!moveOptions.contains(chosenSpace)) {
      // prompt the user
      System.out.println("Where do you want to move(In row column format)?");

      row = sc.nextInt();
      col = sc.nextInt();

      chosenSpace = new Pair(col, row);
      if(!moveOptions.contains(chosenSpace)) {
        chosenSpace.print();
        System.out.println("\nThat is not a valid space!\n");
      } else {
        int oldCol = mover.getLoc().getY();
        int oldRow = mover.getLoc().getX();

        // move piece to new position TODO just setting reference TODO watch
        // for bugs here
        board[chosenSpace.getY()][chosenSpace.getX()] = mover;
        // set old space to an Empty piece
        board[oldCol][oldRow] = new Piece(mover.getLoc(), 0);
      }
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
