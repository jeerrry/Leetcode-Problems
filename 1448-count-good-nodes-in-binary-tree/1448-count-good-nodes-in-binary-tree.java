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
    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root, root.val);
    }
    
    private int goodNodesHelper(TreeNode root, int maxSoFar) {
        if(root == null) return 0;
        
        int count = maxSoFar <= root.val ? 1 : 0;
        maxSoFar = Math.max(maxSoFar, root.val);
        
        count += goodNodesHelper(root.left, maxSoFar);
        count += goodNodesHelper(root.right, maxSoFar);
        
        return count;
    }
}