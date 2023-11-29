class Solution {
    private int edgeCount = 0;
    private boolean[] visited;
    public int minReorder(int n, int[][] connections) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : connections) {
            int src = edge[0];
            int tar = edge[1];
            
            graph[src].add(tar);
            graph[tar].add(-src);
        }
        
        edgeCount = 0;
        visited = new boolean[n];
        transverse(0, graph);
        
        return edgeCount;
    }
    
    private void transverse(int src, ArrayList<Integer>[] graph) {
        visited[src] = true;
        for(int nbr : graph[src]) {
            if(visited[Math.abs(nbr)]) continue;
            
            if(nbr>0)edgeCount++;
            transverse(Math.abs(nbr), graph);
        }
    }
}