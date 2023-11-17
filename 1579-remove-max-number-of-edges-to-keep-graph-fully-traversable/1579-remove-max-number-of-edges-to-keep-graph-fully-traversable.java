class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] parenta = new int[n + 1];
        int[] parentb = new int[n + 1];
        int[] ranka = new int[n + 1];
        int[] rankb = new int[n + 1];
        
        for(int i=0; i<=n; i++) {
            parenta[i] = parentb[i] = i;
        }
        
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
        
        int mergeda = 1;
        int mergedb = 1;
        int removed = 0;
        
        for(int[] edge : edges) {
            if(edge[0] == 3){
                boolean ans1 = union(edge[1], edge[2], parenta, ranka);
                boolean ans2 = union(edge[1], edge[2], parentb, rankb);
                
                mergeda += (ans1 ? 1 : 0);
                mergedb += (ans2 ? 1 : 0);
                removed += (!ans1 && !ans2) ? 1 : 0;
            }else if(edge[0] == 1) {
                boolean ans1 = union(edge[1], edge[2], parenta, ranka);
                
                mergeda += (ans1 ? 1 : 0);
                removed += (!ans1) ? 1 : 0;
            }else {
                boolean ans2 = union(edge[1], edge[2], parentb, rankb);
                
                mergedb += (ans2 ? 1 : 0);
                removed += (!ans2 ? 1 : 0);
            }
        }
        
        if(mergeda != n || mergedb != n) return -1;
        
        return removed;

    }
    
    private int find(int x, int[] parent) {
        if(parent[x] == x) {
            return x;
        }
        
        parent[x] = find(parent[x], parent);
        return parent[x];
    }
    
    private boolean union(int x, int y, int[] parent, int[] rank) {
        int xx = find(x, parent);
        int yy = find(y, parent);
        
        if(xx == yy) return false;
        
        if(rank[xx] > rank[yy]) {
            parent[yy] = xx;
        }else if(rank[yy] > rank[xx]) {
            parent[xx] = yy;
        }else {
            parent[yy] = xx;
            rank[xx] += 1;
        }
        
        return true;
    }
}