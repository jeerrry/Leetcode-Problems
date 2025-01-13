class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        
        int startIndex = -1;
        int endIndex = -1;
        for(int i=0; i<nums.length; i++) {
            int val = nums[i];
            currentSum += val;
            maxSum = Math.max(maxSum, currentSum);
            if(currentSum < 0) currentSum = 0;
        }

        return maxSum;
    }
}