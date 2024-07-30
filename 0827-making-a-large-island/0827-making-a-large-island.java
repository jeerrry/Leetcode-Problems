class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[] size = new int[n * m];
        int[] parent = new int[n * m];
        for(int i=0; i<n * m; i++) parent[i] = i;
        Arrays.fill(size, 1);
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int result = 1;
        for(int i=0; i < n; i++) {
            for(int j=0; j < m; j++) {
                if(grid[i][j] == 0) continue;
                int index = i * m + j;
                
                for(var dir : dirs) {
                    int nrow = i + dir[0];
                    int ncol = j + dir[1];
                    int nind = nrow * m + ncol;
                    if(nrow < 0 || ncol < 0 || nrow >= n || ncol >= m || grid[nrow][ncol] == 0) continue;
                    
                    result = Math.max(result, union(index, nind, size, parent));
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) continue;
                int index = i * m + j;
                int lresult = 0;
                var selected = new HashSet<Integer>();
                
                for(var dir : dirs) {
                    int nrow = i + dir[0];
                    int ncol = j + dir[1];
                    int nind = nrow * m + ncol;
                    if(nrow < 0 || ncol < 0 || nrow >= n || ncol >= m || grid[nrow][ncol] == 0) continue;
                    
                    int px = findParent(nind, parent);
                    if(selected.contains(px)) continue;
                    selected.add(px);
                    lresult += size[px];
                }
                
                if(lresult>0) {
                    result = Math.max(result, lresult + 1);
                }
            }
        }
        
        return result;
    
    }
    
    private int findParent(int x, int[] parent) {
        if(x == parent[x]) return x;
        
        return parent[x] = findParent(parent[x], parent);
    }
    
    private int union(int x, int y, int[] size, int[] parent) {
        int px = findParent(x, parent);
        int py = findParent(y, parent);
        
        if(px == py) return size[px];
        
        if(size[px] <= size[py]) {
            parent[px] = py;
            size[py] += size[px];
            
            return size[py];
        }
        
        parent[py] = px;
        size[px] += size[py];
        
        return size[px];
    }
}