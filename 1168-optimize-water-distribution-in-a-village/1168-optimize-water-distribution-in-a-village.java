class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        ArrayList<int[]>[] graph = new ArrayList[n + 1];
        for(int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<pipes.length; i++) {
            int u = pipes[i][0];
            int v = pipes[i][1];
            int wt = pipes[i][2];
            
            graph[u].add(new int[]{u, v, wt});
            graph[v].add(new int[]{v, u, wt});
        }
        
        for(int i=0; i<wells.length; i++) {
            graph[0].add(new int[]{0, i+1, wells[i]});
            graph[i + 1].add(new int[]{i + 1, 0, wells[i]});
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        queue.add(new int[]{0, 0, 0});
        boolean[] visited = new boolean[n + 1];
        int ans = 0;
        
        while(queue.size() > 0) {
            int[] rem = queue.remove();
            if(visited[rem[1]]) continue;
            
            visited[rem[1]] = true;
            ans += rem[2];
            
            for(int[] vtx : graph[rem[1]]) {
                if(visited[vtx[1]]) continue;
                
                queue.add(vtx);
            }
        }
        
        return ans;
    }
}