class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];
        
        for(int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        
        return LIS(0, -1, nums, dp);
    }
    
    public int LIS(int index, int lastIndex, int[] nums, int[][] dp) {
        if(index == nums.length) return 0;
        if(dp[index][lastIndex + 1] != -1) {
            return dp[index][lastIndex + 1];
        }
        
        int length = 0;
        length = LIS(index + 1, lastIndex, nums, dp);
        if(lastIndex == - 1 || nums[index] > nums[lastIndex]) {
            length = Math.max(length, 1 + LIS(index + 1, index, nums, dp));
        }
        
        return dp[index][lastIndex + 1] = length;
    }
}