class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        return helper(s, k);
    }

    private int helper(String s, int k) {
        var map = new HashMap<Character, Integer>();
        int count = 0;
        
        int p1 = 0;
        int p2 = 0;
        
        while(p2 < s.length()) {
            char cchar = s.charAt(p2);
            map.put(cchar, map.getOrDefault(cchar, 0) + 1);
            
            // Shrink Window
            while(map.size() > k) {
                char cold = s.charAt(p1);
                map.put(cold, map.getOrDefault(cold, 0) - 1);
                if(map.get(cold) <= 0) map.remove(cold);
                p1++;
            }
            count = Math.max(count, (p2 - p1 + 1));
            p2++;
        }
        
        return count;
    }
}