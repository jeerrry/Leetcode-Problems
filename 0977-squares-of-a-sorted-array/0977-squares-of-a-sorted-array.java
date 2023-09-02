class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        
        for(int i=0; i<nums.length; i++) {
            nums[i] *= nums[i];
        }
        
        for(int i=0, k = nums.length-1, j=nums.length-1; i<=j;) {
            int val1 = nums[i];
            int val2 = nums[j];
            
            if(val1 >= val2) {
                result[k--] = nums[i++];
            }else {
                result[k--] = nums[j--];
            }
        }
        
        return result;
    }
}