class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var map = new HashSet<Integer>();
        
        for(int i=0; i<nums.length; i++) {
            int val = nums[i];
            
            if(map.size() - 1==k) map.remove(nums[i - k - 1]);
            
            if(map.contains(val)) return true;
            else map.add(val);
        }
        
        return false;
    }
}