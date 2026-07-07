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
    int[] maxi = new int[1];
    public int maxAncestorDiff(TreeNode root) {
        maxi[0] = Integer.MIN_VALUE;
        find(root , Integer.MAX_VALUE);
        return maxi[0];
    }
    public int find(TreeNode root,int mini){
        if(root ==  null)return mini;
        mini = Math.min(mini , root.val);
        int minVal = Math.min(find(root.left , mini) , find(root.right , mini));
        maxi[0] = Math.max(maxi[0] , root.val - minVal);
        return minVal;
    }
}