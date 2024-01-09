class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        int[] dp = new int[m + 1];
        for(int i=1; i<=n; i++) {
            int[] temp = new int[m + 1];
            for(int j = 1; j<=m; j++) {
                char a = text1.charAt(i - 1);
                char b = text2.charAt(j - 1);
                
                if(a == b) {
                    temp[j] = 1 + dp[j - 1];
                }else {
                    temp[j] = Math.max(dp[j], temp[j - 1]);
                }
            }
            dp = temp;
        }
        
        return dp[m];
    }
}