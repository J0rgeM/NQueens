import java.util.Arrays;

class Board implements Ilayout, Cloneable {
    private final int n;
    public int board[], positiveSlope[], negativeSlope[];

    // This is the constructor for the Board class. It is initializing the board with the dimensions of
    // the board.
    public Board(int dim) {
        this.n = dim;
        board = new int[n];
        positiveSlope = new int[2 * n - 1];
        negativeSlope = new int[2 * n - 1];
        for (int i = 0; i < n; i++) {
            board[i] = i;
            positiveSlope[i + board[i]]++;
            negativeSlope[i - board[i] + (n - 1)]++;
        }
    }

    /**
     * The function takes in a 2D array of integers and returns a string representation of the array
     * 
     * @return The board array is being returned.
     */
    public String toString() {
        return Arrays.toString(this.board);
    }

    /**
     * The hashCode() function returns a hash code value for the object
     * 
     * @return The hashcode of the board.
     */
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(board);
        return result;
    }

    /**
     * > Count the number of collisions for a given column
     * 
     * @param col the column we're checking
     * @return The number of collisions for a given column.
     */
    private int numberOfCollisions(int col) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(col == i) continue;
            if(board[i] == board[col])
                count++;
        }
        return count + positiveSlope[col + board[col]] + negativeSlope[col - board[col] + (n - 1)];
    }

    /**
     * It moves the queen in the column specified by the parameter col to the row that minimizes the
     * number of collisions
     * 
     * @param col the column of the queen to be moved 
     * @return The number of collisions in the column.
     */
    @Override
    public boolean moveQueen(int col) {
        int originalRow = board[col], min = numberOfCollisions(col) - 2, temp, newRow = originalRow;
        for (int row = 0; row < n; row++) {
            if(row == originalRow) continue;
            board[col] = row;
            if((temp = numberOfCollisions(col)) <= min) {
                min = temp;
                newRow = row;
            }
        }
        if(newRow != originalRow) {
            board[col] = newRow;
            positiveSlope[col + originalRow]--;
            negativeSlope[col - originalRow + (n - 1)]--;
            positiveSlope[col + board[col]]++;
            negativeSlope[col - board[col] + (n - 1)]++;
            return true;
        }
        board[col] = originalRow;
        return false;
    }

    /**
     * If there is any queen collision returns false, otherwise returns true.
     * 
     * @return The method isGoal() is returning a boolean value.
     */
    @Override
    public boolean isGoal() {
        for (int col = 0; col < n; col++) {
            for (int col2 = col + 1; col2 < n; col2++) {
                if (col2 == col)
                    continue;
                else if (board[col] == board[col2] || Math.abs(col - col2) == Math.abs(board[col] - board[col2]))
                    return false;
            }
        }
        return true;
    }

    /**
     * This function returns the number of elements in the list
     * 
     * @return The number of items in the queue.
     */
    @Override
    public int size() {
        return this.n;
    }
}