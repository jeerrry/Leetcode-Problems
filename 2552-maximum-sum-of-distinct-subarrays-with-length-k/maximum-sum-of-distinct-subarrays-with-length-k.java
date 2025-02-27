class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        var set = new HashSet<Integer>();
        long maxSum = 0;
        long sum = 0;

        for(int i=0, j=0; j<nums.length;) {
            int num = nums[j];
            if(set.contains(num)) {
                sum -= nums[i];
                set.remove(nums[i++]);
                continue;
            }

            set.add(num);
            sum += num;
            if(j - i + 1 == k) {
                maxSum = Math.max(sum, maxSum);
                set.remove(nums[i]);
                sum -= nums[i++];
            }

            j++;
        }

        return maxSum;
    }
}