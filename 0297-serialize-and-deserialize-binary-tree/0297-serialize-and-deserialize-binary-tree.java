/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private int index;
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return String.join(",", serializeHelper(root));
    }
    
    private List<String> serializeHelper(TreeNode root) {
        if(root == null) {
            return Arrays.asList("N");
        }
        
        var result = new ArrayList<String>();
        result.add(root.val+"");
        result.addAll(serializeHelper(root.left));
        result.addAll(serializeHelper(root.right));
        
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        
        String[] input = data.split(",");
        return deserializeHelper(input);
    }
    
    public TreeNode deserializeHelper(String[] data) {
        if(data[index].equals("N")) {
            index++;
            return null;
        }
        
        String value = data[index++];
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deserializeHelper(data);
        node.right = deserializeHelper(data);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));