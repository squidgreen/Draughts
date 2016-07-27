/*
 * Defines a class for a Pair object that represents two values. Good for
 * coordinates.
 */
public class Pair {
  /* Instance Variables */
  private int x;
  private int y;

  /*
   * name: Pair()
   * description: Default constructor
   */
  public Pair() {
    this(0,0);
  }

  /*
   * name: Pair(int x, int y)
   * description: Constructor - create a Pair object with the passed args
   */
  public Pair(int x, int y) {
    this.setX(x);
    this.setY(y);
  }

  /*
   * name: setX
   * description: Setter for x instance variable
   */
  private void setX(int x) {
    this.x = x;
  }

  /*
   * name: setY
   * description: Setter for y instance variable
   */
  private void setY(int y) {
    this.y = y;
  }
}

/*
 * this -
 * this is a reference to the current object - the object whose method or
 * constructor is being called. 
 */
