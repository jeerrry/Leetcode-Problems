class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int num : nums) {
            if(!set.contains(num)) {
                set.add(num);
            }
        }
        
        int result = 0;
        
        for(int num : nums) {
            if(set.contains(num-1)) continue;
            
            int len=1;
            for(int j=num+1; set.contains(j); j++) {
                len++;
            }
            
            result = Math.max(result, len);
        }
        
        
        return result;
    }
}