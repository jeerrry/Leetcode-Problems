class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        subsets(nums, 0, result, new ArrayList<Integer>());
        return result;
    }
    
    private static void subsets(int[] nums, int idx, List<List<Integer>> result, List<Integer> rsf) {
        if(idx == nums.length) {
            result.add(new ArrayList<Integer>(rsf));
            return;
        }
        
        subsets(nums, idx + 1, result, rsf);
        
        rsf.add(nums[idx]);
        subsets(nums, idx + 1, result,rsf);
        rsf.remove(rsf.size() - 1);
    }
}