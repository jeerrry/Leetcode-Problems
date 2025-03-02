class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    private int helper(int[] nums, int k) {
        int count = 0;
        int oddCount = 0;
        for(int start=0, lead = 0; lead < nums.length; lead++) {
            boolean isOdd = nums[lead] % 2 == 1;
            if(isOdd) oddCount++;
            while(oddCount > k) {
                int old = nums[start++];
                oddCount -= (old % 2);
            }

            count += lead - start + 1;
        }

        return count;
    }
}