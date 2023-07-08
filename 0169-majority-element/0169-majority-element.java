class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        
        int currentMaxCount = 1;
        int currentNumber = nums[0];
        
        int maxCount = currentMaxCount;
        int maxNumber = currentNumber;
        
        for(int i=1; i<nums.length; i++) {
            if (nums[i] == currentNumber) {
                currentMaxCount++;
            }else {
                if (currentMaxCount > maxCount){
                    maxNumber = currentNumber;
                    maxCount = currentMaxCount;
                }
                currentNumber = nums[i];
                currentMaxCount = 1;
            }
        }
        
        if (currentMaxCount > maxCount){
            maxNumber = currentNumber;
            maxCount = currentMaxCount;
        }
        
        return maxNumber;
    }
}