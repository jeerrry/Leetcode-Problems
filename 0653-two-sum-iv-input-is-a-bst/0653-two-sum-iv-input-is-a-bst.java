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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> vals = inorder(root);
        int i=0;
        int j=vals.size() - 1;
        
        while(i < j) {
            int a = vals.get(i);
            int b = vals.get(j);
            
            if(a + b == k) return true;
            if(a + b < k) i++;
            else j--;
        }
        
        return false;
    }
    
    private List<Integer> inorder(TreeNode root) {
       List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        result.addAll(inorder(root.left));
        result.add(root.val);
        result.addAll(inorder(root.right));
        
        return result;
    }
}