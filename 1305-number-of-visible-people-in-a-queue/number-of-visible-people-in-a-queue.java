class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        var result = new int[heights.length];
        var stack = new Stack<Integer>();

        for(int i=heights.length - 1; i>=0; i--) {
            int val = heights[i];
            if(stack.isEmpty()) {
                stack.push(i);
                result[i] = 0;
                continue;
            }

            int count = 0;
            while(!stack.isEmpty() && val > heights[stack.peek()]) {
                stack.pop();
                count += 1; 
            }

            if(!stack.isEmpty()) {
                result[i] += count + 1;
            }else {
                result[i] = count;
            }
            stack.push(i);
        }

        return result;
    }
}