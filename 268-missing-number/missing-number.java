class Solution {
    public int missingNumber(int[] nums) {
        int currentSum = 0;
        int n = nums.length;
        for(int val : nums) {
            //n = Math.max(n, val);
            currentSum += val;
        }

        int total = (n*(n+1)/2);
        return total - currentSum;
    }
}