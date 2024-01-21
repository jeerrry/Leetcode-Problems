class Solution {

    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(compare(words[i], words[j]) && 1 + dp[j] > dp[i]) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }
        
        return max;
    }

    private static boolean compare(String a, String b) {
        if (a.length() != b.length() + 1) return false;

        int len1 = 0;
        int len2 = 0;

        while (len1 < a.length()) {
            if (len2 < b.length() && a.charAt(len1) == b.charAt(len2)) {
                len1++;
                len2++;
            } else {
                len1++;
            }
        }

        return len1 == a.length() && len2 == b.length();
    }
}
