class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        for(int i = 0; i<=amount; i++) {
            if(i%coins[0] == 0) {
                dp[i] = 1;
            }
        }
        
        for(int i = 1; i < coins.length; i++) {
            int[] temp = new int[amount + 1];
            for(int j = 0; j <= amount; j++) {
                int notInclude = dp[j];
                int include = 0;
                if(coins[i] <= j) {
                    include = temp[j - coins[i]];
                }
                
                temp[j] = include + notInclude;
            }
            dp = temp;
        }
        
        return dp[amount];
    }    
}