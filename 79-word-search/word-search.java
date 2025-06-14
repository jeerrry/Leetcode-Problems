class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(helper(i, j, 0, word, board)) return true;
            }
        }
        
        return false;
    }
    
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean helper(int row, int col, int index, String word, char[][] board) {
        if(index >= word.length()) return true;
        
        char cur = word.charAt(index);
        char val = board[row][col];
        if(cur != val) return false;
        
        if(index + 1 == word.length()) return true;
        
        board[row][col] = 0;
        for(int[] dir : dirs) {
            int nrow = row + dir[0];
            int ncol = col + dir[1];
            
            if(nrow < 0 || ncol < 0) continue;
            if(nrow == board.length || ncol == board[0].length) continue;
            if(board[nrow][ncol] == 0) continue;
            
            if(helper(nrow, ncol, index + 1, word, board)) return true;
        }
        
        board[row][col] = val;
        
        return false;
    }
}