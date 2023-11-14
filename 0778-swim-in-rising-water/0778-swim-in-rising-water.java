class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        queue.add(new int[] {0, 0, grid[0][0]});
        boolean[][] visited = new boolean[grid.length][grid.length];
        int ans = 0;
        int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        
        while(queue.size() > 0) {
            int[] current = queue.remove();
            int row = current[0];
            int col = current[1];
            int msf = current[2];
            
            if(row == grid.length - 1 && col == grid.length - 1) {
                ans = msf;
                break;
            }
            
            visited[row][col] = true;
            
            for(int[] dir : directions) {
                int rd = current[0] + dir[0];
                int cd = current[1] + dir[1];
                
                if(rd < 0 || cd < 0) continue;
                if(rd == grid.length || cd == grid.length) continue;
                if(visited[rd][cd]) continue;
                
                queue.add(new int[]{rd, cd, Math.max(msf, grid[rd][cd])});
            }
            
        }
        
        return ans;
    }
}