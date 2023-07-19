class Solution {
    public int minSwaps(String s) {
        int maxOffset = 0;
        int currentOffset = 0;
        
        for(char c : s.toCharArray()) {
            if(c == ']') {
                currentOffset += 1;
            }else {
                currentOffset -= 1;
            }
            
            maxOffset = Math.max(maxOffset, currentOffset);
        }
        
        return (maxOffset + 1) / 2;
    }
}