class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low < high) {
            int mid = low + (high - low ) / 2;
            int midVal = nums[mid];
            int highVal = nums[high];
            
            if(midVal <= highVal) {
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        
        return nums[low];
    }
}