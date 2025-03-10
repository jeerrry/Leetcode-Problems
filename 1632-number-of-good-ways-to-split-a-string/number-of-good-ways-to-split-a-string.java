class Solution {
    public int numSplits(String s) {
        var map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int result = 0;
        var set = new HashSet<Character>();
        for(char c : s.toCharArray()) {
            set.add(c);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if(map.get(c) == 0) map.remove(c);

            result += set.size() == map.size() ? 1 : 0; 
        }

        return result;
    }
}