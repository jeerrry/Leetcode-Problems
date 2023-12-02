class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodes = graph.length;
        int[] visited = new int[nodes];
        
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nodes; i++) {
            if(visited[i] != 0) continue;
            dfs(i, visited, graph);
        }
        
        for(int i=0; i<visited.length; i++) {
            if(visited[i] == 3) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    private void dfs(int src, int[] visited , int[][] graph) {
        if(visited[src] == 1) {
            visited[src] = 2;
            return;
        }
        if(visited[src] == 3 || graph[src].length == 0) {
            visited[src] = 3;
            return;
        }
        
        visited[src] = 1;
        boolean isSafe = true;
        for(int tar : graph[src]) {
            dfs(tar, visited, graph);
            isSafe = isSafe && visited[tar] == 3;
            if(!isSafe) break;
        }
        
        visited[src] = isSafe ? 3 : 2;
    }
}