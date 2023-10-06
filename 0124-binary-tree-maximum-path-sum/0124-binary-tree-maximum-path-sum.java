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
    public static int max;
    
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        return Math.max(maxPathSumHelper(root), max);
    }
    
    public int maxPathSumHelper(TreeNode root) {
        if(root == null) return 0;
        
        int leftSum = Math.max(0, maxPathSumHelper(root.left));
        int rightSum = Math.max(0, maxPathSumHelper(root.right));
        
        int totalSum = root.val + leftSum + rightSum;
        max = Math.max(max, totalSum);
        return root.val + Math.max(leftSum, rightSum);
    }
}