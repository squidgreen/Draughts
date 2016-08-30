/*
 * date: July 31, 2017
 * author: Brandon Green
 * description: A piece in a checker's game. Each piece belongs to a player and
 *              occupies a square on the gameboard.
 */
class Piece {
  private Pair loc; // the piece's location
  private int team; // the number of the player the piece belongs to

  public Piece() {
    this.setLoc(new Pair());
  }

  public Piece(Pair startingLoc, int team) {
    this.setLoc(new Pair(startingLoc));
    this.setTeam(team);
  }

  public Piece(int col, int row, int team) {
    this(new Pair(col, row), team); 
  }

  private void setLoc(Pair location) {
    this.loc = location;
  }

  private void setTeam(int team) {
    this.team = team;
  }

  public Pair getLoc() {
    return this.loc;
  }

  public int getTeam() {
    return this.team;
  }
}
