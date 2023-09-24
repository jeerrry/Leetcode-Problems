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
    public String tree2str(TreeNode root) {
        if(root == null) return "";
        
        StringBuilder result = new StringBuilder();
        tree2strHelper(root, result);
        
        return result.toString();
    }
    
    private void tree2strHelper(TreeNode root, StringBuilder output) {
        // Execute for root only
        output.append(root.val+"");

        if(root.left == null && root.right == null){
            return;
        }
        
        if(root.left == null){
            output.append("()");
        }else{
            output.append("(");
            tree2strHelper(root.left, output);
            output.append(")");
        }
        
        if(root.right != null){
            output.append("(");
            tree2strHelper(root.right, output);
            output.append(")");
        }
        
    }
}