class LocalSearch {
    /**
     * > The function `solve` takes a layout `s` and solves it, returning a layout `s` with all queens in
     * non-attacking positions
     * 
     * @param s the layout to be solved
     * @return The layout of the board.
     */
    final public Ilayout solve(Ilayout s) {
        int moves = 0;
        do {
            moves = 0;
            for (int i = 0; i < s.size(); i++) {
                if (s.moveQueen(i))
                    moves++;
            }
        } while (moves > 0);
        return s;
    }
}