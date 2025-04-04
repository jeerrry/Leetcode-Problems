class Solution {
    public int maximalRectangle(char[][] matrix) {
        var temp = new int[matrix[0].length];
        int result = 0;

        for(char[] current : matrix) {
            for(int i=0; i<current.length; i++) {
                temp[i] = current[i] - '0' > 0 ? temp[i] + 1 : 0;
            }

            result = Math.max(result, largestRectangleArea(temp));
        }

        return result;
    }

    private int largestRectangleArea(int[] heights) {
        var stack = new Stack<int[]>();
        int result = 0;

        for(int i=0; i<heights.length; i++) {
            var current = new int[]{i, heights[i]};
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                var popped = stack.pop();
                int area = popped[1] * (i - popped[0]);

                result = Math.max(area, result);
                current[0] = popped[0]; 
            }

            stack.push(current);
        }

        int maxLength = heights.length;
        while(!stack.isEmpty()) {
            var val = stack.pop();
            int area = (maxLength - val[0]) * val[1];
            result = Math.max(result, area);
        }

        return result;
    }
}