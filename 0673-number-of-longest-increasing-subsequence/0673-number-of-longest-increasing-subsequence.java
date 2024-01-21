class Solution {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] ct = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(ct, 1);

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    ct[i] = ct[j];
                } else if(nums[j] < nums[i] && dp[j] + 1 == dp[i]) {
                    ct[i] += ct[j];
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        int result = 0;
        for(int i=0; i<n; i++) {
            if(dp[i] == max) result += ct[i];
        }
        
        return result;
    }
}
