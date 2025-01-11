class Solution {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++) {
            int val = nums[i];
            int key = target - val;
            if(map.containsKey(key)) {
                int index = map.get(key);
                return new int[]{i, index};
            }

            map.put(val, i);
        }

        return result;
    }
}