class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        result.add(new ArrayList<>(Arrays.asList(1)));
        
        for(int i = 1; i<numRows; i++) {
            var copyList = new ArrayList<Integer>(result.get(result.size()-1));
            copyList.add(0,0);
            copyList.add(0);
            var row = new ArrayList<Integer>();
            for(int j=0; j<copyList.size() - 1; j++) {
                row.add(copyList.get(j) + copyList.get(j+1));
            }
            result.add(row);
        }
        
        return result;
    }
}