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
    private class Pair{
        public TreeNode node = null;
        public int visits;
        
        public Pair(int visits, TreeNode node){
            this.visits = visits;
            this.node = node;
        }
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(0, root));
        
        while(stack.size() > 0) {
            Pair p = stack.peek();
            
            switch(p.visits){
                case 0:
                    if(p.node.left != null){
                        stack.push(new Pair(0, p.node.left));
                    }
                    break;
                case 1:
                    if(p.node.right != null){
                        stack.push(new Pair(0, p.node.right));
                    }
                    break;
                case 2:
                    result.add(p.node.val);
                    stack.pop();
                    break;
            }
            p.visits++;
        }
        
        return result;
    }
}