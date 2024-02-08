class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxHeight = 0;
        for(int i=0; i<heights.length; i++) {
            if(stack.size() == 0) {
                stack.push(new int[]{i, heights[i]});
            }else{
                int[] pop = new int[0];
                int[] current = new int[]{i, heights[i]};
                
                while(stack.size() > 0 && stack.peek()[1] > heights[i]) {
                    pop = stack.pop();
                    int poppedArea = i - pop[0];
                    poppedArea *= pop[1];
                    maxHeight = Math.max(maxHeight, poppedArea);
                }
                
                if(pop.length > 0) {
                    current[0] = pop[0];
                }
                
                stack.push(current);
            }
        }
        
        int maxLength = heights.length - 1;
        while(stack.size() > 0) {
            int[] val = stack.pop();
            int currentVal = maxLength - val[0] + 1;
            currentVal *= val[1];
            maxHeight = Math.max(maxHeight, currentVal);
        }
        
        return maxHeight;
    }
}