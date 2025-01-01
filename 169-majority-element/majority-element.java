class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for(int val : nums) {
            if(count == 0) {
                candidate = val;
                count++;
                continue;
            }

            if(val == candidate) count++;
            else count--;
        }

        return candidate;
    }
}