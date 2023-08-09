class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        
        int[] result = new int[nums.length];
        
        int offset = nums.length%2;
        int target = nums.length/2 + offset;
        for(int i=0, pointer = 0; i<target; i++) {
            result[pointer] = nums[i];
            pointer+=2;
        }
        
        for(int i=target, pointer = 1; i<nums.length; i++) {
            result[pointer] = nums[i];
            pointer+=2;
        }
        
        return result;
    }
}