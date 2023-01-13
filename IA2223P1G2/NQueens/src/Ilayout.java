public interface Ilayout {
    /**
     * @return true if no queens are attacking each other;
     */
    boolean isGoal();

    /**
     * @param i the column with the queen that we want to move is;
     * @return true if a queen was successfully moved to a better or equal place;
     */
    boolean moveQueen(int i);

    /**
     * @return the size of the board
     */
    int size();
}