class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pointer=0;
        int pointer2 = 1;
        int[] result = new int[nums.length];
        for(int i=0; i < nums.length; i++) {
            int val = nums[i];
            if(val < 0) {
                result[pointer2] = nums[i];
                pointer2+=2;
            }else {
                result[pointer] = nums[i];
                pointer+=2;
            }
        }

        return result;
    }
}