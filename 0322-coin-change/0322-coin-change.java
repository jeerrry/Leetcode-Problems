class Solution {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[i] = i / coins[0];
            } else {
                dp[i] = (int) Math.pow(10, 9);
            }
        }

        for (int i = 1; i < n; i++) {
            int[] temp = new int[amount + 1];
            for (int j = 0; j <= amount; j++) {
                int notSelect = dp[j];
                int select = (int) Math.pow(10, 9);
                if(coins[i] <= j) {
                    select = 1 + temp[j - coins[i]];
                }
                
                temp[j] = Math.min(select, notSelect);
            }
            dp = temp;
        }
        
        return dp[amount] == (int) Math.pow(10, 9) ? -1 : dp[amount];
    }
}
