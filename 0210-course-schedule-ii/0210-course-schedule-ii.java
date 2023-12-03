class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : prerequisites) {
            int src = edge[0];
            int tar = edge[1];
            
            graph[src].add(tar);
        }
        
        boolean[] compltd = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> order = new Stack<>();
        
        for(int i=0; i<numCourses; i++) {
            if(visited[i]) continue;
            
            if(!dfs(i, graph, visited, compltd,order)) return new int[0];
        }
        
        int[] result = new int[order.size()];
        int i=order.size() - 1;
        while(order.size() > 0) {
            result[i--] = order.pop();
        }
        
        return result;
    }
    
    private boolean dfs(int src, ArrayList<Integer>[] graph, boolean[] visited, boolean[] compltd, Stack<Integer> st) {
        if(compltd[src]) return true;
        if(visited[src]) return false;
        
        visited[src] = true;
        boolean isSafe = true;
        for(int nbr: graph[src]) {
            isSafe = dfs(nbr, graph, visited, compltd, st);
            if(!isSafe) break;
        }
        
        compltd[src] = isSafe;
        st.push(src);
        
        return isSafe;
    }
}