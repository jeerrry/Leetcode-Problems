class Solution {
    public int removeDuplicates(int[] nums) {
        int pointer1 = 0;
        int currentNumber = nums[0];
        
        for(int i=1; i<nums.length; i++){
            if(nums[i] == currentNumber) continue;
            nums[pointer1++] = currentNumber;
            currentNumber = nums[i];
            
            if(i == nums.length - 1) nums[pointer1++] = currentNumber;
        }
        
        if(pointer1 == 0) return 1;
        
        if(pointer1 < nums.length && nums[pointer1 - 1] != nums[nums.length-1]) {
            nums[pointer1++] = nums[nums.length - 1];
        }
        
        return pointer1;
    }
}