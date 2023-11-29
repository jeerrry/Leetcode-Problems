class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] auxP = new boolean[n][m];
        boolean[][] auxA = new boolean[n][m];

        // Init First and and Last Row
        for (int i = 0; i < m; i++) {
            auxP[0][i] = true;
            auxA[n-1][i] = true;
        }

        // Initi First and Last Col
        for (int i = 0; i < n; i++) {
            auxP[i][0] = true;
            auxA[i][m-1] = true;
        }
        
        for (int i = 0; i < m; i++) {
            dfs(heights, auxP, 0, i);
            dfs(heights, auxA, n - 1, i);
        }
        
        for (int i = 0; i < n; i++) {
            dfs(heights, auxP, i, 0);
            dfs(heights, auxA, i, m - 1);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                boolean res1 = auxP[i][j];
                boolean res2 = auxA[i][j];
                
                if(!res1 || ! res2) continue;
                
                var temp = new ArrayList<Integer>();
                temp.add(i);
                temp.add(j);
                result.add(temp);
            }
        }
        
        return result;
    }
    
    private int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private void dfs(int[][] heights, boolean[][] aux, int row, int col) {
        aux[row][col] = true;
        
        for(int[] dir : dirs) {
            int nrow = row + dir[0];
            int ncol = col + dir[1];
            
            if(nrow < 0 || ncol < 0 || nrow == aux.length || ncol == aux[0].length) continue;
            if(aux[nrow][ncol]) continue;
            
            int current = heights[row][col];
            int next = heights[nrow][ncol];
            if(next < current) continue;
            
            dfs(heights, aux, nrow, ncol);
        }
    }
}
