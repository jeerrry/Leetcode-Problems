class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=0; i<nums.length; i++) {
            dp[i] = nums[i];
            if(i - 3 >= 0) {
                dp[i] += Math.max(dp[i - 2], dp[i - 3]);
                continue;
            }
            
            if(i - 2 >=0) {
                dp[i] += dp[i - 2];
            }
        }
        
        return Math.max(dp[n - 1], dp[n - 2]);
    }
}