class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j][0] = 0;
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= 2; j++) {
                dp[n][i][j] = 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < 3; k++) {
                    if(j == 0) {
                        dp[i][j][k] = Math.max(-prices[i] + dp[i + 1][1][k],
                                              0 + dp[i + 1][0][k]);
                    }else {
                        dp[i][j][k] = Math.max(prices[i] + dp[i + 1][0][k - 1],
                                              0 + dp[i + 1][1][k]);
                    }
                }
            }
        }
        
        return dp[0][0][2];
    }
}
