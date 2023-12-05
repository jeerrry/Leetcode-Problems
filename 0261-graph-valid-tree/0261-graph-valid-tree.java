class Solution {
    private int[] rank;
    private int[] parent;
    public boolean validTree(int n, int[][] edges) {
        rank = new int[n];
        parent = new int[n];
        
        for(int i=0; i<n; i++) {
            rank[i] = 1;
            parent[i] = i;
        }
        
        for(int[] edge : edges) {
            int src = edge[0];
            int tar = edge[1];
            
            if(!union(src, tar)) return false;
        }
        
        int parentCount = 0;
        for(int i=0; i<n; i++) {
            if(parent[i] == i) parentCount++;
        }
        
        return parentCount == 1;
    }
    
    private int find(int x) {
        if(parent[x] == x) return x;
        
        return parent[x] = find(parent[x]);
    }
    
    private boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        
        if(px == py) return false;
        
        int rx = rank[px];
        int ry = rank[py];
        
        if(rx > ry) {
            parent[py] = px;
        }else if(ry > rx) {
            parent[px] = py;
        }else {
            parent[py] = px;
            rank[px]++;
        }
        
        return true;
    }
}