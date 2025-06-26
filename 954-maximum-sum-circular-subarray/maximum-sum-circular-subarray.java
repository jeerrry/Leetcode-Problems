class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentMaxSum = 0;

        int minSum = Integer.MAX_VALUE;
        int currentMinSum = 0;

        int total = 0;

        for(int val : nums) {
             currentMaxSum = Math.max(val, currentMaxSum + val);
             maxSum = Math.max(currentMaxSum, maxSum);

             currentMinSum = Math.min(val, currentMinSum + val);
             minSum = Math.min(currentMinSum, minSum);

             total += val;
        }

        return maxSum < 0 ? maxSum : Math.max(maxSum, total - minSum);
    }
}