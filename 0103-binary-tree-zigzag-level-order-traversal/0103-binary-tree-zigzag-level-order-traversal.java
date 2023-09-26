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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean left = true;
        while(queue.size() > 0) {
            int elementCount = queue.size();
            List<Integer> output = new ArrayList<>();
            
            for(int i=0 ;i<elementCount; i++) {
                TreeNode node = queue.remove();
                if(left) {
                    output.add(node.val);
                }else {
                    output.add(0, node.val);
                }
                
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            
            result.add(output);
            left = !left;
        }
        
        return result;
    }
}