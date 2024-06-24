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
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        prev = null;
        flattenHelper(root);
    }
    
    private void flattenHelper(TreeNode node) {
        if(node == null) return;
        
        flattenHelper(node.right);
        flattenHelper(node.left);
        
        node.right = prev;
        node.left = null;
        prev = node;
    }
}