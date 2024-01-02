class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        
        int[] cache = new int[m];
        for(int i=0; i<n; i++) {
            List<Integer> current = triangle.get(i);
            int[] swapBuffer = new int[m];
            for(int j=0; j<current.size(); j++) {
                if(i == 0 && j == 0) {
                    swapBuffer[j] = current.get(j); 
                    continue;
                }else {
                    int lastSize = triangle.get(i - 1).size() - 1;
                    int currentValue = current.get(j);
                    
                    int str = j <= lastSize ? cache[j] : Integer.MAX_VALUE;
                    int dia = j - 1 >= 0 ? cache[j - 1] : Integer.MAX_VALUE;
                    
                    int min = Math.min(str, dia) + currentValue;
                    
                    swapBuffer[j] = min;
                }
            }
            
            cache = swapBuffer;
        }
        
        int result = Integer.MAX_VALUE;
        for(int val : cache) {
            result = Math.min(result, val);
        }
        
        return result;        
    }
    
    private int minHelper(List<List<Integer>> triangle, int row, int col) {
        if(row == triangle.size()) return 0;
        if(col == triangle.get(row).size()) return 0;
        
        int val = triangle.get(row).get(col);
        int min = Integer.MAX_VALUE;        
        min = Math.min(min, minHelper(triangle, row + 1, col) + val);
        min = Math.min(min, minHelper(triangle, row + 1, col + 1) + val);
        
        return min;
    }
}