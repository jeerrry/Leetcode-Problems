class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> r2 = new HashSet<>();
        
        for(int num : nums2) {
            if(r2.contains(num)) continue;
            r2.add(num);
        }
        
        HashSet<Integer> r1 = new HashSet<>();
        for(int num : nums1) {
            if(r1.contains(num)) continue;
            r1.add(num);
        }
        
        List<Integer> result2 = new ArrayList<>();
        for(int num : r1) {
            if(r2.contains(num)) {
                r2.remove(num);
                continue;
            }
            
            result2.add(num);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(result2);
        result.add(new ArrayList<>(r2));
        
        return result;
    }
}