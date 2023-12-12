class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int res1 = maxRob(0, nums.length - 2, nums);
        int res2 = maxRob(1, nums.length - 1, nums);
        
        return Math.max(res1, res2);
        
    }
    
    private int maxRob(int start, int end, int[] src) {
        int length = end - start + 1;
        if(length == 1) return src[start];
        
        int[] result = new int[length + 1];
        result[start] = src[start];
        
        int max = 0;
        for(int i = start + 1; i<=end; i++) {
            result[i] = Math.max(result[i - 1], i - 2 > -1 ? result[i - 2] + src[i] : src[i]);
            max = Math.max(max, result[i]);
        }
        
        return max;
    }
}