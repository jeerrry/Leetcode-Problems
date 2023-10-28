class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, result, new ArrayList<Integer>());
        
        return result;
    }
    
    public static void combinationSumHelper(
        int[] candidates,
        int target,
        int cidx,
        List<List<Integer>> cres,
        List<Integer> rsf) {
        if(target <= 0 || cidx == candidates.length) {
            if(target == 0) {
                cres.add(new ArrayList<Integer>(rsf));
            }
            return;
        }
        
        int candidate = candidates[cidx];
        rsf.add(candidate);
        combinationSumHelper(candidates, target - candidate, cidx, cres, rsf);
        
        rsf.remove(rsf.size() - 1);
        combinationSumHelper(candidates, target, cidx + 1, cres, rsf);
    }
}