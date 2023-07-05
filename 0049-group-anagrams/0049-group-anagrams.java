class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String s : strs) {
            int[] hash = new int[26];
            
            for(char c : s.toCharArray()) {
                hash[c - 'a']++;
            }
            
            String key = Arrays.toString(hash);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(s);
        }
        
        result.addAll(map.values());
        
        return result;
    }
}