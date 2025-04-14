class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        var deque = new ArrayDeque<Integer>();
        for(int i=0; i<tickets.length; i++) deque.addLast(i);
        
        int time = 0;
        while(!deque.isEmpty() && tickets[k] > 0) {
            int index = deque.removeFirst();
            int val = --tickets[index];
            if(val > 0) deque.addLast(index);
            time++;
        }

        return time;
    }
}