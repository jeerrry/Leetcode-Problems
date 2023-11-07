class Solution {
    private int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    public int[][] updateMatrix(int[][] mat) {
        LinkedList<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 0)
                    queue.addLast(new int[]{i, j});
                else
                    mat[i][j] = -1;
            }
        }
        
        while(queue.size() > 0) {
            int[] coord = queue.removeFirst();
            
            for(int[] dir : dirs) {
                int nrow = coord[0] + dir[0];
                int ncol = coord[1] + dir[1];
                
                if(nrow < 0 || ncol < 0 || nrow == mat.length || ncol == mat[0].length) continue;
                if(mat[nrow][ncol] != -1) continue;
                
                mat[nrow][ncol] = mat[coord[0]][coord[1]] + 1;
                queue.addLast(new int[]{nrow, ncol});
            }
        }
        
        return mat;
    }
}