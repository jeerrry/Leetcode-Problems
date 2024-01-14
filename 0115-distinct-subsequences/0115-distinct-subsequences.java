class Solution {

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] dp = new int[m + 1];
        int[] temp = new int[m + 1];
        dp[0] = 1;
        temp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char a = s.charAt(i-1);
                char b = t.charAt(j-1);
                
                if(a == b) {
                    temp[j] = dp[j - 1] + dp[j];
                }else {
                    temp[j] = dp[j];
                }
            }
            dp = temp.clone();
        }
        
        return dp[m];
    }
}
