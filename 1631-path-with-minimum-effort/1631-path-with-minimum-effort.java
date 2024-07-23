class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] distance = new int[n][m];
        for(int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);
        
        var queue = new PriorityQueue<int[]>((x, y) -> x[2] - y[2]);
        distance[0][0] = 0;
        queue.add(new int[]{0, 0, 0});
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!queue.isEmpty()) {
            int[] data = queue.remove();
            int row = data[0];
            int col = data[1];
            int cDiff = data[2];
            
            for(int[] dir : dirs) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];
                
                if(nrow < 0 || ncol < 0 || nrow >= n || ncol >= m) continue;
                int diff = Math.abs(heights[nrow][ncol] - heights[row][col]);
                diff = Math.max(diff, cDiff);
                if(diff < distance[nrow][ncol]) {
                    distance[nrow][ncol] = diff;
                    queue.add(new int[]{nrow, ncol, diff});
                }
            }
        }
        
        return distance[n - 1][m - 1];
    }
}