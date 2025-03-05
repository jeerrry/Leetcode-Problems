class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();

        for(int i=0; i<nums.length; i++) {
            int lastIndex = map.getOrDefault(nums[i], -1);

            if(lastIndex == -1) {
                map.put(nums[i], i);
                continue;
            }

            if(Math.abs(lastIndex - i) <= k) return true;
            else {
                map.put(nums[i], i);
            }
        }

        return false;
    }
}