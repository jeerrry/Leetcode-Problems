class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int currentSum = 0;
        for(int i=0, j=0; i<nums.length; i++) {
            currentSum += nums[i];
            
            while(currentSum >= target) {
                min = Math.min(i - j + 1, min);
                currentSum -= nums[j++];
            }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}