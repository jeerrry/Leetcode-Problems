class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1, k, n, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void helper(int num, int count, int target, List<Integer> rsf, List<List<Integer>> result) {
        if(target == 0 && count == 0) {
            result.add(new ArrayList<Integer>(rsf));
            return;
        }
        
        if(target < 0) return;
        if(count < 0) return;
        if(num > 9) return;
        
        rsf.add(num);
        helper(num + 1, count - 1, target - num, rsf, result);
        rsf.remove(rsf.size() - 1);
        
        helper(num + 1, count, target, rsf, result);
    }
}