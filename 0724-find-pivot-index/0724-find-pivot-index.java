class Solution {
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        
        int pivot = -1;
        int leftSum = 0;
        for(int i=0; i<nums.length; i++) {
            int currentTotal = total - nums[i] - leftSum;
            if(leftSum == currentTotal) {
                return i;
            }
            
            leftSum += nums[i];
        }
        
        return pivot;
    }
}