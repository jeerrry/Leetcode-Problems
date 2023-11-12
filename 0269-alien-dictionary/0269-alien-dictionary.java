class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, Integer> indegree = new HashMap<>();
        for(String word : words) {
            for(char c : word.toCharArray()) {
                indegree.put(c, 0);
            }
        }
        
        // Create Graph
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        for(int i=0; i<words.length - 1; i++) {
            String current = words[i];
            String next = words[i + 1];
            boolean found = false;
                        
            int len = Math.min(current.length(), next.length());
            for(int j=0; j<len; j++) {
                char c1 = current.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                  HashSet<Character> set = new HashSet<Character>();
                  if (graph.containsKey(c1))
                    set = graph.get(c1);
                  if (!set.contains(c2)) {
                    set.add(c2);
                    graph.put(c1, set);
                    indegree.put(c2, indegree.get(c2) + 1);
                  }
                  found = true;
                  break;
                }
            }
            
            if(!found && current.length() > next.length()) return "";
        }
        
        // Apply Khan's Algorithm
        LinkedList<Character> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        int count = 0;
        
        for(char ch : indegree.keySet()) {
            if(indegree.get(ch) > 0) continue;
            queue.addLast(ch);
        }
        
        while(queue.size() > 0) {
            char rem = queue.removeFirst();
            ans.append(rem);
            count++;
            
            if(graph.containsKey(rem)) {
                var neighbours = graph.get(rem);
                for(char nbr : neighbours) {
                    indegree.put(nbr, indegree.get(nbr) - 1);
                    if(indegree.get(nbr) > 0) continue;
                    
                    queue.addLast(nbr);
                }
            }
        }
        
        if(count == indegree.size()) return ans.toString();
        return "";
    }
}