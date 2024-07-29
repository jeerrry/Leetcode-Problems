class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        
        for(var stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        
        int n = maxRow + maxCol + 1;
        
        int[] rank = new int[n + 1];
        int[] part = new int[n + 1];
        for(int i=0; i<=n; i++) part[i] = i;
        
        var map = new HashMap<Integer, Integer>();
        for(var stone : stones) {
            int row = stone[0];
            int col = stone[1] + maxRow + 1;
            
            union(row, col, rank, part);
            map.put(row, 1);
            map.put(col, 1);
        }
        
        int cnt = 0;
        for(var val : map.entrySet()) {
            if(val.getKey() == findParent(val.getKey(), part)) cnt++; 
        }
        
        return stones.length - cnt;
    } 
    
    private int findParent(int x, int[] parent) {
        if(x == parent[x]) return x;
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