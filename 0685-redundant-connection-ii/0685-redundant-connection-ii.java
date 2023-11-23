class Solution {
    private int[] parent;
    private int[] rank;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length + 1;
        int[] indegree = new int[n];
        Arrays.fill(indegree, -1);
        
        int bl1 = -1;
        int bl2 = -1;
        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            if(indegree[v] == -1) {
                indegree[v] = i;
            }else {
                bl1 = i;
                bl2 = indegree[v];
                break;
            }
        }
        
        parent = new int[n];
        rank = new int[n];
        
        for(int i=1; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(int i=0; i<edges.length; i++) {
            if(i == bl1) continue;
            
            int u = edges[i][0];
            int v = edges[i][1];
            
            boolean flag = union(u, v);
            if(!flag) {
                if(bl1 == -1) {
                    // Cycle
                    return edges[i];
                }else {
                    return edges[bl2];
                }
            }
            
        }
        
        return edges[bl1];
    }
    
    private int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    private boolean union(int u, int v) {
        int nu = find(u);
        int nv = find(v);
        
        if(nu == nv) return false;
        
        if(rank[nu] > rank[nv]) {
            parent[nv] = nu;
        }else if(rank[nv] > rank[nu]) {
            parent[nu] = nv;
        }else {
            parent[nv] = nu;
            rank[nu]++;
        }
        
        return true;
    }
}