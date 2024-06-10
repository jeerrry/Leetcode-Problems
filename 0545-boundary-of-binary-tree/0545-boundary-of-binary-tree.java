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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        if(root.left != null || root.right != null) {
            result.add(root.val);
        }
        
        result.addAll(getLeftBoundry(root.left));
        result.addAll(getLeafNodes(root));
        result.addAll(getRightBoundry(root.right));
        
        return result;
    }
    
    public List<Integer> getLeftBoundry(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        while(node != null) {
            if(node.left == null && node.right == null) break;
            result.add(node.val);
            if(node.left != null) node = node.left;
            else node = node.right;
        }
        
        return result;
    }
    
    public List<Integer> getLeafNodes(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if(node == null) return result;
        
        if(node.left == null && node.right == null) {
            result.add(node.val);
            return result;
        }
        
        result.addAll(getLeafNodes(node.left));
        result.addAll(getLeafNodes(node.right));
        
        return result;
    }
    
    public List<Integer> getRightBoundry(TreeNode node) {
        List<Integer> result = new LinkedList<>();
        while(node != null) {
            if(node.left == null && node.right == null) break;
            result.add(0, node.val);
            if(node.right != null) {
                node = node.right;
            }else {
                node = node.left;
            }
        }
        
        return result;
    }
}