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
    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2 == 0) {
            return new ArrayList<>();
        }
        
        if(n == 1) {
            return Arrays.asList(new TreeNode(0));
        }
        
        List<TreeNode> result = new ArrayList<>();
        for(int i=1; i<n; i+=2) {
            var left = allPossibleFBT(i);
            var right = allPossibleFBT(n - i - 1);
            
            for(var l : left) {
                for(var r : right) {
                    TreeNode node = new TreeNode(0, l, r);
                    result.add(node);
                }
            }
        }
        
        return result;
    }
}