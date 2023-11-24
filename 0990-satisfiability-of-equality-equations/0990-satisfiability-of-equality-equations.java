class Solution {
    private int[] parent;
    private int[] rank;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        
        for(int i=0; i<26; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(String equ : equations) {
            if(equ.charAt(1) == '=') {
                union(equ.charAt(0) - 'a', equ.charAt(3) - 'a');
            }
        }
        
        for(String equ : equations) {
            if(equ.charAt(1) == '!') {
                int lx = find(equ.charAt(0) - 'a');
                int ly = find(equ.charAt(3) - 'a');
                
                if(lx == ly) return false;
            }
        }
        
        return true;
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
        }else{
            parent[nv] = nu;
            rank[nu]++;
        }
        
        return true;
    }
}