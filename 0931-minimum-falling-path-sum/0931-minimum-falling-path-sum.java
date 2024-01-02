class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int result = Integer.MAX_VALUE;
        int[] cache = new int[m];
        for(int i=0; i<n; i++) {
            int tempMin = Integer.MAX_VALUE;
            int[] tempCache = new int[m];
            for(int j=0; j<m; j++) {
                if(i == 0) {
                    tempCache[j] = matrix[0][j];
                    tempMin = Math.min(tempMin, tempCache[j]);
                    continue;
                }
                int current = matrix[i][j];
                int ld = j - 1 >= 0 ? cache[j - 1] : Integer.MAX_VALUE;
                int st = cache[j];
                int rd = j + 1 < m ? cache[j + 1] : Integer.MAX_VALUE;
                
                int min = current + Math.min(ld, Math.min(st, rd));
                tempMin = Math.min(tempMin, min);
                tempCache[j] = min;
            }
            cache = tempCache;
            result = tempMin;
        }
        
        return result;
    }
}