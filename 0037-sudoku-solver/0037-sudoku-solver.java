class Solution {

    private boolean isSafe(char[][] board, int row, int col, char digit){
        //horizontal - vertical check
        for(int i = 0; i < 9; i++){
            if(board[row][i] == digit || board[i][col] == digit){
                return false;
            }
        }

        //3x3 grid
        int sc = (col/3)*3;
        int sr = (row/3)*3;

        for(int i=sr; i < sr+3; i++){
            for(int j = sc; j < sc+3; j++){
                if(board[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean helper(char[][] board, int row, int col){
        if(row == 9){
            return true;
        }

        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col == 8) ? 0 : col + 1;


        if(board[row][col] != '.'){
            return helper(board, nextRow, nextCol);
        }

        for(char digit = '1'; digit <= '9'; digit++){
            if(isSafe(board,row,col,digit)){
                board[row][col] = digit;
                if(helper(board,nextRow,nextCol)){
                    return true;
                }
                board[row][col] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
}