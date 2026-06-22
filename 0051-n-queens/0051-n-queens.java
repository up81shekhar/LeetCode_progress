import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        // Fix 1: Return type must match the method signature
        List<List<String>> ans = new ArrayList<>(); 
        
        // Fix 2: Properly initialize the 2D char array
        char[][] board = new char[n][n]; 
        
        // Fix 3: Add missing semicolons and properly fill the board
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[n * 2 - 1];
        int[] upperDiagonal = new int[n * 2 - 1];
        
        solve(0, board, ans, leftRow, lowerDiagonal, upperDiagonal, n);
        return ans;
    }

    // Fix 4: Capitalized LR, LD, UD to match your usage, and passed 'n' into the method
    private void solve(int col, char[][] board, List<List<String>> ans, int[] LR, int[] LD, int[] UD, int n) {
        // Fix 5: Base case condition met
        if (col == n) {
            ans.add(construct(board));
            return;
        }
        
        for (int row = 0; row < n; row++) {
            // Fix 6: Corrected diagonal indexing logic for LD and UD
            if (LR[row] == 0 && LD[row + col] == 0 && UD[(n - 1) + (col - row)] == 0) {
                board[row][col] = 'Q';
                LR[row] = 1;
                LD[row + col] = 1;
                UD[(n - 1) + (col - row)] = 1;
                
                // Fix 7: Recursive call must happen ONLY if the queen was placed
                solve(col + 1, board, ans, LR, LD, UD, n);
                
                // Fix 8: Backtrack completely
                board[row][col] = '.';
                LR[row] = 0;
                LD[row + col] = 0;
                UD[(n - 1) + (col - row)] = 0;
            }
        }
    }

    // Fix 9: Added the missing helper method to convert char[][] board to List<String>
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
