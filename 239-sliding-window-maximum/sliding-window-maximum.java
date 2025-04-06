class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        var result = new int[nums.length - k + 1];
        Deque<int[]> deque = new ArrayDeque();
        int index = 0;

        for(int i=0, j=0; j<nums.length; j++) {
            int val = nums[j];

            if(deque.isEmpty()) {
                deque.addLast(new int[]{val, j});
            } else {
                while(!deque.isEmpty() && deque.peekLast()[0] < val) {
                    deque.removeLast();
                }

                deque.addLast(new int[]{val, j});
            }

            if(j - i + 1 == k) {
                result[index++] = deque.peekFirst()[0];
                while(!deque.isEmpty() && deque.peekFirst()[1] <= i) deque.removeFirst();
                i++;
            }
        }

        return result;
    }
}