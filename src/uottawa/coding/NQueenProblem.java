package uottawa.coding;

public class NQueenProblem
{
    final int N = 4;

    /* A utility function to print solution */
    void printSolution(int board[][]) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }

    boolean solveNQ() {
        int board[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        if (solveNQUtil(board, 0) == false)
        {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    private boolean solveNQUtil(int[][] board, int col) {
        if (col >= N) {
            return true;
        }
        
        for (int row = 0; row < N; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                
                boolean safeNext = solveNQUtil(board, col + 1);
                if (safeNext) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        
        return false;
    }

    private boolean isSafe(int[][] board, int row, int col) {
        //check row on the left side
        for (int checkColumn = 0; checkColumn < col; checkColumn++) {
            if (board[row][checkColumn] == 1) {
                return false;
            }
        }
        
        //check uppper diagonal on the left side
        for (int checkRow = row, j = col; checkRow >=0 && j >= 0; checkRow--, j--) {
            if (board[checkRow][j] == 1) {
                return false;
            }
        }
        //check lower diagonal on the left side
        for (int checkRow = row, j = col; checkRow < N && j >= 0; checkRow++, j--) {
            if (board[checkRow][j] == 1) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String args[])
    {
        NQueenProblem Queen = new NQueenProblem();
        Queen.solveNQ();
    }
}