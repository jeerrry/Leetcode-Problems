class Solution {
    public int minSwaps(String s) {
        double maxOffset = 0;
        double currentOffset = 0;
        
        for(char c : s.toCharArray()) {
            if(c == ']') {
                currentOffset += 1;
            }else {
                currentOffset -= 1;
            }
            
            maxOffset = Math.max(maxOffset, currentOffset);
        }
        
        return (int)Math.ceil(maxOffset/2);
    }
}