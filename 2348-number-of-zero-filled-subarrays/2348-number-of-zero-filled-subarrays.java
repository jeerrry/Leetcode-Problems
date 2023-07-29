class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long tCount = 0;
        HashMap<Long, Long> map = new HashMap<>();
        long zeroLength = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                long oldVal = map.getOrDefault(zeroLength, 0L);
                long newVal = oldVal + 1;
                zeroLength += 1;
                map.put(zeroLength, newVal);
                tCount+=newVal;
            }else{
                map = new HashMap<>();
                zeroLength = 0;
            }
        }
        
        return tCount;
    }
}