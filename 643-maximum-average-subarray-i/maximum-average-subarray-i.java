class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double result = Integer.MIN_VALUE;
        double sum = 0;
        int start = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(i - start + 1 == k) {
                result = Math.max(result, sum/k);
                sum -= nums[start++];
            }
        }

        return result;
    }
}