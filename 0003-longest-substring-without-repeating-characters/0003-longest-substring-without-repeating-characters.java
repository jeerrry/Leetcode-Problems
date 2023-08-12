class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int currentLength = 0;
        var set = new HashSet<Character>();
        
        for(int i = 0, j = 0; i<s.length();){
            char c = s.charAt(i);
            
            if(set.contains(c)) {
                currentLength -= 1;
                set.remove(s.charAt(j));
                j++;
            }else{
                currentLength += 1;
                set.add(c);
                i++;
            }
            
            maxLength = Math.max(maxLength, currentLength);
        }
        
        return maxLength;
    }
}