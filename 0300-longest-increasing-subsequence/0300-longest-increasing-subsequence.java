class Solution {
    public int lengthOfLIS(int[] nums) {
//         int[][] dp = new int[nums.length][nums.length + 1];
        
//         for(int[] temp : dp) {
//             Arrays.fill(temp, -1);
//         }
        
        return tabulation(nums);
    }
    
    public int tabulation(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][nums.length + 1];
        
        for(int i=n - 1; i >=0; i--) {
            for(int j = i - 1; j >= - 1; j--) {
                int length = 0;
                length = dp[i + 1][j + 1];
                if(j == -1 || nums[i] > nums[j]) {
                    length = Math.max(length, 1 + dp[i + 1][i + 1]);
                }

                dp[i][j + 1] = length;
            }
        }
        
        return dp[0][0];
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