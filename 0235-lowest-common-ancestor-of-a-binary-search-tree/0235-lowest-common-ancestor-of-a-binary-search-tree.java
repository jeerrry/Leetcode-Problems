/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> p1 = NodeToRoot(root, p);
        ArrayList<TreeNode> p2 = NodeToRoot(root, q);
        
        int i = p1.size() - 1;
        int j = p2.size() - 1;
        
        while(i >=0 && j >= 0 && p1.get(i).val == p2.get(j).val) {
            i--;
            j--;
        }
        
        return p1.get(i+1);
    }
    
    private ArrayList<TreeNode> NodeToRoot(TreeNode root, TreeNode target) {
        if(root == null) return new ArrayList<TreeNode>();
        
        ArrayList<TreeNode> result = new ArrayList<>();
        
        if(target.val == root.val) {
            result.add(target);
            return result;
        }else if(target.val < root.val) {
            result = NodeToRoot(root.left, target);
        }else {
            result = NodeToRoot(root.right, target);
        }
        
        result.add(root);
        
        return result;
    }
}