class Solution {
    public int findKthLargest(int[] nums, int k) {
        var heap = new PriorityQueue<Integer>();
        for(int val : nums) {
            heap.add(val);
            if(heap.size() > k) heap.poll();
        }

        return heap.poll();
    }
}