class Solution {
    public int minInsertions(String s) {
        String reverseS = new StringBuffer(s).reverse().toString();
        int n = s.length();
        
        int[] dp = new int[n + 1];        
        for(int i=1; i<=n; i++) {
            int[] temp = new int[n + 1];
            for(int j=1; j<=n; j++) {
                char a = s.charAt(i - 1);
                char b = reverseS.charAt(j - 1);
                
                if(a == b) {
                    temp[j] = 1 + dp[j - 1];
                }else {
                    temp[j] = Math.max(temp[j - 1], dp[j]);
                }
            }
            dp = temp;
        }
        
        return s.length() - dp[n];
    }
}