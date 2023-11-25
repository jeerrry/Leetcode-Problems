class Solution {
    private int[] parent;
    private int[] rank;
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        parent = new int[n];
        rank = new int[n];
        
        var p = parent;
        var r = rank;
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) continue;
                boolean connected = isConnected[i][j] == 1;
                if(!connected) continue;
                
                union(i, j);
            }
        }
        
        int count = 0;
        for(int i=0; i<n; i++) {
            if(find(i) == i) count++;
        }
        
        return count;
    }
    
    private int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        
        if(px == py) return;
        
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
    }
}