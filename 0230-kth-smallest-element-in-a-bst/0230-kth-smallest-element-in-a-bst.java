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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedCollection = new ArrayList<Integer>();
        
        kthSmallestHelper(root, sortedCollection);
        return sortedCollection.get(k - 1);
    }
    
    private void kthSmallestHelper(TreeNode root, List<Integer> vals) {
        if(root == null) return;
        
        kthSmallestHelper(root.left, vals);
        vals.add(root.val);
        kthSmallestHelper(root.right, vals);
    }
}