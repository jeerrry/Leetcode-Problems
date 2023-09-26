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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(queue.size() > 0) {
            int count = queue.size();
            
            for(int i=0; i<count; i++) {
                TreeNode node = queue.remove();
                if(node.right != null) queue.add(node.right);
                if(node.left != null) queue.add(node.left);
                
                if(i == 0) {
                    result.add(node.val);
                }
            }
        }
        
        return result;
    }
}