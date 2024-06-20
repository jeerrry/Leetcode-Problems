/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root == null) return new ArrayList<Integer>();
        HashMap<TreeNode, TreeNode> parents = getParents(root);
        return bfs(target, parents, k);
    }
    
    private HashMap<TreeNode, TreeNode> getParents(TreeNode root) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        if(root == null) return parents;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            
            if(node.left != null) {
                parents.put(node.left, node);
                queue.add(node.left);
            }
            
            if(node.right != null) {
                parents.put(node.right, node);
                queue.add(node.right);
            }
        }
        
        return parents;
    }
    
    private List<Integer> bfs(TreeNode target, HashMap<TreeNode, TreeNode> parents, int k) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(target);
        int distance = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                TreeNode node = queue.remove();
                if(visited.contains(node.val)) continue;
                
                if(distance == k){
                    result.add(node.val);
                    continue;
                }
                visited.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                if(parents.containsKey(node)) queue.add(parents.get(node));
            }
            distance++;
            if(distance > k) break;
        }
        
        return result;
    }
}