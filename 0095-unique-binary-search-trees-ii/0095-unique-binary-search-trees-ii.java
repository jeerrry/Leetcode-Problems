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
    public List<TreeNode> generateTrees(int n) {
        return generateTreesHelper(1, n);
    }
    
    private List<TreeNode> generateTreesHelper(int left, int right) {
        if(left == right) return Arrays.asList(new TreeNode(left));
        if(left > right) return Arrays.asList(new TreeNode(-1));
        
        List<TreeNode> result = new ArrayList<>();
        for(int i=left; i<=right; i++) {
            for(var leftTree : generateTreesHelper(left, i - 1)) {
                for(var rightTree : generateTreesHelper(i + 1, right)){
                    leftTree = leftTree == null || leftTree.val < 0 ? null : leftTree;
                    rightTree = rightTree == null || rightTree.val < 0 ? null : rightTree;
                    var root = new TreeNode(i, leftTree, rightTree);
                    result.add(root);
                }
            }
        }
        
        return result;
    }
}