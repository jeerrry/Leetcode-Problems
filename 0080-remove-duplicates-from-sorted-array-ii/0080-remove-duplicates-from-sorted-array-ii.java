class Solution {
    public int removeDuplicates(int[] nums) {
        int pointer1 = 0;
        int length = 1;
        for(int i=0; i<nums.length; i++) {
            if(i+1 < nums.length && nums[pointer1] == nums[i+1]){
                length++;
                continue;
            }
            if(length >= 2) {
                nums[pointer1++] = nums[i];
                nums[pointer1++] = nums[i];
            }else {
                nums[pointer1++] = nums[i];
            }
            
            if(i + 1 < nums.length){
                nums[pointer1] = nums[i+1];
                length = 1;
            }else {
                pointer1--;
            }
        }
        
        return pointer1 + 1;
    }
}