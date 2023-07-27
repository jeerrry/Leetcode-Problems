class Solution {
    public boolean checkPossibility(int[] nums) {
        for(int i=1, checked = 0; i < nums.length; i++) {
            if(nums[i-1] > nums[i]){
                if(checked++ == 1) return false;
                if(i < 2 || nums[i-2] <= nums[i]) nums[i-1] = nums[i];
                else nums[i] = nums[i-1];
            }
        }
        
        return true;
    }
}