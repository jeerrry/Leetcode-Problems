class Solution {
    private HashMap<String, PriorityQueue<String>> graph;
    private LinkedList<String> ans;
    public List<String> findItinerary(List<List<String>> tickets) {
        graph = new HashMap<>();
        ans = new LinkedList<>();
        
        for(List<String> ticket : tickets) {
            String src = ticket.get(0);
            String des = ticket.get(1);
            
            var pq = graph.getOrDefault(src, new PriorityQueue<String>());
            pq.add(des);
            
            graph.put(src, pq);
        }
        
        dfs("JFK");
        return ans;
    }
    
    private void dfs(String src) {
        PriorityQueue<String> target = graph.get(src);
        
        while(target != null && target.size() > 0) {
            String des = target.remove();
            dfs(des);
        }
        
        ans.addFirst(src);
    }
}