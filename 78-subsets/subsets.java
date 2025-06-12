class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> rsf = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<Integer>());
        helper(nums, 0, rsf, result);

        return result;
    }

    private void helper(int[] nums, int index, List<Integer> rsf, List<List<Integer>> result) {
        if(index == nums.length) return;
        
        for(int i=index; i<nums.length; i++) {
            rsf.add(nums[i]);
            result.add(new ArrayList<Integer>(rsf));
            helper(nums, i + 1, rsf, result);
            rsf.remove(rsf.size() - 1);
        }
    }
}