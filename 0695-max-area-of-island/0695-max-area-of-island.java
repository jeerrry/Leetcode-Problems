class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 0) continue;
                
                maxArea = Math.max(maxArea, maxAreaHelper(grid, i, j));
            }
        }
        
        return maxArea;
    }
    
    private int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int maxAreaHelper(int[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length) {
            return 0;
        }
        if(grid[row][col] == 0) return 0;
        
        grid[row][col] = 0;
        int count = 1;
        for(int[] dir : dirs) {
            int nrow = row + dir[0];
            int ncol = col + dir[1];
            
            count += maxAreaHelper(grid, nrow, ncol);
        }
        
        return count;
    }
}