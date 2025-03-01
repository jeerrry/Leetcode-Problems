class Solution {
    public int longestOnes(int[] nums, int k) {
        int length = 0;
        int[] freq = new int[2];
        int start = 0;
        for(int i=0; i<nums.length; i++) {
            int val = nums[i];
            freq[val]++;

            while(freq[0] > k) {
                freq[nums[start++]]--;
            }

            length = Math.max(length, i - start + 1);
        }

        return length;
    }
}