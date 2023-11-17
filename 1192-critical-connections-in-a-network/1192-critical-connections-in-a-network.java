class Solution {
    private int time;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections)
    {
        // Code here
        time = 0;
        int[] low = new int[n];
        int[] dis = new int[n];
        boolean[] visited = new boolean[n];
        List<List<Integer>> bridges = new ArrayList<>();
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        for(List<Integer> edge : connections) {
            int src = edge.get(0);
            int tar = edge.get(1);
            
            adj.get(src).add(tar);
            adj.get(tar).add(src);
        }
        
        dfs(-1, 0, adj, bridges, low, dis, visited);
        
        return bridges;
    }
    
    private void dfs(int parent, int src, List<List<Integer>> adj, List<List<Integer>> bridges, int[] low, int[] dis, boolean[] visited) {
        dis[src] = low[src] = time++;
        visited[src] = true;

        for(int edge : adj.get(src)) {
            if(edge == parent) continue;
            if(visited[edge]) {
                low[src] = Math.min(low[src], low[edge]);
            }else {
                dfs(src, edge, adj, bridges, low, dis, visited);
                low[src] = Math.min(low[src], low[edge]);
                if(low[edge] > dis[src]) {
                    bridges.add(Arrays.asList(src, edge));
                }
            }
        }
    } 
}