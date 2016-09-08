import java.util.ArrayList;
import java.util.ListIterator;

/**
 * This class stores at what positions a piece on the GameBoard can move to. It
 * differentiates between positions that a piece can simply move to and
 * positions that would score a point for that player.
 *
 */
public class BoardPositions {
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
  public void add(Pair somePair, String type) { // TODO you need these
    if(type.equals("valid")) {
      validLocs.add(somePair);
    } else if(type.equals("scoring")) {
      scoringLocs.add(somePair);
    }
  }

  public boolean contains(Object o) {
    if(validLocs.contains(o) || scoringLocs.contains(o)) {
      return true;
    } else {
      return false;
    }
  }

  /*
   * Print out the contents of the valid locations ArrayList
   */
  public void printValidPositions() {
    ListIterator iter = validLocs.listIterator();

    while(iter.hasNext()) {
      ((Pair)iter.next()).print(); // utilizing Pair's print method
      System.out.println();
    }
  }

  /*
   * Print out the contents of the scoring locations ArrayList
   */
  public void printScoringPositions() {
    ListIterator iter = scoringLocs.listIterator();

    while(iter.hasNext()) {
      ((Pair)iter.next()).print();
      System.out.println();
    }

  }

}
