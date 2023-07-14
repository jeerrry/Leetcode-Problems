class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        int sum = 1;
        
        for(int i=0; i<nums.length; i++) {
            result[i] = sum;
            sum*=nums[i];
        }
        
        sum = 1;
        for(int i=nums.length-1; i>=0; i--){
            result[i]*=sum;
            sum*=nums[i];
        }
        
        return result;
    }
}