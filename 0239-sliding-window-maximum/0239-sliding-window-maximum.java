class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i=0, j =0; i<nums.length; i++) {
            int currentVal = nums[i];
            
            if(i - j + 1 <= k) {
                while(deque.size() > 0 && currentVal > deque.peekLast()) {
                    deque.pollLast();
                }
                
                deque.addLast(currentVal);
            }
            
            if (i - j + 1 == k) {
                if (deque.size() > 0) {
                    result.add(deque.peekFirst());
                    int old = nums[j++];
                    if (old == deque.peekFirst()) {
                        deque.removeFirst();
                    }
                }
            }
        }
        
        int[] res = new int[result.size()];
        
        for(int i = 0; i<res.length; i++) {
            res[i] = result.get(i);
        }
        
        return res;
    }
}