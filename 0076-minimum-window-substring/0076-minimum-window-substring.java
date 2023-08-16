class Solution {
    public String minWindow(String s, String t) { 
        HashMap<Character, Integer> map =  new HashMap<>();
        
        for(char c : t.toCharArray()){
            int val = map.getOrDefault(c, 0);
            map.put(c, val + 1);
        }
        
        int low = 0;
        int subStr = 0;
        int matches = 0;
        int minLength = s.length() + 1;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int val = map.get(c);
                map.put(c, --val);
                if(val == 0) matches++;
            }
            
            while(matches == map.size()) {
                if(minLength > i - low + 1) {
                    minLength = i - low + 1;
                    subStr = low;
                }
                char deleted = s.charAt(low++);
                if(map.containsKey(deleted)){
                    if(map.get(deleted) == 0) matches--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        
        return minLength > s.length() ? "" : s.substring(subStr, subStr + minLength);
    }
}