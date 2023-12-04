class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] pre : prerequisites) {
            int src = pre[0];
            int tar = pre[1];
            
            graph[tar].add(src);
        }
        
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<numCourses; i++) {
            dfs(i, visited, graph, map);
        }
        
        List<Boolean> result = new ArrayList<>();
        for(int[] query : queries) {
            int src = query[0];
            int tar = query[1];
            
            result.add(map.get(tar).contains(src));
        }
        
        return result;
    }
    
    private HashSet<Integer> dfs(int src, boolean[] visited, ArrayList<Integer>[] graph, HashMap<Integer, HashSet<Integer>> map) {
        if(visited[src]) {
            return map.get(src);
        }
        
        HashSet<Integer> set = map.getOrDefault(src, new HashSet<Integer>());
        visited[src] = true;
        for(int vtx : graph[src]) {
            set.add(vtx);
            set.addAll(dfs(vtx, visited, graph, map));
        }
        map.put(src, set);
        return set;
    }
}