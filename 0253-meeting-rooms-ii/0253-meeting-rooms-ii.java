class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals[0][1]);
        
        for(int i=1; i<intervals.length; i++) {
            int[] current = intervals[i];
            int lastEnd = queue.peek();
            if(current[0] >= lastEnd) {
                queue.poll();
            }
            
            queue.add(current[1]);
        }
        
        return queue.size();
    }
}