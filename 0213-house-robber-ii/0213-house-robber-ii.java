class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(houseRobber(nums, 0, nums.length - 2), houseRobber(nums, 1, nums.length - 1));
    }
    
    private int houseRobber(int[] nums, int start, int end) {
        int fir = nums[start];
        int sec = 0;
        
        for(int i = start + 1; i<=end; i++) {
            if(i == start + 1) {
                sec = Math.max(fir, nums[i]);
                continue;
            }
            
            int result = Math.max(fir + nums[i], sec);
            fir = sec;
            sec = result;
        }
        
        return Math.max(fir, sec);
    }
}