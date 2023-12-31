class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        
        for(int i=0; i<m; i++) {
            int[] temp = new int[n];
            
            for(int j=0; j<n; j++) {
                int left = j - 1 < 0 ? 0 : temp[j - 1];
                int up = dp[j];
                
                temp[j] = up + left;
            }
            
            dp = temp;
        }
        
        return dp[n -1];
    }
}