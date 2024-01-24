class Solution {
    public int minCost(int n, int[] cuts) {
        int[] nCuts = Arrays.copyOf(cuts, cuts.length + 2);
        nCuts[nCuts.length - 2] = 0;
        nCuts[nCuts.length - 1] = n;
        
        Arrays.sort(nCuts);
        int[][] dp = new int[nCuts.length][nCuts.length];
        for(int[] val : dp) {
            Arrays.fill(val, -1);
        } 
        
        return tabulation(nCuts);
    }
    
    private int tabulation(int[] cuts) {
        int n = cuts.length;
        int c = cuts.length - 2;
        
        int[][] dp = new int[n + 2][n + 2];
        for(int i=c; i >= 1; i--) {
            for(int j = 1; j<=c; j++) {
                if(i > j) continue;
                int min = Integer.MAX_VALUE;

                int cost = cuts[j + 1] - cuts[i - 1];
                for(int a=i; a<=j; a++) {
                    int cst = cost + dp[i][a - 1]
                        + dp[a + 1][j];
                    min = Math.min(min, cst);
                }
                dp[i][j] = min;
            }
        }
        
        return dp[1][c];
        
    }
    
    private int minCostHelper(int[] cuts, int i, int j, int[][] dp) {
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        int cost = cuts[j + 1] - cuts[i - 1];
        int min = Integer.MAX_VALUE;
        for(int a=i; a<=j; a++) {
            int cst = cost + minCostHelper(cuts, i, a - 1, dp)
                + minCostHelper(cuts, a + 1, j, dp);
            min = Math.min(min, cst);
        }
        
        return dp[i][j] = min;
    }
}