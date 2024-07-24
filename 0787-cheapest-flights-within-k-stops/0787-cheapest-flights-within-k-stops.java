class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        
        // Create Graph
        for(int[] edge : flights) {
            int sr = edge[0];
            int tr = edge[1];
            int pr = edge[2];
            
            graph[sr].add(new int[]{tr, pr});
        }
        
        // Init Cost Array
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        //var pq = new PriorityQueue<int[]>((x, y) -> x[1] - y[1]);
        Queue<int[]> pq = new LinkedList<>();
        pq.add(new int[]{src, 0, 0});
        
        while(!pq.isEmpty()) {
            int[] data = pq.remove();
            int sr = data[0];
            int cprc = data[1];
            int stops = data[2];
            if(stops > k) continue;
            
            var edges = graph[sr];
            for(var edge : edges) {
                int tar = edge[0];
                int cst = edge[1];
                int ncost = cst + cprc;
                
                if(ncost < cost[tar] && stops <= k) {
                    cost[tar] = ncost;
                    pq.add(new int[]{tar, ncost, stops + 1});
                }
            }
        }
        
        
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}