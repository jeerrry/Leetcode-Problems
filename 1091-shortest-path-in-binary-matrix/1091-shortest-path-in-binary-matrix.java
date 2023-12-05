class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        if(grid[0][0] == 0) queue.add(new int[] {0, 0}); 
        
        int pathSize = 1;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        while(queue.size() > 0) {
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                int[] coord = queue.remove();
                int row = coord[0];
                int col = coord[1];
                int val = grid[row][col];
                
                if(val == 1) continue;
                if(val == 0 && row == n-1 && col == n-1) return pathSize;
                
                grid[row][col] = 1;
                for(int[] dir : dirs) {
                    int nrow = row + dir[0];
                    int ncol = col + dir[1];
                    
                    if(nrow < 0 || ncol < 0) continue;
                    if(nrow == n || ncol == n) continue;
                    int nval = grid[nrow][ncol];
                    
                    if(nval == 1) continue;
                    queue.add(new int[]{nrow, ncol});
                }
            }
            
            pathSize+=1;
        }
        
        return -1;
    }
}