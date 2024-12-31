class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        helper(candidates, 0, target, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(int[] nums, int index, int target, List<Integer> rsf, List<List<Integer>> result) {
        if(target < 0) return;
        if(target == 0) {
            result.add(new ArrayList<Integer>(rsf));
            return;
        }
        
        if(index == nums.length) return;
        
        rsf.add(nums[index]);
        helper(nums, index + 1, target - nums[index], rsf, result);
        rsf.remove(rsf.size() - 1);
        
        int current = nums[index];
        while(index < nums.length && current == nums[index]) index++;
        
        helper(nums, index, target, rsf, result);
    }
}