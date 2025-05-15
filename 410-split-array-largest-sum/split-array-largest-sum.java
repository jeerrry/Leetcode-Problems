class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int val : nums) {
            low = Math.max(val, low);
            high += val;
        }
        
        while(low <= high) {
            int mid = (low + high) / 2;
            int count = getMinSum(nums, mid);
            if(count > k) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        
        return low;
    }
    
    private int getMinSum(int[] nums, int target) {
        int count = 1;
        int sum = 0;
        for(int val : nums) {
            if(sum + val <= target) {
                sum += val;
                continue;
            }
            sum = val;
            count+=1;
        }
        
        return count;
    }
}