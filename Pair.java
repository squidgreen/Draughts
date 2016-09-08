class Pair {
  private int x;
  private int y;

  public Pair() {
    this.setX(0);
    this.setY(0);
  }

  /*
   * name: Pair
   * description: Constructs a Pair object with the given parameters
   */
  public Pair(int x, int y) {
    this.setX(x);
    this.setY(y);
  }

  /*
   * description: Copy Constructor
   */
  public Pair(Pair other) {
    this.setX(other.getX());
    this.setY(other.getY());
  }

  @Override
  public boolean equals(Object obj) {
    System.out.println("Called!");

    // if obj is null or is not of type Rational
    if(obj == null || !(obj instanceof Pair)) {
      return false;
    } else if(this.getX() == ((Pair)obj).getX() && 
      this.getY() == ((Pair)obj).getY()) {
      return true;
    } else {
      return false;
    }
  }

  private void setX(int x) {
    this.x = x;
  }

  private void setY(int y) {
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  /*
   * Display the contents of the Pair object
   */
  public void print() {
    System.out.print("x: " + this.getX() + " y: " + this.getY());
  }
}
