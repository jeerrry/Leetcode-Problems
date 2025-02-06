class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;

        int maxLen = 1;
        String result = s.substring(0, 1);

        for(int i=0; i<s.length(); i++) {
            for(int j=i + maxLen; j<=s.length(); j++) {
                String sub = s.substring(i, j);
                if(j - i > maxLen && isPalindrome(sub)) {
                    maxLen = j - i;
                    result = sub;
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {
        int p1 = 0, p2 = s.length() - 1;

        while(p1 < p2) {
            char a = s.charAt(p1);
            char b = s.charAt(p2);

            if(a == b) {
                p1++;
                p2--;

                continue;
            }

            return false;
        }

        return true;
    }
}