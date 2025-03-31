class Solution {
    public long subArrayRanges(int[] nums) {
        long maxSum = sumSubarrayMaxs(nums);
        long minSum = sumSubarrayMins(nums);
        return maxSum - minSum;
    }

    private long sumSubarrayMins(int[] arr) {
        int[] pse = pseMin(arr);
        int[] nse = nseMin(arr);

        long result = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            long contrib = (long) left * right * arr[i];
            result += contrib;
        }

        return result;
    }

    private long sumSubarrayMaxs(int[] arr) {
        int[] pge = pgeMax(arr);
        int[] nge = ngeMax(arr);

        long result = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i - pge[i];
            int right = nge[i] - i;

            long contrib = (long) left * right * arr[i];
            result += contrib;
        }

        return result;
    }

    private int[] pseMin(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return result;
    }

    private int[] nseMin(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return result;
    }

    private int[] pgeMax(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return result;
    }

    private int[] ngeMax(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return result;
    }
}
