class Solution {
    public int numEnclaves(int[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
                    numEnclavesHelper(grid, i, j);
                }
            }
        }
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    count += 1;
                }
            }
        }
        
        return count;
    }
    
    public void numEnclavesHelper(int[][] grid, int row, int col) {        
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length) return;
        if(grid[row][col] == 0) return;
        
        grid[row][col] = 0;
        
        numEnclavesHelper(grid, row - 1, col);
        numEnclavesHelper(grid, row, col - 1);
        numEnclavesHelper(grid, row + 1, col);
        numEnclavesHelper(grid, row, col + 1);
    }
}