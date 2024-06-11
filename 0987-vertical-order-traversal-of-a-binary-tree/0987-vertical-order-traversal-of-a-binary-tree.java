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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Object[]> queue = new LinkedList<>();
        queue.add(new Object[]{root, 0, 0});
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i=0; i<size; i++) {
                Object[] vals = queue.remove();
                TreeNode node = (TreeNode)vals[0];
                int index = (int)vals[1];
                int level = (int)vals[2];

                if(!map.containsKey(index)) map.put(index, new TreeMap<Integer, PriorityQueue<Integer>>());
                var pq = map.get(index).getOrDefault(level, new PriorityQueue<Integer>());
                pq.add(node.val);
                map.get(index).put(level, pq);
                
                if(node.left != null) queue.add(new Object[]{node.left, index - 1, level + 1});
                if(node.right != null) queue.add(new Object[]{node.right, index + 1, level + 1});
            }                        
        }
        
        for(var val : map.values()) {
            List<Integer> res = new ArrayList<>();
            for(var pq : val.values()) {
                while(!pq.isEmpty()) {
                    res.add(pq.poll());
                }
            }
            
            result.add(res);
        }
        
        return result;
    }
}