class Solution {
    public int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];
        int val = 1;
        for(int i=0; i<nums.length; i++) {
            result[i] = val;
            val *= nums[i];
        }

        val = 1;
        for(int i = nums.length - 1; i>= 0; i--) {
            result[i] *= val;
            val *= nums[i];
        }

        return result;
    }
}