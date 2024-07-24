class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        
        for(int[] time : times) {
            int src = time[0] - 1;
            int dst = time[1] - 1;
            int dly = time[2];
            
            graph[src].add(new int[]{dst, dly});
        }
        
        int[] delay = new int[n];
        Arrays.fill(delay, Integer.MAX_VALUE);

        var pq = new PriorityQueue<int[]>((x, y) -> x[1] - y[1]);
        delay[k - 1] = 0;
        pq.add(new int[]{k - 1, 0});
        
        while(!pq.isEmpty()) {
            int[] data = pq.remove();
            int src = data[0];
            int sdelay = data[1];
            
            var nbrs = graph[src];
            for(var nbr : nbrs) {
                int tar = nbr[0];
                int tdelay = nbr[1];
                
                int totalDelay = sdelay + tdelay;
                if(totalDelay < delay[tar]) {
                    delay[tar] = totalDelay;
                    pq.add(new int[]{tar, totalDelay});
                }
            }
        }

        int result = 0;
        for(int val : delay) result = Math.max(val, result);
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}