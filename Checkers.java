public class Checkers {

  public static void main(String [] args) {
    GameBoard placeholder = new GameBoard();
    placeholder.setupBoard();
    placeholder.displayBoard();
    Piece moving = placeholder.selectPiece(2);

    BoardPositions foundLocs = placeholder.findSpaces(moving);

    foundLocs.printValidPositions();
    foundLocs.printScoringPositions();

    placeholder.movePiece(moving);

    placeholder.displayBoard();

    System.out.println("Finished tests");

    // Loop here running the game
  } // end of main


}
