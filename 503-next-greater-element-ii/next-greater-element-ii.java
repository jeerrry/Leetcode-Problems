class Solution {
    public int[] nextGreaterElements(int[] nums) {
        var stack = new Stack<Integer>();
        int n = nums.length;
        var result = new int[n];
        for(int i=n*2; i>=0; i--) {
            int val = nums[i%n];
            while(!stack.isEmpty() && stack.peek() <= val) stack.pop();

            int nge = stack.isEmpty() ? -1 : stack.peek();
            result[i % n] = nge;
            stack.push(val);
        }

        return result;
    }
}