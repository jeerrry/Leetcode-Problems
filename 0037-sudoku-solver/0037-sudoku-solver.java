class Solution {
    public void solveSudoku(char[][] board) {
        helper(0, 0, board);
    }
    
    private boolean helper(int row, int col, char[][] board) {
        if(row == board.length) return true;
        if(col == board.length) {
            return helper(row + 1, 0, board);
        }
        
        if(board[row][col] != '.') {
            return helper(row, col + 1, board);
        }
        
        for(char i='1'; i<='9'; i++) {
            if(isSafe(row, col, i, board)) {
                board[row][col] = i;
                if(helper(row, col + 1, board)) return true;
                board[row][col] = '.';
            }
        }
        
        return false;
    }
    
    private boolean isSafe(int row, int col, char val, char[][] board) {
        int r= row/3*3+col/3;   //select the block
        for(int i=0; i<9; i++) {
            if(board[i][col] == val || board[row][i] == val || board[r/3*3+i/3][r%3*3+i%3]==val) return false;
        }
        
        return true;
    }
}