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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(queue.peek() != null) {
            TreeNode node = queue.poll();
            
            queue.add(node.left);
            queue.add(node.right);
        }
        
        while(queue.size() > 0 && queue.peek() == null) queue.remove();
        
        return queue.size() == 0;
    }
}