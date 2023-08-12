class Solution {
    public int maxFrequency(int[] nums, int k) {
        int maxFrequency = 0;
        int sum = 0;
        int maxNum = 0;
        
        Arrays.sort(nums);
        
        for(int i=0, j=0; i<nums.length;) {
            maxNum = Math.max(maxNum, nums[i]);
            int size = i - j + 1;
            if(size == 1){
                sum = maxNum;
                maxFrequency = Math.max(maxFrequency, size);
                i++;
            }else{
                sum += nums[i];
                int targetSum = size * maxNum;
                int currentDiff = targetSum - sum;
                if(currentDiff <= k) {
                    maxFrequency = Math.max(maxFrequency, size);
                    i++;
                }else{
                    sum -= nums[j];
                    j++;
                    i++;
                }
            }
        }
        
        
        return maxFrequency;
    }
}