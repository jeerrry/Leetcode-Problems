class Solution {
    private int length;
    public int snakesAndLadders(int[][] board) {
        length = board.length;
        
        // Reverse Board
        reverseBoard(board);
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        HashSet<Integer> set = new HashSet<>();
        
        while(queue.size() > 0) {            
            int[] val = queue.remove();
            int box = val[0];
            int cost = val[1];
            
            for(int i=1; i<=6; i++) {
                int nextBox = box + i;
                int[] coord = positionIntoCoord(nextBox);
                int r = coord[0];
                int c = coord[1];
                if(board[r][c] != -1) {
                    nextBox = board[r][c];
                }
                
                if(nextBox == (length * length)) {
                    return cost + 1;
                }
                
                if(!set.contains(nextBox)) {
                    set.add(nextBox);
                    queue.add(new int[]{nextBox, cost + 1});
                }
            }
        }
        
        return -1;
    }
    
    private void reverseBoard(int[][] board) {
        int l = 0;
        int r = board.length - 1;
        
        while(l < r) {
            int[] temp = board[l];
            board[l] = board[r];
            board[r] = temp;
            l++;
            r--;
        }
    }
    
    private int[] positionIntoCoord(int val) {
        int row = (val - 1) / length;
        int col = (val - 1) % length;
        if(row % 2 == 1) col = length - 1 - col;
        
        return new int[]{row, col};
    }
}