class Solution {
    public void sortColors(int[] nums) {
        int pointer1 = 0;
        int pointer2 = 0;
        int pointer3 = nums.length-1;
        
        while(pointer2 <= pointer3){
            if(nums[pointer1] == 0) {
                pointer1++;
                pointer2 = pointer1 > pointer2 ? pointer2 + 1 : pointer2;
                continue;
            }
            
            if(nums[pointer2] == 1) {
                pointer2++;
                continue;
            }
            
            if(nums[pointer3] == 2){
                pointer3--;
                continue;
            }else{
                if(nums[pointer3] == 0) swap(nums, pointer3, pointer1);
                else swap(nums, pointer3, pointer2);
            }
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}