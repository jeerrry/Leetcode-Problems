class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findLow(nums, target), findHigh(nums, target)};
    }
    
    public int findLow(int[] nums, int target) {
        int idx = -1;
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            int value = nums[mid];
            
            if(value == target) idx = mid;
            if(value >= target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        
        return idx;
    }
    
    public int findHigh(int[] nums, int target) {
        int idx = -1;
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            int value = nums[mid];
            
            if(value == target) idx = mid;
            if(value <= target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        
        return idx;
    }
}