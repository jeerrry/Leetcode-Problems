class Solution {
    static class Pair {
        public int headId;
        public int time;
        
        public Pair(int headId, int time) {
            this.headId = headId;
            this.time = time;
        }
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<adj.length; i++) adj[i] = new ArrayList<Integer>();
        
        for(int i=0; i<n; i++) {
            if(manager[i] == -1) continue;
            adj[manager[i]].add(i);
        }
        
        int result = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(headID, 0));
        
        while(queue.size() > 0) {
            int count = queue.size();
            
            for(int i=0; i<count; i++) {
                Pair temp = queue.remove();
                result = Math.max(temp.time, result);
                
                for(int child : adj[temp.headId]) {
                    queue.add(new Pair(child, temp.time + informTime[temp.headId]));
                }
                
            }
        }
        
        return result;
    }
}