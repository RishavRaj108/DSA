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
    int maxim = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return maxim;
    }
    public int findMax(TreeNode root){
        if(root == null)return 0;
        if(root.left == null && root.right == null){
            maxim = Math.max(maxim , root.val);
           return root.val;
        } 
        int leftVal = findMax(root.left);
        int rightVal = findMax(root.right);
        leftVal = Math.max(0,leftVal);
        rightVal = Math.max(0 , rightVal);

        maxim = Math.max(maxim , root.val + leftVal + rightVal);

        return root.val + Math.max(leftVal , rightVal);
    }
}