class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                char current = board[i][j];
                if(current == word.charAt(0) && existHelper(board, word, i, j)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean existHelper(char[][] board, String word, int row, int col) {
        if(word.length() == 0) {
            return true;
        }
        
        if(row < 0 || row == board.length || col < 0 || col == board[0].length) return false;
        
        char current = word.charAt(0);
        
        if(current != board[row][col]) return false;
        
        board[row][col] = '0';
        boolean result = existHelper(board, word.substring(1), row, col + 1)
            || existHelper(board, word.substring(1), row, col - 1)
            || existHelper(board, word.substring(1), row + 1, col)
            || existHelper(board, word.substring(1), row - 1, col);
        board[row][col] = current;
        
        return result;
    }
}