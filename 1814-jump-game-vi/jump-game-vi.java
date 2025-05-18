class Solution {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Deque<Integer> deque = new LinkedList();
        deque.addFirst(0);
        dp[0] = nums[0];

        for(int i=1; i<nums.length; i++) {
            if(!deque.isEmpty() && deque.peekFirst() < i - k) deque.removeFirst();

            dp[i] = nums[i] + dp[deque.peekFirst()];

            while(!deque.isEmpty() && dp[deque.peekLast()] < dp[i]) deque.removeLast();

            deque.addLast(i);
        }

        return dp[nums.length - 1];
    }
}