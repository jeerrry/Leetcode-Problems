class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        
        if(n == 1) return triangle.get(0).get(0);
        
        int result = Integer.MAX_VALUE;
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
                    
                    if(i == n - 1) {
                        result = Math.min(result, min);
                    }
                    swapBuffer[j] = min;
                }
            }
            
            cache = swapBuffer;
        }
        
        return result;        
    }
}