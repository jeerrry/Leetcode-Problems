class Solution {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for(int val : nums) set.add(val);

        int length = 0;
        for(int val : set) {
            if(set.contains(val - 1)) continue;

            int temp = val;
            int llen = 1;
            while(set.contains(temp + 1)) {
                temp++;
                llen++;
            }

            length = Math.max(length, llen);
        }

        return length;
    }
}