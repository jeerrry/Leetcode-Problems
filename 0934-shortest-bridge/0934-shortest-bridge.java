class Solution {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid.length];
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid.length; j++) {
                if(grid[i][j] == 0) continue;
                
                dfs(grid, i, j, queue, visited);
                i = grid.length;
                break;
            }
        }
        
        int flips = 0;
        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        while(queue.size() > 0) {
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                int[] coord = queue.remove();
                for(int[] dir : dirs) {
                    int nrow = coord[0] + dir[0];
                    int ncol = coord[1] + dir[1];
                    
                    if(nrow < 0 || ncol < 0 || nrow == grid.length || ncol == grid.length) continue;
                    if(visited[nrow][ncol]) continue;
                    if(grid[nrow][ncol] == 1) return flips;
                    
                    visited[nrow][ncol] = true;
                    queue.add(new int[]{nrow, ncol});
                }
            }
            
            flips++;
        }
        
        return flips;
    }
    
    private void dfs(int[][] grid, int row, int col, Queue<int[]> queue, boolean[][] visited) {
        if(row < 0 || col < 0 || row == grid.length || col == grid.length) return;
        if(visited[row][col]) return;
        if(grid[row][col] == 0) return;
        
        visited[row][col] = true;
        queue.add(new int[]{row, col});
        dfs(grid, row, col - 1, queue, visited);
        dfs(grid, row - 1, col, queue, visited);
        dfs(grid, row, col + 1, queue, visited);
        dfs(grid, row + 1, col, queue, visited);
    }
}