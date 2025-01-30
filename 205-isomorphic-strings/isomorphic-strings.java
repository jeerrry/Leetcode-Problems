class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] map = new char[128];
        char[] map2 = new char[128];

        for(int i=0; i<t.length(); i++) {
            char one = s.charAt(i);
            char two = t.charAt(i);

            int i1 = one;
            int i2 = two;

            if(map[i1] > 0 && map[i1] != two) {
                return false;
            }

            if(map2[i2] > 0 && map2[i2] != one) {
                return false;
            }

            map[i1] = two;
            map2[i2] = one;

        }

        return true;
    }
}