class Solution {
    public int minimizeMax(int[] nums, int p) {
        if(p == 0) return 0;
        
        Arrays.sort(nums);
        int low = 0;
        int high = (int)Math.pow(10, 9);
        int result = high;
        
        while(low<=high) {
            int mid = low + (high - low) / 2;
            
            if(isValid(mid, nums, p)) {
                result = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        
        return result;
        
    }
    
    private boolean isValid(int threshold, int[] nums, int targetCount) {
        int count = 0;
        for(int i=0; i<nums.length - 1;) {
            int diff = Math.abs(nums[i] - nums[i + 1]);
            if(diff <= threshold) {
                i+=2;
                count+=1;
                continue;
            }
            i++;
        }
        
        return count >= targetCount;
    }
}