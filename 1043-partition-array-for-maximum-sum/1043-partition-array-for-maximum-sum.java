class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return maxSumAfterPartitioningHelper(0, arr, k, dp);
    }
    
    private int maxSumAfterPartitioningHelper(int i, int[] arr, int k, int[] dp) {
        if(i == arr.length) return 0;
        if(dp[i] != -1) return dp[i];
        
        int maxVal = Integer.MIN_VALUE;
        int maxSum = 0;
        
        for(int j = 0; j < k && i + j < arr.length; j++) {
            maxVal = Math.max(maxVal, arr[i + j]);
            int len = i + j - i + 1;
            maxSum = Math.max(maxSum, (maxVal * len)
                              + maxSumAfterPartitioningHelper(i + j + 1, arr, k, dp)); 
        }
        
        return dp[i] = maxSum;
    }
}