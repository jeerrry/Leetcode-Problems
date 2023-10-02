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
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, "");
    }
    
    private int sumNumbersHelper(TreeNode root, String psf) {
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return Integer.parseInt(psf + root.val);
        }
        
        int leftSum = sumNumbersHelper(root.left, psf + root.val);
        int rightSum = sumNumbersHelper(root.right, psf + root.val);
        
        return leftSum + rightSum;
    }
}