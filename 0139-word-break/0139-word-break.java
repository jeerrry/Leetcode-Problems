class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return true;
        
        if(map.containsKey(s) && !map.get(s)) return false;
        
        for(String str : wordDict) {
            int length = str.length();
            
            if(s.indexOf(str) == 0) {
                if(wordBreak(s.substring(length), wordDict)) {
                    return true;
                }
            }
        }
        
        map.put(s, false);
        
        return false;
    }
}