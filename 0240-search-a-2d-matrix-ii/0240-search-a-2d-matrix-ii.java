class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0) {
            int currentVal = matrix[row][col];
            if(currentVal == target) return true;
            if(currentVal < target) row++;
            else col--;
        }
        
        return false;
    }
}