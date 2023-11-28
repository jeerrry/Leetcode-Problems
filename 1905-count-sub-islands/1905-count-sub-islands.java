class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for(int i=0; i<grid1.length; i++) {
            for(int j=0; j<grid1[0].length; j++) {
                int val = grid1[i][j];
                
                if(val == 1) continue;
                countIsland(grid2, i, j);
            }
        }
        
        for(int i=0; i<grid1.length; i++) {
            for(int j=0; j<grid1[0].length; j++) {
                int val = grid2[i][j];
                
                if(val == 0) continue;
                count += countIsland(grid2, i, j);
            }
        }
        return count;
    }
    
    private int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int countIsland(int[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length) return 0;
        if(grid[row][col] == 0) return 0;
        
        grid[row][col] = 0;
        for(int[] dir : dirs) {
            int nrow = row + dir[0];
            int ncol = col + dir[1];
            
            countIsland(grid, nrow, ncol);
        }
        
        return 1;
    }
}