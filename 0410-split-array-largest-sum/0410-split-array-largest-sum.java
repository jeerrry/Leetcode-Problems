class Solution {
    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int ans = 0;
        
        for(int num : nums) {
            start = Math.max(num, start);
            end += num;
        }
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(splitFound(nums, k, mid)) {
                ans = mid;
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        
        return ans;
    }
    
    private boolean splitFound(int[] nums, int k, int m) {
        int sum = 0;
        int split = 1;
        
        for(int num : nums) {
            sum += num;
            
            if(sum > m) {
                sum = num;
                split++;
            }
        }
        
        return split <= k;
    }
}