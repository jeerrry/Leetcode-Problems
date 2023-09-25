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
    private int MIN_DISTANCE = Integer.MAX_VALUE;
    private TreeNode prev = null;
    
    public int minDiffInBST(TreeNode root) {
        minDiffInBSTHelper(root);
        
        return MIN_DISTANCE;
    }
    
    private void minDiffInBSTHelper(TreeNode current) {
        if(current == null) return;
        
        minDiffInBSTHelper(current.left);
        
        if(prev != null) {
            MIN_DISTANCE = Math.min(MIN_DISTANCE, current.val - prev.val);
        }
        
        prev = current;
        
        minDiffInBSTHelper(current.right);
    }
}