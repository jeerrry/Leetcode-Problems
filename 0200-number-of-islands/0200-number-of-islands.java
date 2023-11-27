class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                char val = grid[i][j];
                if(val == '0') continue;
                
                islandCountHelper(grid, i, j);
                count+=1;
            }
        }
        
        return count;
    }
    
    private int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private void islandCountHelper(char[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length) return;
        if(grid[row][col] == '0') return;
        
        grid[row][col] = '0';
        for(int[] dir : directions) {
            islandCountHelper(grid, row + dir[0], col + dir[1]);
        }
    }
}