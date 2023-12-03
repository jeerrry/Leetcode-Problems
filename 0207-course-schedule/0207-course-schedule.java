class Solution {
    private boolean[] completed;
    private HashSet<Integer> visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : prerequisites) {
            int src = edge[0];
            int tar = edge[1];
            
            graph[src].add(tar);
        }
        
        completed = new boolean[numCourses];
        visited = new HashSet<Integer>();
        
        for(int i=0; i<numCourses; i++) {
            dfs(i, graph);
        }
        
        for(boolean cors : completed) {
            if(!cors) return false;
        }
        
        return true;
    }
    
    private boolean dfs(int src, ArrayList<Integer>[] graph) {
        int edgeCount = graph[src].size();
        if(completed[src]) return true;
        if(visited.contains(src)) return false;
        
        boolean isSafe = true;
        visited.add(src);
        for(int nbr : graph[src]) {
            isSafe = dfs(nbr, graph);
            if(!isSafe) break;
        }
        
        completed[src] = isSafe;
        
        return isSafe;
    }
}