class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // Create Adjacency List
        ArrayList<Integer>[] adjacencyList = new ArrayList[n];
        for(int i=0; i<n; i++) adjacencyList[i] = new ArrayList<Integer>();
        for(int i=0; i<edges.length; i++) {
            adjacencyList[edges[i][0]].add(edges[i][1]);
            adjacencyList[edges[i][1]].add(edges[i][0]);
        }
        
        return minTimeHelper(0, 0,adjacencyList, hasApple);
    }
    
    public int minTimeHelper(int current, int parent, ArrayList<Integer>[] edges, List<Boolean> hasApple) {
        if(current >= edges.length) return 0;
        
        int minTime = 0;
        for(int edge : edges[current]) {
            if(edge == parent) continue;
            int res = minTimeHelper(edge, current, edges, hasApple);
            if(res > 0 || hasApple.get(edge)){
                minTime += res + 2;
            }
        }
        return minTime;
    }
}