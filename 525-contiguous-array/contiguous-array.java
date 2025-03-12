class Solution {
    public int findMaxLength(int[] nums) {
        var map = new HashMap<Integer, Integer>();

        int prefixSum = 0;
        int result = 0;
        map.put(0, -1);
        for(int i=0; i<nums.length; i++) {
            int val = nums[i];
            prefixSum += nums[i] > 0 ? 1 : -1;

            if(map.containsKey(prefixSum)) {
                result = Math.max(result, i - map.get(prefixSum));
            }else {
                map.put(prefixSum, i);
            }
        }

        return result;
    }
}