class NumMatrix {
    private final int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=1; j<matrix[0].length; j++) {
                matrix[i][j] += matrix[i][j-1];
            }
        }
        
        for(int i=0; i<matrix[0].length; i++) {
            for(int j=1; j<matrix.length; j++) {
                matrix[j][i] += matrix[j-1][i];
            }
        }
        int i = 0;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = matrix[row2][col2];
        int subtract = 0;
        
        if(row1 > 0) subtract += matrix[row1 -1][col2];
        if(col1 > 0) subtract += matrix[row2][col1 - 1];
        
        if(row1 > 0 && col1 >0) total += matrix[row1-1][col1 - 1];
        
        return total - subtract;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */