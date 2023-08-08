class Solution {
    public int numSubseq(int[] nums, int target) {
        int count = 0;
        int mod = 1_000_000_007;
        int[] power = new int[nums.length];
        
        power[0] = 1;
        for(int i=1; i<power.length; i++) power[i] = (power[i-1] * 2)%mod;
        
        Arrays.sort(nums);
        
        int pointer1 = 0;
        int pointer2 = nums.length-1;
        
        while(pointer1 <= pointer2) {
            int val1 = nums[pointer1];
            int val2 = nums[pointer2];
            
            if(val1 + val2 <= target) {
                int targetIndex = pointer2 - pointer1;
                
                if(targetIndex>=0 && targetIndex<nums.length){
                    count = (count + power[targetIndex])%mod;
                }
                pointer1++;
            }else{
                pointer2--;
            }
        }
        
        return count;
    }
}