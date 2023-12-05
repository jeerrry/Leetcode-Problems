class Solution {
    private int[] rank;
    private int[] parent;

    public int countComponents(int n, int[][] edges) {
        rank = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        int count = 0;
        for(int[] edge : edges) {
            int src = edge[0];
            int tar = edge[1];
            
            union(src, tar);
        }
        
        for(int i=0; i<n; i++) {
            if(parent[i] != i) continue;
            count++;
        }
        
        return count;
    }

    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return false;

        int rx = rank[px];
        int ry = rank[py];

        if (rx > ry) {
            parent[py] = px;
        } else if (ry > rx) {
            parent[px] = py;
        } else {
            parent[py] = px;
            rank[px]++;
        }

        return true;
    }
}
