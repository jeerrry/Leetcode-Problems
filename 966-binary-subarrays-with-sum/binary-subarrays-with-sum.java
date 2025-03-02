class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarraysWithSumHelper(nums, goal) - numSubarraysWithSumHelper(nums, goal - 1);
    }

    private int numSubarraysWithSumHelper(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        if(goal < 0) return 0;

        for(int i=0, j=0; j<nums.length; j++) {
            int val = nums[j];
            sum += val;
            while(sum > goal) {
                sum -= nums[i++];
            }

            count += j - i + 1;
        }

        return count;
    }
}