class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, 0, result, new ArrayList<Integer>());
        
        return result;
    }
    
    public static void permuteHelper(
    int[] nums,
    int idx,
    List<List<Integer>> result,
    List<Integer> rsf) {
        if(idx == nums.length) {
            result.add(new ArrayList<Integer>(rsf));
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == Integer.MIN_VALUE) continue;
            int val = nums[i];
            nums[i] = Integer.MIN_VALUE;
            rsf.add(val);
            permuteHelper(nums, idx + 1, result, rsf);
            rsf.remove(rsf.size() - 1);
            nums[i] = val;
        }
    }
}