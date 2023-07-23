class Solution {
    public void wiggleSort(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            boolean isGreater = i%2 == 1 ? true : false;
            
            if(isGreater){
                if(nums[i] < nums[i-1]) {
                    swap(nums, i, i-1);
                }
            }else {
                if(nums[i] > nums[i-1]) {
                    swap(nums, i, i-1);
                }
            }
        }
    }
    
    public void swap(int[] nums, int indexA, int indexB) {
        int temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }
}