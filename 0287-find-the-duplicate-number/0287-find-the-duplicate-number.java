class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            
            if(slow == fast){
                break;
            }
        }
        
        int check = 0;
        while(true) {
            slow = nums[slow];
            check = nums[check];
            
            if(slow == check) {
                break;
            }
        }
        
        return check;
    }
}