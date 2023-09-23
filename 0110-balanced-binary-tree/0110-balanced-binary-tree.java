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
    public boolean isBalanced(TreeNode root) {
        balance(root);
        
        return maxBalance <= 1;
    }
    
    private int maxBalance = 0;
    public int balance(TreeNode root) {
        if(maxBalance >= 2) return 2;
        if(root == null) return 0;
        
        int leftBalance = balance(root.left);
        int rightBalance = balance(root.right);
        
        int absDiff = Math.abs(leftBalance - rightBalance);
        maxBalance = Math.max(maxBalance, absDiff);
        
        return Math.max(leftBalance, rightBalance) + 1;
    }
}