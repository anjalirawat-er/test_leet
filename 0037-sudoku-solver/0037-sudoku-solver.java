class Solution {

    boolean[][] rows = new boolean[9][10];
    boolean[][] cols = new boolean[9][10];
    boolean[][] boxes = new boolean[9][10];

    public void solveSudoku(char[][] board) {

        // Initialize the boolean arrays
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[(i / 3) * 3 + (j / 3)][num] = true;
                }
            }
        }

        solve(board);
    }

    private boolean solve(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {

                    int box = (i / 3) * 3 + (j / 3);

                    for (int num = 1; num <= 9; num++) {

                        if (!rows[i][num] && !cols[j][num] && !boxes[box][num]) {

                            board[i][j] = (char) (num + '0');
                            rows[i][num] = true;
                            cols[j][num] = true;
                            boxes[box][num] = true;

                            if (solve(board))
                                return true;

                            // Backtrack
                            board[i][j] = '.';
                            rows[i][num] = false;
                            cols[j][num] = false;
                            boxes[box][num] = false;
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }
}