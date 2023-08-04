class Solution {
    public void moveZeroes(int[] nums) {
        int p1 = 0;
        for(int i = 1; i<nums.length && p1<nums.length;) {
            if(nums[p1] != 0) {
                p1++;
                continue;
            }
            
            if(i <= p1 || nums[i] == 0) {
                i++;
                continue;
            }
            
            swap(nums, i, p1++);
        }
    }
    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}