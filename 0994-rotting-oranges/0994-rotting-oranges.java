class Solution {
    private int[][] dirs = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        // Rotten oranges at 0 minute.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) queue.add(new int[] { i, j });
            }
        }
        
        int minutes = 0;
        while(queue.size() > 0) {
            int rottenCount = queue.size();
            int freshCount = 0;
            
            for(int i=0; i<rottenCount; i++) {
                int[] rottenOrange = queue.remove();
                
                for(int[] dir : dirs) {
                    int nrow = rottenOrange[0] + dir[0];
                    int ncol = rottenOrange[1] + dir[1];
                    
                    if(nrow < 0 || ncol < 0) continue;
                    if(nrow == grid.length || ncol == grid[0].length) continue;
                    if(grid[nrow][ncol] == 0 || grid[nrow][ncol] == 2) continue;
                    
                    freshCount+= 1;
                    grid[nrow][ncol] = 2;
                    queue.add(new int[]{nrow, ncol});
                }
            }
            
            minutes += (freshCount > 0 ? 1 : 0);
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        
        return minutes;
    }
}
