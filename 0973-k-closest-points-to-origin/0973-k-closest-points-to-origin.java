class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) ->
            Integer.compare(
                (b[0] * b[0] + b[1] * b[1]),
                (a[0] * a[0] + a[1] * a[1])
            )
        );
        
        for(int[] point : points) {
            queue.add(point);
            
            while(queue.size() > k) queue.remove();
        }
        
        int[][] result = new int[k][2];
        for(int i=0; i<k; i++) {
            int[] point = queue.remove();
            result[i][0] = point[0];
            result[i][1] = point[1];
        }
        
        return result;
    }
}