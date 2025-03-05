class Solution {
    public boolean isIsomorphic(String s, String t) {
        var map = new int[128];
        var map2 = new int[128];

        if(s.length() != t.length()) return false;

        for(int i=0; i<s.length(); i++) {
            if(map[s.charAt(i)] != map2[t.charAt(i)]) {
                return false;
            }

            map[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;
        }

        return true;
    }
}