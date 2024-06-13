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
        List<TreeNode> path1 = nodePath(root, p);
        List<TreeNode> path2 = nodePath(root, q);
        
        if(path1.size() == 0 || path2.size() == 0) return null;
        
        
        int p1 = path1.size() - 1;
        int p2 = path2.size() - 1;
        
        while(p1 > -1 && p2 > -1) {
            TreeNode a = path1.get(p1);
            TreeNode b = path2.get(p2);
            
            if(a.val == b.val) {
                return a;
            }
            
            if(p1 == p2) {
                p1--;
                p2--;
            }else if(p1 < p2) {
                p2--;
            }else {
                p1--;
            }
        }
        
        return null;
    }
    
    private ArrayList<TreeNode> nodePath(TreeNode root, TreeNode target) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if(root == null) return result;
        
        if(root.val == target.val) {
            result.add(target);
            return result;
        }
        
        var left = nodePath(root.left, target);
        var right = nodePath(root.right, target);
        
        if(left.size() > 0) {
            result.add(root);
            result.addAll(left);
            
            return result;
        }
        
        if(right.size() > 0) {
            result.add(root);
            result.addAll(right);
            
            return result;
        }
        
        return result;
    }
}