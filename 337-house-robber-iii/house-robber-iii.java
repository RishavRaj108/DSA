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
    Map<TreeNode , Integer> mp ;
    public int rob(TreeNode root) {
        // we can rob houses level by level
        mp = new HashMap<>();
        return find(root);
    }
    public int find(TreeNode root){
        if(root == null)return 0;
        if(mp.containsKey(root))return mp.get(root);
        // we are having 2 options we can take this or skip this
        int take = root.val;
        if(root.left != null){
            take += find(root.left.left);
            take += find(root.left.right);
        }
        if(root.right != null){
            take += find(root.right.right);
            take += find(root.right.left);
        }
        // we can skip this
        int noTake = find(root.left) + find(root.right);
        int maxi = Math.max(take , noTake);
        mp.put(root , maxi);
        return maxi;
    }
}