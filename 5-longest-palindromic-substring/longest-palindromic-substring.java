class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;

        int maxLen = 0;
        int start = 0;
        int end = 0;

        for(int i=0; i<s.length(); i++) {
            int[] odd = expand(s, i, i);
            int[] even =  expand(s, i, i+1);

            if(maxLen < odd[0] || maxLen < even[0]) {
                if(odd[0] > even[0]) {
                    maxLen = odd[0];
                    start = odd[1];
                    end = odd[2];
                }else {
                    maxLen = even[0];
                    start = even[1];
                    end = even[2];
                }
            }
        }

        return s.substring(start, end + 1);
    }

    private int[] expand(String s, int i, int j) {
        int[] range = {0 ,i, j};
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            range[0] = j - i + 1;
            range[1] = i;
            range[2] = j;
            i--;
            j++;
        }

        return range;
    }
}