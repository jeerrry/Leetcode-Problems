class Solution {
    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        
        k%=nums.length;
        
        for(int i=0; i<nums.length; i++) {
            int targetIndex = (i+k)%nums.length;
            result[targetIndex] = nums[i];
        }
        
        for(int i=0; i<nums.length; i++) {
            nums[i] = result[i];
        }
    }
}