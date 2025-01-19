class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int minRow = 0;
        int minCol = 0;
        int maxRow = matrix.length - 1;
        int maxCol = matrix[0].length - 1;
        int total = matrix.length * matrix[0].length;
        int count = 0;

        var result = new ArrayList<Integer>();
        while(count < total) {
            // Top Row
            for(int i=minCol; i<=maxCol && count < total; i++) {
                result.add(matrix[minRow][i]);
                count++;
            }
            minRow++;

            // Right Col
            for(int i=minRow; i<=maxRow && count < total; i++) {
                result.add(matrix[i][maxCol]);
                count++;
            }
            maxCol--;

            // Bottom Row
            for(int i=maxCol; i>=minCol && count < total; i--) {
                result.add(matrix[maxRow][i]);
                count++;
            }
            maxRow--;

            // Left Col
            for(int i=maxRow; i>=minRow && count < total; i--) {
                result.add(matrix[i][minCol]);
                count++;
            }
            minCol++;
        }

        return result;
    }
}