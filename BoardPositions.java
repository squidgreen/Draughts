import java.util.ArrayList;

/**
 * This class stores at what positions a piece on the GameBoard can move to. It
 * differentiates between positions that a piece can simply move to and
 * positions that would score a point for that player.
 */
class BoardPositions {
  private ArrayList<Pair> validLocs; // positions the piece can move to
  private ArrayList<Pair> scoringLocs; // positions the piece can move to and score

  /**
   * Initialize the ArrayLists - empty lists with initial capacities of ten
   */
  public BoardPositions() {
    validLocs = new ArrayList<Pair>();
    scoringLocs = new ArrayList<Pair>();
  }

  /**
   * name: add
   * description: add a position to either of the ArrayLists
   *
   * @param somePair  the Pair to be added to an ArrayList
   * @param type      signifies which ArrayList to add the Pair to
   * @return          none
   */
  private void add(Pair somePair, String type) { // TODO you need these
    if(type.equals("valid")) {
      validLocs.add(somePair);
    } else if(type.equals("scoring")) {
      scoringLocs.add(somePair);
    }
  }

}
