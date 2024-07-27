class Solution {
    public int countPaths(int n, int[][] roads) {
        List<long[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<long[]>();
        
        for(var road : roads) {
            long src = road[0];
            long tar = road[1];
            long dis = (long)road[2];
            
            graph[(int)src].add(new long[]{tar, dis});
            graph[(int)tar].add(new long[]{src, dis});
        }
        
        long mod = (int)(1e9 + 7);
        long[] distance = new long[n];
        long[] ways = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        Arrays.fill(ways, 0);
        
        var pq = new PriorityQueue<long[]>((x, y) -> Long.compare(x[1], y[1]));
        distance[0] = 0;
        ways[0] = 1;
        pq.add(new long[]{0, 0});
        
        while(!pq.isEmpty()) {
            long[] node = pq.remove();
            int src = (int)node[0];
            long dis = node[1];
            
            var edges = graph[src];
            for(long[] edge : edges) {
                int tar = (int)edge[0];
                long ndis = edge[1];
                
                if(dis + ndis < distance[tar]) {
                    distance[tar] = dis + ndis;
                    pq.add(new long[]{tar, distance[tar]});
                    ways[tar] = ways[src];
                }                
                else if(dis + ndis == distance[tar]) {
                    ways[tar] = (ways[tar] + ways[src]) % mod;
                }
            }
        }
        
        return (int)(ways[n - 1]  % mod);
    }
}