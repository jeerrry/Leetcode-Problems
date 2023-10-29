class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(candidates, target, result, new ArrayList<Integer>(), 0);
        
        return result;
    }
    
    private void combinationSumHelper(int[] candidates, int target, List<List<Integer>> tres,
                                     List<Integer> res, int idx) {
        if(target <= 0 || idx >= candidates.length) {
            if(target == 0) {
                tres.add(new ArrayList<Integer>(res));
            }
            
            return;
        }
        
        int num = candidates[idx];
        res.add(num);
        combinationSumHelper(candidates, target - num, tres, res, idx + 1);
        res.remove(res.size() - 1);
        
        while(idx < candidates.length && candidates[idx] == num) {
            idx++;
        }
        
        combinationSumHelper(candidates, target, tres, res, idx);
    }
}