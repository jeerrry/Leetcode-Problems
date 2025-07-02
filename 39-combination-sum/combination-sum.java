class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        helper(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void helper(int[] array, int index, int target, List<Integer> rsf, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(rsf));
            return;
        }
        if(target < 0) return;
        if(index == array.length) return;
        
        rsf.add(array[index]);
        helper(array, index, target - array[index], rsf, result);
        rsf.remove(rsf.size() - 1);
        
        helper(array, index + 1, target, rsf, result);
    }
}