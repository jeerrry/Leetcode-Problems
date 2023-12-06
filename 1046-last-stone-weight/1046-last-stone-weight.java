class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int num : stones) {
            pq.add(num);
        }
        
        while(pq.size() > 1) {
            int val1 = pq.remove();
            int val2 = pq.remove();
            
            if(val1 - val2 == 0) continue;
            else {
                pq.add(val1 - val2);
            }
        }
        
        return pq.size() == 1 ? pq.peek() : 0;
    }
}