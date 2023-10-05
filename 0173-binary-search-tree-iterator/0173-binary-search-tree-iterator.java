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
class BSTIterator {
    private Stack<Pair> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        if(root!=null) stack.push(new Pair(root, 0));
    }
    
    public int next() {
        while(stack.size() > 0) {
            Pair top = stack.peek();
            TreeNode node = top.node;
            if(top.count == 0) {
                
                TreeNode leftChild = node.left;
                while(leftChild != null) {
                    stack.push(new Pair(leftChild, 1));
                    leftChild = leftChild.left;
                }
                
                top.count += 1;
                
            }else{
                
                stack.pop();
                if(node.right != null) {
                    stack.push(new Pair(node.right, 0));
                }
                return node.val;
            }
        }
        
        return 0;
    }
    
    public boolean hasNext() {
        return stack.size() > 0;
    }
    
    private static class Pair {
        public TreeNode node;
        public int count;
        
        public Pair(TreeNode node, int count) {
            this.node = node;
            this.count = count;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */