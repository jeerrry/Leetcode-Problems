class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1) return;

        int index = nums.length - 2;
        while(index >= 0) {
            if(nums[index] < nums[index + 1]) {
                break;
            }
            index--;
        }

        // Return Reverse
        if(index == -1) {
            for(int i=0, j=nums.length - 1; i<j; i++, j--) {
                swap(nums, i, j);
            }

            return;
        }

        for(int i=nums.length - 1; i>index; i--) {
            if(nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        for(int i=index + 1, j=nums.length - 1; i<j; i++, j--) {
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}