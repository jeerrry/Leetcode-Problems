class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for(int i=0; i<col; i++) {
            dfs(board, 0, i);
            dfs(board, row - 1, i);
        }
        
        for(int i=0; i<row; i++) {
            dfs(board, i, 0);
            dfs(board, i, col - 1);
        }
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                char c = board[i][j];
                switch(c) {
                    case 'O':
                        board[i][j] = 'X';
                        break;
                    case 'T':
                        board[i][j] = 'O';
                    default:
                        break;
                }
            }
        }
    }
    
    private int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private void dfs(char[][] board, int row, int col) {
        if(row < 0 || col < 0 || row == board.length || col == board[0].length) return;
        if(board[row][col] == 'X' || board[row][col] == 'T') return;
        
        board[row][col] = 'T';
        for(int[] dir : dirs) {
            int nrow = row + dir[0];
            int ncol = col + dir[1];
            
            dfs(board, nrow, ncol);
        }
    }
}