class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length() <= k) return false;
        
        HashSet<String> map = new HashSet<>();
        int targetCount = 1 << k;
        
        StringBuilder builder = new StringBuilder();
        
        for(int i=0; i<k; i++) {
            builder.append(s.charAt(i));
        }
        
        map.add(builder.toString());
        
        for(int i=k; i<s.length(); i++) {
            builder.append(s.charAt(i));
            builder.deleteCharAt(0);
            
            if(!map.contains(builder.toString())){
                map.add(builder.toString());
            }
        }
        
        return map.size() == targetCount;
    }
}