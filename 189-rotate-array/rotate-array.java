class Solution {
    public void rotate(int[] nums, int k) {
        int rotations = k % nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, rotations - 1);
        rotate(nums, rotations, nums.length - 1);
    }

    private void rotate(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}