class Solution {
    public int removeElement(int[] nums, int val) {
        int pointerA = 0;
        int pointerB = nums.length-1;
        int k = 0;
        
        while(pointerA <= pointerB){
            if (nums[pointerA] != val) {
                pointerA++;
                k++;
            } else {
                if (nums[pointerB] == val) {
                    pointerB--;
                }else{
                    swap(nums, pointerA, pointerB);
                }
            }
        }
        
        return k;
    }
    
    public void swap(int[] nums, int indexA, int indexB) {
        int temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }
}