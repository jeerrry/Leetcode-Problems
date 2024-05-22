class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = 0;
        for(int val : nums) {
            max = Math.max(max, val);
        }
        
        int low = min;
        int high = max;
        int result = min;
        while(low <= high) {
            int mid = (low + high) / 2;
            int total = divisionSum(nums, mid);
            if(total <= threshold) {
                result = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        
        return result;
    }
    
    public int divisionSum(int[] nums, int divisor) {
        int total = 0;
        for(int val : nums) {
            int result = (int)Math.ceil((val / (double) divisor));
            total += result;
        }
        
        return total;
    }
}