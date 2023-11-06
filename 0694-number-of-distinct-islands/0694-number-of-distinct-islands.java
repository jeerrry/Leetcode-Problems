class Solution {
    public int numDistinctIslands(int[][] grid) {
        HashSet<String> set = new HashSet<>();
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 0) continue;
                
                var psf = new StringBuilder("s");
                String result = dfs(grid, i, j, psf).toString();
                set.add(result);
            }
        }
        
        return set.size();
    }
    
    
    private StringBuilder dfs(int[][] grid, int row, int col, StringBuilder psf) {
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length) return new StringBuilder();
        if(grid[row][col] == 0) return new StringBuilder();
        
        grid[row][col] = 0;
        
        psf.append(dfs(grid, row, col - 1, new StringBuilder("l")));
        psf.append(dfs(grid, row - 1, col, new StringBuilder("t")));
        psf.append(dfs(grid, row, col + 1, new StringBuilder("r")));
        psf.append(dfs(grid, row + 1, col, new StringBuilder("b")));
        
        psf.append("e");
        return psf;
    }
}