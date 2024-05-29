class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int low = 0;
        int high = mat[0].length - 1;
        int[] result = {-1, -1};
        while(low <= high) {
            int mid = (low + high) >> 1;
            int maxRow = maxColumnElement(mat, mid);
            int val = mat[maxRow][mid];
            boolean isPeak = (mid - 1 < 0 || mat[maxRow][mid - 1] < val)
                && (mid + 1 >= mat[0].length || mat[maxRow][mid + 1] < val);
            if(isPeak) return new int[]{maxRow, mid};
            if(val < mat[maxRow][mid + 1]) low = mid + 1;
            else high = mid - 1;
        }
        
        return result;
    }
    
    private int maxColumnElement(int[][] mat, int col) {
        int row = 0;
        int maxVal = -1;
        for(int i=0; i<mat.length; i++) {
            if(mat[i][col] > maxVal) {
                maxVal = mat[i][col];
                row = i;
            }
        }
        
        return row;
    }
}