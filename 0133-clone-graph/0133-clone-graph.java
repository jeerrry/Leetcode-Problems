/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer, Node> graph = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(graph.containsKey(node.val)) return graph.get(node.val);
        
        var nnode = new Node(node.val, new ArrayList<>());
        graph.put(node.val, nnode);
        for(Node nbr : node.neighbors) {
            nnode.neighbors.add(cloneGraph(nbr));
        }
        
        return nnode;
    }
}