class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=1; i<=numRows; i++) {
            result.add(generateRow(i));
        }

        return result;
    }

    private List<Integer> generateRow(int n) {
        int ans = 1;
        var row = new ArrayList<Integer>();
        row.add(ans);

        for(int col = 1; col < n; col++) {
            ans = ans * (n - col);
            ans = ans / col;

            row.add(ans);
        }

        return row;
    }
}