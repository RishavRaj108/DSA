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
    int maxi = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int val = find(root);
        return Math.max(val , maxi);
    }
    public int find(TreeNode root){
        if(root == null)return 0;
        int left = Math.max(0 , find(root.left));
        int right = Math.max(0 ,find(root.right));
        int val = root.val;
        maxi = Math.max(maxi , val + left + right);
        int total = val + Math.max(left , right);
        return Math.max(total , val); 
    }
}







