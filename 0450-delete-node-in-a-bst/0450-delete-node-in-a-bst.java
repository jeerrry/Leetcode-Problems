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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        
        TreeNode result = null;
        
        if(key == root.val) {
            // Apply Deletion Principles
            if(root.left == null && root.right == null) {
                root = null;
                return root;
            }else if (root.right == null) {
                root = root.left;
                return root;
            }else if(root.left == null) {
                root = root.right;
                return root;
            }else {
                TreeNode follow = null;
                TreeNode successor = root.right;
                while(successor.left != null ){
                    follow = successor;
                    successor = successor.left;
                }
                
                if(follow == null) {
                    successor.left = root.left;
                    root = successor;
                    return root;
                }else {
                    if(successor.right != null) {
                        follow.left = successor.right;
                    }else {
                        follow.left = null;
                    }
                    
                    successor.left = root.left;
                    successor.right = root.right;
                    
                    return successor;
                }
            }
        }else if(key < root.val) {
            result = deleteNode(root.left, key);
            root.left = result;
        }else {
            result = deleteNode(root.right, key);
            root.right = result;
        }
        
        return root;
    }
}