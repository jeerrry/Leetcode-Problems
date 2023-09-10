class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int l = 0, r = removable.length;
        int[] map = new int[s.length()];
        Arrays.fill(map, removable.length);
        for (int i = 0; i < removable.length; ++i)
             map[removable[i]] = i;    
        while (l < r) {
            int m = (l + r + 1) / 2, j = 0;
            for (int i = 0; i < s.length() && j < p.length(); ++i)
                if (map[i] >= m && s.charAt(i) == p.charAt(j))
                    ++j;
            if (j == p.length())
                l = m;
            else
                r = m - 1;
        }
        return l;
    }
}