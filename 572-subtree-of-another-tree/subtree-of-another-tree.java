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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        int value = subRoot.val;
        List<TreeNode> ls = new ArrayList<>();
        getAllNodes(root , ls,value);
        for(TreeNode node : ls){
            if(check(node , subRoot)){
                return true;
            }
        }
        return false;
    }
    public boolean check(TreeNode root , TreeNode subRoot){
        if(root == null && subRoot == null)return true;
        if(root == null || subRoot == null)return false;
        boolean res = false;
        if(root.val == subRoot.val){
          boolean left = check(root.left , subRoot.left);
          boolean right = check(root.right , subRoot.right);
          if(left && right)return true;
        }
        return res;
    }
    public void getAllNodes(TreeNode node , List<TreeNode> ls , int value){
        if(node == null)return;
        if(node.val == value)ls.add(node);
        getAllNodes(node.left , ls,value);
        getAllNodes(node.right , ls, value);
    }
}