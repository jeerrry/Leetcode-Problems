class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) return false;

        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        
        int pointer = 0;
        for(char c : pattern.toCharArray()) {
            String value = strings[pointer];
            
            if (map.containsKey(c) && !map.get(c).equals(value)) return false;
            if (map2.containsKey(value) && map2.get(value) != c) return false;
            
            map.put(c, strings[pointer]);
            map2.put(strings[pointer++], c);
        }
        
        return true;
    }
}