class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] result = new int[cost.length + 1];
        result[0] = cost[0];
        result[1] = cost[1];
        
        for(int i=2; i<cost.length; i++) {
            result[i] = Math.min(result[i-1], result[i-2]) + cost[i];
        }
        
        return Math.min(result[cost.length - 1], result[cost.length - 2]);
    }
}