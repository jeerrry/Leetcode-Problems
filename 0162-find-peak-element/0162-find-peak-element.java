class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int move = isPeakElement(nums, mid);
            
            if(move == 0) {
                return mid;
            }else if(move == -1) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private int isPeakElement(int[] nums, int i) {
        if(i < 0 || i >= nums.length) return 0;
        
        int currentVal = nums[i];
        if(i - 1 >= 0 && nums[i-1] >= currentVal) {
            return -1;
        }
        
        if(i + 1 < nums.length && nums[i + 1] >= currentVal) {
            return 1;
        }
        
        return 0;
    }
}