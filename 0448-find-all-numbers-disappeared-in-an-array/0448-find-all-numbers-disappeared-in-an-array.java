class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<nums.length;) {
            int currentValue = nums[i];
            
            if(nums[currentValue - 1] != currentValue){
                int temp = nums[currentValue - 1];
                nums[currentValue -1] = currentValue;
                nums[i] = temp;
                
                continue;
            }
            
            i++;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != i+1) {
                result.add(i+1);
            }
        }
        
        return result;
    }
}