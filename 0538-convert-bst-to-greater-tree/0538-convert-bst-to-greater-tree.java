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
    public TreeNode convertBST(TreeNode root) {
        convertBSTHelper(root, 0);
        
        return root;
    }
    
    
    private int convertBSTHelper(TreeNode root, int ssf) {
        if(root == null) return ssf;
        
        int currentSum = convertBSTHelper(root.right, ssf);
        currentSum += root.val;
        root.val = currentSum;
        currentSum = convertBSTHelper(root.left, currentSum);
        
        return currentSum;
    }
}