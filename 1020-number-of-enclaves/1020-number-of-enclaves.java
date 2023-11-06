class Solution {
    public int numEnclaves(int[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                int val = grid[i][j];
                if(val == 0) continue;
                int res = numEnclavesHelper(grid, i, j); 
                count += (res < 0 ? 0 : res);
            }
        }
        
        return count;
    }
    
    int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public int numEnclavesHelper(int[][] grid, int row, int col) {
        if(row == 0 || col == 0 || row == grid.length - 1 || col == grid[0].length - 1) {
            return grid[row][col] == 1 ? -1 : 0;
        }
        
        if(grid[row][col] == 0) return 0;
        
        grid[row][col] = 0;
        int count = 1;
        
        for(int[] directon : directions) {
            int nrow = row + directon[0];
            int ncol = col + directon[1];
            
            int res = numEnclavesHelper(grid, nrow, ncol);
            if(res < 0) {
                grid[row][col] = 1;
                return -1;
            };
            
            count += res;
        }
        
        return count;

    }
}