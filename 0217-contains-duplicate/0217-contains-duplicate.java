class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> values = new HashSet<>();
        
        for(int val : nums){
            if(values.contains(val)){
                return true;
            }
            
            values.add(val);
        }
        
        return false;
    }
}