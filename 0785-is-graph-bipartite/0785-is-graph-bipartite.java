class Solution {
    public boolean isBipartite(int[][] graph) {
        var colors = new int[graph.length];
        Arrays.fill(colors, -1);
        
        for(int i=0; i<colors.length; i++) {
            if(colors[i] == -1) {
                if(!isBipartite(i, 0, graph, colors)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isBipartite(int src, int color, int[][] grid, int[] colors) {
        var edges = grid[src];
        colors[src] = color;
        var nColor = color == 0 ? 1 : 0;
        for(int edge : edges) {
            if(colors[edge] == color) return false;
            if(colors[edge] > -1) continue;
            
            if(!isBipartite(edge, nColor, grid, colors)) return false;
        }
        
        return true;
    }
}