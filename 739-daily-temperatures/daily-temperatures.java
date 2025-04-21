class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        var result = new int[temperatures.length];
        var stack = new Stack<Integer>();
        stack.push(0);

        for(int i=0; i<result.length; i++) {
            int temp = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] < temp) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }

            stack.push(i);
        }

        return result;
    }
}