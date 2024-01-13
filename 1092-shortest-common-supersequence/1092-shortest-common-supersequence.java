class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        for(int i=1; i<=n; i++) {
            for(int j = 1; j<=m; j++) {
                char a = str1.charAt(i - 1);
                char b = str2.charAt(j - 1);
                
                if(a == b) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        int length = n + m - dp[n][m];
        int row = n;
        int col = m;
        StringBuilder builder = new StringBuilder();
        while(length > 0) {
            char a = row - 1 >=0 ? str1.charAt(row - 1) : 0;
            char b = col - 1 >=0 ? str2.charAt(col - 1) : 0;
            
            if(a == b) {
                builder.append(a);
                row--;
                col--;
            }else if(col - 1 >= 0 && dp[row][col - 1] == dp[row][col]) {
                builder.append(b);
                col--;
            }else if(row - 1 >= 0 && dp[row - 1][col] == dp[row][col]) {
                builder.append(a);
                row--;
            }
            
            length--;
        }
        
        String result = builder.reverse().toString();
        return result;
    }
}