class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long total = 0;
        for(long val : nums) {
            if(val == 0) {
                count++;
            }else {
                total += (count * (count + 1)) / 2;
                count = 0;
            }
        }

        if(count > 0) total += (count * (count + 1)) / 2;

        return total;
    }
}