class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int minRow = 0;
        int minCol = 0;
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;

        int totalElements = maxRow * maxCol;
        int count = 0;

        List<Integer> result = new ArrayList<>();
        while(count < totalElements) {
            // Process top row
            for(int i=minCol; i<maxCol && count < totalElements; i++) {
                result.add(matrix[minRow][i]);
                count++;
            }
            minRow++;

            for(int i=minRow; i<maxRow && count < totalElements; i++) {
                result.add(matrix[i][maxCol-1]);
                count++;
            }
            maxCol--;

            for(int i=maxCol - 1; i >=minCol && count < totalElements; i--) {
                result.add(matrix[maxRow - 1][i]);
                count++;
            }
            maxRow--;

            for(int i=maxRow - 1; i >= minRow && count < totalElements; i--){
                result.add(matrix[i][minCol]);
                count++;
            }
            minCol++;
        }

        return result;
    }
}