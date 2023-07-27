class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < 0) {
                nums[i] = 0;
            }
        }
        
        for(int val : nums) {
            int targetIndex = Math.abs(val) - 1; 
            
            if(targetIndex < 0 || targetIndex >= nums.length) {
                continue;
            }else {
                if(nums[targetIndex] > 0){
                    nums[targetIndex] = -nums[targetIndex];
                }
                
                if(nums[targetIndex] == 0) {
                    nums[targetIndex] = -(nums.length + 1);
                }  
            }
        }
        
        int missingNum = nums.length + 1;
        for(int i=1; i<=nums.length; i++) {
            if(nums[i-1] > 0 || nums[i-1] == 0) {
                return i;
            }
        }
        
        return missingNum;
    }
}