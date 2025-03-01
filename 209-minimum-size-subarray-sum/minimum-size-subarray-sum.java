class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(sum < target) {
                continue;
            }

            while(sum >= target) {
                length = Math.min(length, i - start + 1);
                sum -= nums[start++];
            }
        }

        return length == Integer.MAX_VALUE ? 0 : length;
    }
}