class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        solveQueensHelper(new int[n][n], 0, result);
        
        return result;
    }
    
    private void solveQueensHelper(int[][] board, int n, List<List<String>> result) {
        if(n == board.length) {
            List<String> res = new ArrayList<>();
            for(int i=0; i<board.length; i++) {
                String rsf = "";
                for(int j=0; j<board.length; j++) {
                    rsf = rsf + (board[i][j] == 0 ? "." : "Q");
                }
                res.add(rsf);
            }
            
            result.add(res);
            return;
        }
        
        for(int i=0; i<board.length; i++) {
            if(canPlaceQueen(board, n, i)) {
                board[n][i] = 1;
                solveQueensHelper(board, n + 1, result);
                board[n][i] = 0;
            }
        }
    }
    
    
    private boolean canPlaceQueen(int[][] board, int row, int col) {
        // is col safe
        for(int i=row - 1; i>=0; i--) {
            if(board[i][col] > 0) return false;
        }
        
        // is left diagonal safe
        for(int i=row, j=col; i>=0 && j>=0; i--,j--) {
            if(board[i][j] > 0) return false;
        }
        
        // is right diagonal safe
        for(int i=row, j=col; i>=0 && j<board.length; i--,j++) {
            if(board[i][j] > 0) return false;
        }
        
        return true;
    }
}