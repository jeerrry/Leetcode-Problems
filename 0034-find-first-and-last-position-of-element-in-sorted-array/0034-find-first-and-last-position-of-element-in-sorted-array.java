class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findLow(nums, target), findHigh(nums, target)};
    }
    
    private static int findLow(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] >= target) {
                result = mid;
                high = mid - 1;
                continue;
            }
            low = mid + 1;
        }
        
        return result < 0 || nums[result] != target ? -1 : result;
    }
    
    private static int findHigh(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] <= target) {
                result = mid;
                low = mid + 1;
                continue;
            }
            high = mid - 1;
        }
        
        return result < 0 || nums[result] != target ? -1 : result;
    }
}