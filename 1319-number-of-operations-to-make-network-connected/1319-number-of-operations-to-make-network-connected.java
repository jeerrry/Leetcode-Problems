class Solution {
    public int makeConnected(int n, int[][] connections) {
        int[] rank = new int[n];
        int[] part = new int[n];
        for(int i=0; i<n; i++) part[i] = i;

        int count = 0;
        for(var connection : connections) {
            boolean used = union(connection[0], connection[1], rank, part);
            if(!used) count++;
        }
        
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(i == part[i])ans++;
        }
        
        ans -= 1;
        if(count >= ans) return ans;
        return -1;
    }
    
    private int findParent(int x, int[] parent) {
        if(parent[x] == x) return x;
        
        return parent[x] = findParent(parent[x], parent);
    }
    
    private boolean union(int x, int y, int[] rank, int[] parent) {
        int px = findParent(x, parent);
        int py = findParent(y, parent);
        
        if(px == py) return false;
        if(rank[px] <= rank[py]) {
            rank[py] += 1;
            parent[px] = py;
            return true;
        }
        
        rank[px] += 1;
        parent[py] = px;
        
        return true;
    }
}