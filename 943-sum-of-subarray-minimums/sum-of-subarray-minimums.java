class Solution {
    public int sumSubarrayMins(int[] arr) {
        var pse = pse(arr);
        var nse = nse(arr);
        var mod = (int) (1e9 + 7);

        int result = 0;
        for(int i=0; i<arr.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            result = (int) ((result + (1L * left * right % mod) * arr[i] % mod) % mod);
        }

        return result;
    }

    private int[] nse(int[] arr) {
        var stack = new Stack<Integer>();
        var result = new int[arr.length];
        for(int i=arr.length - 1; i>=0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }

        return result;
    }

    private int[] pse(int[] arr) {
        var stack = new Stack<Integer>();
        var result = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return result;
    }
}