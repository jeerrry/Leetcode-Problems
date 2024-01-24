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
        
        return minCostHelper(nCuts, 1, cuts.length, dp);
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