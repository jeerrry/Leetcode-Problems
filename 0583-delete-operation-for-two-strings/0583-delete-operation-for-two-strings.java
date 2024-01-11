class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[] dp = new int[m + 1];
        for(int i=1; i<=n; i++) {
            int[] temp = new int[m + 1];
            for(int j = 1; j<=m; j++) {
                char a = word1.charAt(i - 1);
                char b = word2.charAt(j - 1);
                
                if(a == b) {
                    temp[j] = 1 + dp[j - 1];
                }else {
                    temp[j] = Math.max(dp[j], temp[j - 1]);
                }
            }
            dp = temp;
        }
        
        return n + m - dp[m] * 2;
    }
}