class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 0) continue;
                queue.add(new int[]{i, j});
            }
        }
        
        if(queue.size() == 0 || queue.size() == (grid.length * grid[0].length)) return -1;
        
        int dist = 0;
        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        while(queue.size() > 0) {
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                int[] val = queue.remove();
                for(int[] dir : dirs) {
                    int nrow = val[0] + dir[0];
                    int ncol = val[1] + dir[1];
                    
                    if(nrow < 0 || ncol < 0 || nrow == grid.length || ncol == grid[0].length) continue;
                    if(grid[nrow][ncol] == 1) continue;
                    
                    grid[nrow][ncol] = 1;
                    queue.add(new int[]{nrow, ncol});
                }
            }
            
            dist+=1;
        }
        
        return dist - 1;
    }
}