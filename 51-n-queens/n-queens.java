class Solution {
    public static List < List < String >> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        
        var col = new boolean[n];
        var leftDiag = new boolean[2 * n - 1];
        var rightDiag = new boolean[2 * n - 1];
        
        solve(0, board, col, leftDiag, rightDiag, result);
        
        return result;
    }
    
    private static void solve(int row, char[][] board, boolean[] col, boolean[] leftDiag, boolean[] rightDiag, List<List<String>> result) {
        if(row == board.length) {
            result.add(getString(board));
            return;
        }
        
        for(int i=0; i<board.length; i++) {
            int lDiag = row + i;
            int rDiag = board.length - 1 + i - row;
            if(!leftDiag[lDiag] && !rightDiag[rDiag] && !col[i]) {
                leftDiag[lDiag] = true;
                rightDiag[rDiag] = true;
                col[i] = true;
                board[row][i] = 'Q';
                solve(row + 1, board, col, leftDiag, rightDiag, result);
                leftDiag[lDiag] = false;
                rightDiag[rDiag] = false;
                col[i] = false;
                board[row][i] = '.';
            }
        }
    }
    
    private static List<String> getString(char[][] board) {
        var result = new ArrayList<String>();
        for(char[] row : board) {
            result.add(new String(row));
        }
        
        return result;
    }
}