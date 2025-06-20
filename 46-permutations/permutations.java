class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, new LinkedHashSet<Integer>(), result);

        return result;
    }

    private void helper(int[] nums, Set<Integer> rsf, List<List<Integer>> result) {
        if(rsf.size() == nums.length) {
            result.add(new ArrayList<>(rsf));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(rsf.contains(nums[i])) continue;
            rsf.add(nums[i]);
            helper(nums, rsf, result);
            rsf.remove(nums[i]);
        }
    }
}