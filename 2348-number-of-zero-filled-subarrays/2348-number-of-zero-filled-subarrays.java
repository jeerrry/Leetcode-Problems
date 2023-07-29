class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long tCount = 0;
        long lastCount = 0;
        
        for(int val : nums) {
            if(val == 0) {
                long oldVal = lastCount;
                long newVal = oldVal + 1;
                lastCount = newVal;
                tCount+=newVal;
            }else{
                lastCount = 0;
            }
        }
        
        return tCount;
    }
}