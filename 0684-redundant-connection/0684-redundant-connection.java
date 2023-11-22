class Solution {
    private int[] parent;
    private int[] rank; 
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        parent = new int[n];
        rank = new int[n];
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        int[] ans = new int[2];
        for(int[] edge : edges) {
            int src = edge[0];
            int tar = edge[1];
            
            if(!union(src, tar)) {
                ans = edge;
            }
        }
        
        return ans;
    }
    
    private int find(int x) {
        if(parent[x] == x) return x;
        
        return parent[x] = find(parent[x]);
    }
    
    private boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        
        if(pu == pv) return false;
        
        if(rank[pu] > rank[pv]) {
            parent[pv] = pu;
        }else if(rank[pv] > rank[pu]) {
            parent[pu] = pv;
        }else {
            parent[pv] = pu;
            rank[pu]++;
        }
        
        return true;
    }
}