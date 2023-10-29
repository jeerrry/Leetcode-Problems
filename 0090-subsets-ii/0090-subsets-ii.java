class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, 0, result, new ArrayList<Integer>());
        
        return result;
    }
    
    public static void subsetsWithDupHelper(int[] nums, int idx, List<List<Integer>> tres, List<Integer> res) {
        if(idx == nums.length) {
            tres.add(new ArrayList<Integer>(res));
            return;
        }
        
        int num = nums[idx];
        res.add(num);
        subsetsWithDupHelper(nums, idx + 1, tres, res);
        res.remove(res.size() - 1);
        
        while(idx < nums.length && nums[idx] == num) {
            idx++;
        }
        
        subsetsWithDupHelper(nums, idx, tres, res);
    }
}