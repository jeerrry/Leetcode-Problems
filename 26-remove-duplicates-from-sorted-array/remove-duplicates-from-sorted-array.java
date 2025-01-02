class Solution {
    public int removeDuplicates(int[] nums) {
        int p1 = 0;
        int p2 = 1;

        while(p2 < nums.length) {
            if(nums[p1] == nums[p2]) {
                p2++;
            }else {
                swap(nums, ++p1, p2++);
            }
        }

        return ++p1;
    }

    private void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp; 
    }
}