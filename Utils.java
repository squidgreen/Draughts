class Utils {
  /**
   * name: inRange
   *
   * Determines if a number given is within range of two other
   * numbers given. Inclusive of the low end and exclusive of the
   * high end. Returns true if in range and false if not.
   *
   * @param val   the number to check
   * @param low   the beginning of the range
   * @param high  the end of the range
   * @return      true if the number is in range, false if not
   */
  public static boolean inRange(int val, int low, int high) {
    if(val >= low && val < high) {
      return true;
    } else {
      return false;
    }
  }
}
