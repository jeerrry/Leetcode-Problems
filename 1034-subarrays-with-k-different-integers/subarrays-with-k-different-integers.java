class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }

    private int helper(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        int count = 0;
        
        int p1 = 0;
        int p2 = 0;
        
        while(p2 < nums.length) {
            int cchar = nums[p2];
            map.put(cchar, map.getOrDefault(cchar, 0) + 1);
            
            // Shrink Window
            while(map.size() > k) {
                int cold = nums[p1];
                map.put(cold, map.getOrDefault(cold, 0) - 1);
                if(map.get(cold) <= 0) map.remove(cold);
                p1++;
            }
            count += (p2 - p1 + 1);
            p2++;
        }
        
        return count;
    }
}