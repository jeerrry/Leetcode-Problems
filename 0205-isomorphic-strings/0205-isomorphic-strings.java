class Solution {
    public boolean isIsomorphic(String s, String t) {
        var map1 = new HashMap<Character, Character>();
        var map2 = new HashMap<Character, Character>();
        
        for(int i=0, j=0; i<s.length(); i++,j++){
            char a = s.charAt(i);
            char b = t.charAt(j);
            
            if(map1.containsKey(a)){
                if(map1.get(a) != b) {
                    return false;
                }
            }else {
                map1.put(a, b);
            }
            
            if(map2.containsKey(b)){
                if(map2.get(b) != a) {
                    return false;
                }
            }else {
                map2.put(b, a);
            }
        }
        
        return true;
    }
}