class Solution {

    public int countSquares(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] result = new int[r][c];

        for (int i = 0; i < c; i++) result[0][i] = matrix[0][i];
        for (int i = 0; i < r; i++) result[i][0] = matrix[i][0];

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if(matrix[i][j] == 1) {
                    result[i][j] = 1 + Math.min(result[i - 1][j], Math.min(result[i][j - 1], result[i - 1][j - 1]));
                }
            }
        }
        
        int count = 0;
        for(int[] mat : result) {
            for(int i=0; i<c; i++) {
                count += mat[i];
            }
        }
        
        return count;
    }
}
