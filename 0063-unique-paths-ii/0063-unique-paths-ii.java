class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[] dp = new int[n];
        for(int i=0; i<m; i++) {
            int[] temp = new int[n];
            for(int j=0; j<n; j++) {
                if(obstacleGrid[i][j] == 1) continue;
                if(i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }                
                int up = dp[j];
                int left = j - 1 >=0 ? temp[j - 1] : 0;
                temp[j] = up + left;
            }
            
            dp = temp;
        }
        
        return dp[n - 1];
    }
}