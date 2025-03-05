class Solution {
    public int numIdenticalPairs(int[] nums) {
        var freq = new int[101];
        for(int val : nums) freq[val]++;

        int result = 0;
        for(int val : freq) {
            int r = val * (val - 1);
            result += (r/2);
        }

        return result;

    }
}