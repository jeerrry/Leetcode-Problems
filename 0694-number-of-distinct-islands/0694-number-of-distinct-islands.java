class Solution {
    public int numDistinctIslands(int[][] grid) {
        HashSet<String> set = new HashSet<>();
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 0) continue;
                
                String result = dfs(grid, i, j, "s");
                set.add(result);
            }
        }
        
        return set.size();
    }
    
    
    private String dfs(int[][] grid, int row, int col, String psf) {
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length) return "";
        if(grid[row][col] == 0) return "";
        
        grid[row][col] = 0;
        
        psf += dfs(grid, row, col - 1, "l");
        psf += dfs(grid, row - 1, col, "t");
        psf += dfs(grid, row, col + 1, "r");
        psf += dfs(grid, row + 1, col, "b");
        
        psf += "e";
        return psf;
    }
}