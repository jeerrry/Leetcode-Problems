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
      public TreeNode buildTreeRecursive(int[] preorder, int[] inorder, int pStart, int iStart, int pEnd, int iEnd) {
    if (pStart == pEnd) return null;

    TreeNode solution = new TreeNode(preorder[pStart]);
    if (pStart+1 ==pEnd) return solution;

    int count = 0;
    while(inorder[iStart+count] != preorder[pStart]) count++;
  
    solution.left = buildTreeRecursive(
        preorder,
        inorder,
        pStart + 1,
        iStart,
        pStart + count + 1,
        iStart + count
    );
    
    solution.right = buildTreeRecursive(
        preorder,
        inorder,
        pStart + count + 1,
        iStart + count + 1,
        pEnd,
        iEnd
    );
    
    return solution;
}



public TreeNode buildTree(int[] preorder, int[] inorder) {
    
    int n = preorder.length;
    
    return buildTreeRecursive(preorder,inorder,0,0,n,n);
}
}