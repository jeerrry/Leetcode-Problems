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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
        if(postorder.length == 1) return new TreeNode(postorder[0]);
        
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        
        // Find Root
        int rootIndex = -1;
        for(int i=0;i < inorder.length; i++) {
            if(inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        
        if(rootIndex == -1) return root;
        
        int[] leftHalfIn = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] leftHalfPost = Arrays.copyOfRange(postorder, 0, leftHalfIn.length);
        
        int[] rightHalfIn = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        int[] rightHalfPost = Arrays.copyOfRange(postorder, leftHalfIn.length, inorder.length - 1);
        
        root.left = buildTree(leftHalfIn, leftHalfPost);
        root.right = buildTree(rightHalfIn, rightHalfPost);
        
        return root;
    }
}