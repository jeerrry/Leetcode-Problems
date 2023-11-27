class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<order.length(); i++) {
            char c = order.charAt(i);
            map.put(c, i);
        }
        
        for(int i=0; i<words.length - 1; i++) {
            String wordA = words[i];
            String wordB = words[i + 1];
            
            for(int j =0; j<wordA.length(); j++) {
                if(j == wordB.length()) return false;
                
                char a = wordA.charAt(j);
                char b = wordB.charAt(j);
                
                if(a != b) {
                    int val1 = map.get(a);
                    int val2 = map.get(b);
                    
                    if(val2 < val1) return false;
                    else break;
                }
            }
        }
        
        return true;
    }
}