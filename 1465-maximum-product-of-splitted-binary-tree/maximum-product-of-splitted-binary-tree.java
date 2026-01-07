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
    long total = 0;
    long maxP = Integer.MIN_VALUE;
    public int sum(TreeNode root){
        if(root == null)return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    public long find(TreeNode root){
        if(root == null)return 0;

        long left = find(root.left);
        long right = find(root.right);
        
        long sum = root.val + left + right;
        maxP = Math.max(maxP , (total - sum) * sum);
        return sum;
    }

    public int maxProduct(TreeNode root) {
        total = sum(root);

        // now find the max product by finding the each subtree sum
        // use stack for dfs traversal
        find(root);
        return (int) (maxP % 1000000007);
    }
}