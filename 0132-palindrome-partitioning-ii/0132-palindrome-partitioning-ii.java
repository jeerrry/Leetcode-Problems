class Solution {
    public int minCut(String s) {
        return minCutTabulation(s);
//         int n = s.length();
        
//         int[][] dp = new int[n][n];
//         for(int[] vals : dp) {
//             Arrays.fill(vals, -1);
//         }
        
//         return minCutHelper(0, n-1, s, dp) - 1;
    }
    
    private int minCutHelper(int i, int j, String s, int[][] dp) {
        if(i > j) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++) {
            if(isPalindrome(i, k, s)) {
                min = Math.min(min,1 + minCutHelper(k + 1, j, s, dp));
            }
        }
        
        return dp[i][j] = min;
    }
    
    private int minCutTabulation(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        
        for(int i = n - 1; i>=0; i--) {
            int min = Integer.MAX_VALUE;
            for(int k = i; k < n; k++) {
                if(isPalindrome(i, k, s)) {
                    min = Math.min(min,1 + dp[k + 1]);
                }
            }
            dp[i] = min;
        }
        
        return dp[0] - 1;
    }
    
    private boolean isPalindrome(int i, int j, String s) {
        while(i < j) {
            char a = s.charAt(i++);
            char b = s.charAt(j--);
            
            if(a != b) {
                return false;
            }
        }
        
        return true;
    }
}