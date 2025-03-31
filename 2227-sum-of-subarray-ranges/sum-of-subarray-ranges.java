class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarray(nums, true) - sumSubarray(nums, false);
    }

    private long sumSubarray(int[] arr, boolean isMax) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Previous greater/smaller
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && (
                isMax ? arr[stack.peek()] < arr[i] : arr[stack.peek()] > arr[i]
            )) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next greater/smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && (
                isMax ? arr[stack.peek()] <= arr[i] : arr[stack.peek()] >= arr[i]
            )) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long contrib = (long) (i - left[i]) * (right[i] - i) * arr[i];
            sum += contrib;
        }

        return sum;
    }
}
