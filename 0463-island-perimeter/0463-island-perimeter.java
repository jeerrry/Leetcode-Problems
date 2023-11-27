class Solution {
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] <= 0) continue;
                
                sum += islandPerimeterHelper(grid, i, j);
            }
        }
        
        return sum;
    }
    
    private int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    private int islandPerimeterHelper(int[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length) {
            return 1;
        }
        if(grid[row][col] < 0) return 0;
        if(grid[row][col] == 0) return 1;
        
        grid[row][col] = -1;
        int perimeter = 0;
        for(int[] dir : directions) {
            int rr = row + dir[0];
            int cc = col + dir[1];
            
            int sum = islandPerimeterHelper(grid, rr, cc);
            perimeter += sum;
        }
        
        return perimeter;
    }
}