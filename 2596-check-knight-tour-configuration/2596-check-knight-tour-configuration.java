class Solution {
    private boolean isValid(int[][] grid, int n, int r, int c, int expectedVal){

        if(r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != expectedVal){
            return false;
        }

        if(expectedVal == n * n - 1){
            return true;
        }

        // All 8 unique knight moves
        boolean ans1 = isValid(grid, n, r - 2, c + 1, expectedVal + 1);
        boolean ans2 = isValid(grid, n, r - 1, c + 2, expectedVal + 1);
        boolean ans3 = isValid(grid, n, r + 1, c + 2, expectedVal + 1);
        boolean ans4 = isValid(grid, n, r + 2, c + 1, expectedVal + 1);
        boolean ans5 = isValid(grid, n, r + 2, c - 1, expectedVal + 1);
        boolean ans6 = isValid(grid, n, r + 1, c - 2, expectedVal + 1); 
        boolean ans7 = isValid(grid, n, r - 1, c - 2, expectedVal + 1); 
        boolean ans8 = isValid(grid, n, r - 2, c - 1, expectedVal + 1); 

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;
    }

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        return isValid(grid, grid.length, 0, 0, 0);
    }
}
