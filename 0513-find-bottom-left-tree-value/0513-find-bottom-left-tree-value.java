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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = root.val;
        
        while(queue.size() > 0) {
            int size = queue.size();
            result = queue.peek().val;
            
            for(int i=0; i<size; i++) {
                TreeNode val = queue.remove();
                if(val.left != null) queue.add(val.left);
                if(val.right != null) queue.add(val.right);
            }
        }
        
        return result;
    }
}