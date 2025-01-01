class Solution {
    public void moveZeroes(int[] nums) {
        int p1 = 0;
        int p2 = 0;

        while(p2 < nums.length) {
            if(Math.abs(nums[p2]) > 0) {
                swap(nums, p1, p2);
                p1++;
            }
            p2++;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}