class Solution {
    static class Pair {
        public TreeNode node;
        public int num;
        public int level;
        
        public Pair(TreeNode node, int num, int level) {
            this.node = node;
            this.num = num;
            this.level = level;
        } 
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 1, 0));
        int maxWidth = 1;
        
        while(queue.size() > 0) {
            int count = queue.size();
            int currentWidth = 0;
            
            for(int i=0; i<count; i++) {
                Pair temp = queue.remove();
                
                if(temp.node == null) continue;
                if(currentWidth == 0) currentWidth = temp.num;
                maxWidth = Math.max(temp.num - currentWidth + 1, maxWidth);
                
                queue.add(new Pair(temp.node.left, temp.num * 2, temp.level + 1));
                queue.add(new Pair(temp.node.right, temp.num * 2 + 1, temp.level + 1));
                
            }
        }
        
        return maxWidth;
    }
}