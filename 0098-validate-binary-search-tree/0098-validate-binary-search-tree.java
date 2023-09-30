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
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root).isBST;
    }
    
    public BSTPair isValidBSTHelper(TreeNode root) {
        if(root == null) {
            return new BSTPair(Long.MAX_VALUE, Long.MIN_VALUE, true);
        }
        
        BSTPair left = isValidBSTHelper(root.left);
        BSTPair right = isValidBSTHelper(root.right);
        
        var result = new BSTPair();
        result.isBST = left.isBST && right.isBST
            && root.val > left.max
            && root.val < right.min;
        
        result.min = Math.min(root.val, Math.min(left.min, right.min));
        result.max = Math.max(root.val, Math.max(left.max, right.max));
        
        return result;
    }
    
    public static class BSTPair {
        public long min;
        public long max;
        public boolean isBST;
        
        public BSTPair(){}
        public BSTPair(long min, long max, boolean isBST) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
}