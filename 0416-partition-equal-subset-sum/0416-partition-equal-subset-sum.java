class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int val : nums) {
            sum += val;
        }
        
        if(sum % 2 == 1) return false;
        
        int k = sum / 2;
        boolean[] dp = new boolean[k + 1];
        dp[0] = true;
        
        if(nums[0] <= k) {
            dp[nums[0]] = true;
        }
        
        for(int i=1; i<nums.length; i++) {
            boolean[] curr = new boolean[k + 1];
            curr[0] = true;
            for(int target = 1; target<=k; target++) {
                boolean notInclude = dp[target];
                boolean include = false;
                if(nums[i] <= target) {
                    include = dp[target - nums[i]];
                }
                
                curr[target] = include || notInclude;
            }
            
            dp = curr;
        }
        
        return dp[k];
    }
}