class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use boolean arrays to track seen numbers
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                // Skip empty cells
                if (board[r][c] == '.') {
                    continue;
                }

                // Convert char digit to a 0-8 index
                int val = board[r][c] - '1';
                
                // Calculate the 3x3 box index (0 to 8)
                int boxIndex = (r / 3) * 3 + (c / 3);

                // If the number was already seen in this row, col, or box, it is invalid
                if (rows[r][val] || cols[c][val] || boxes[boxIndex][val]) {
                    return false;
                }

                // Mark the number as seen
                rows[r][val] = true;
                cols[c][val] = true;
                boxes[boxIndex][val] = true;
            }
        }
        return true;
    }
}
