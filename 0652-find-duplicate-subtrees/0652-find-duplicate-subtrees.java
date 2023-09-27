/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    List<TreeNode> result = new ArrayList<>(); 
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        MapTree(root);
        
        return result;
    }
    
    private String MapTree(TreeNode root) {
        if(root == null) {
            return "N";
        }
        
        String left = MapTree(root.left);
        String right = MapTree(root.right);        
        String current = root.val + " " + left + " " + right;
        
        map.put(current, map.getOrDefault(current, 0) + 1);
        
        if(map.get(current) == 2) result.add(root);
        
        return current;
    }
}