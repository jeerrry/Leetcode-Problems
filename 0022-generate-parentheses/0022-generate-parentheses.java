class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        
        return result;
    }

    private void backtrack(List<String> result, String rsf, int left, int right, int n) {
        if(rsf.length() ==  2 * n) {
            result.add(rsf);
            return;
        }
        
        if(left < n) {
            backtrack(result, rsf + "(", left + 1, right, n);
        }
        
        if(left > right) {
            backtrack(result, rsf + ")", left, right + 1, n);
        }
    }
}