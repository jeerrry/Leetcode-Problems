class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;
        for(int val : nums) {
            if(val == 1) count++;
            else count = 0;
            result = Math.max(count, result);
        }

        return result;
    }
}