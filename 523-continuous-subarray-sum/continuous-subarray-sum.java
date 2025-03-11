class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        var map = new HashMap<Integer, Integer>();

        for(int i=0; i<nums.length; i++) {
            int val = nums[i];
            sum += val;
            int rem = sum % k;

            if(i > 0 && rem == 0) return true;
            if(map.containsKey(rem) && i - map.get(rem) > 1) {
                return true;
            }

            if(!map.containsKey(rem)) map.put(rem, i);
        }

        return false;
    }
}