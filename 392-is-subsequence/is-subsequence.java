class Solution {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0;
        int p2 = 0;

        while(p1 < s.length() && p2 < t.length()) {
            char a = s.charAt(p1);
            char b = t.charAt(p2);

            if(a == b) {
                p1++;
            }

            p2++;
        }

        return p1 == s.length();
    }
}