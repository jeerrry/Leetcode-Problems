class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int[] result = new int[nums.length + 1];
        result[0] = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            int n2 = i - 2 < 0 ? 0 : result[i-2];
            result[i] = Math.max(result[i-1], n2 + nums[i]);
        }
        
        return Math.max(result[nums.length - 1], result[nums.length - 2]);
    }
}