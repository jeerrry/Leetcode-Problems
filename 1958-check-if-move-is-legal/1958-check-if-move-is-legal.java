class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        for(int[] dir : dirs) {
            boolean result = check(board, rMove, cMove, color, dir);
            if(result) return true;
        }
        
        return false;
    }
    private boolean check(char[][] board, int rMove, int cMove, char color, int[] dir) {
        int length = 1;
        int row = rMove + dir[0];
        int col = cMove + dir[1];
        
        while(row >=0 && col >=0 && row < board.length && col < board[0].length) {
            length+=1;
            char val = board[row][col];
            if(val == '.') return false;
            if(val == color) return length >=3;
            row += dir[0];
            col += dir[1];
        }
        
        return false;
    }
}