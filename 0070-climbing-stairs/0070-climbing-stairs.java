class Solution {
    public int climbStairs(int n) {
        int[] steps = new int[n + 2];
        steps[0] = 0;
        steps[1] = 1;
        steps[2] = 1;
        
        for(int i=2; i<=n; i++) {
            steps[i] += steps[i - 1];
            steps[i] += steps[i - 2];
        }
        
        return steps[n];
    }
}