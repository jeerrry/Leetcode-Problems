class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map =  new HashMap<>();
        List<String> result = new ArrayList();
        
        if(s.length() < 10) return result;
        
        StringBuilder seq = new StringBuilder();
        for(int i=0; i<10; i++) {
            char c = s.charAt(i);
            seq.append(c + "");
        }
        
        map.put(seq.toString(), 1);
        
        for(int i=10; i<s.length(); i++) {
            char current = s.charAt(i);
            seq.deleteCharAt(0);
            seq.append(current + "");
            
            String key = seq.toString();
            
            if(map.containsKey(key)) {
                if( map.get(key) == 1) {
                    result.add(seq.toString());
                    map.put(key, 2);   
                }
            }else{
                map.put(key, 1);
            }
        }
        
        return result;
    }
}