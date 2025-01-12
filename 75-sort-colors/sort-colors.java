class Solution {
    public void sortColors(int[] nums) {
        int p1 = 0, p2 = 0, p3 = nums.length - 1;
        while(p2 <= p3) {
            int current = nums[p2];
            if(current == 0) {
                swap(nums, p2++, p1++);
                continue;
            }else if(current == 2) {
                swap(nums, p2, p3--);
                continue;
            }else {
                p2++;
            }
        }
    }

    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp; 
    }
}