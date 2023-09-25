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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }
        
        TreeNode result = null;
        
        if(val > root.val) {
            result = insertIntoBST(root.right, val);
            root.right = result;
        }else if(val < root.val) {
            result = insertIntoBST(root.left, val);
            root.left = result;
        }
        
        return root;
    }
}