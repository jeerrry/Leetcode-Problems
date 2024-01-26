class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.add(0, 1);
        list.add(1);
        
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        for(int[] val : dp) {
            Arrays.fill(val, -1);
        }
        
        return maxCoinsHelper(1, nums.length, list, dp);
    }
    
    private int maxCoinsHelper(int i, int j, List<Integer> nums, int[][] dp) {
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        int max = Integer.MIN_VALUE;
        for(int k=i; k<=j; k++) {
            int cost = nums.get(i - 1) * nums.get(k) * nums.get(j + 1);
            cost += maxCoinsHelper(i, k - 1, nums, dp) +
                maxCoinsHelper(k + 1, j, nums, dp);
            max = Math.max(max, cost);
        } 
        
        return dp[i][j] = max;
    }
}