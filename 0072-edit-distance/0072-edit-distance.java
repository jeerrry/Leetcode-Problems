class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        for(int i=1; i<=n; i++) dp[i][0] = i;
        for(int j=1; j<=m; j++) dp[0][j] = j;
        
        for(int i = 1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                char a = word1.charAt(i - 1);
                char b = word2.charAt(j - 1);
                
                if(a == b) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                
                int count = 1;
                int ways = Math.min(dp[i][j - 1], dp[i - 1][j - 1]);
                count += Math.min(ways, dp[i - 1][j]);
                dp[i][j] = count;
            }
        }
        
        return dp[n][m];
    }
}