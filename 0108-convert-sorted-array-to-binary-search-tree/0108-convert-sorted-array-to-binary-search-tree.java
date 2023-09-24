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
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBSTHelper(nums, 0, nums.length - 1);
    }
    
    private TreeNode arrayToBSTHelper(int[] nums, int low, int high){
        if(low > high || high < low) return null;
        if(low == high) return new TreeNode(nums[low], null, null);
        
        int mid = low + (high - low) /2 ;
        TreeNode node = new TreeNode(nums[mid]);
        
        TreeNode left = arrayToBSTHelper(nums, low, mid - 1);
        TreeNode right = arrayToBSTHelper(nums, mid + 1, high);
        
        node.left = left;
        node.right = right;
        
        return node;
    } 
}