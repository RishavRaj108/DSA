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
    int preInd = 0;
    Map<Integer , Integer> inorderInd;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderInd = new HashMap<>();
        for(int i = 0;i < inorder.length;i++){
           inorderInd.put(inorder[i] , i);
        }
        return construct(preorder , 0 , inorder.length - 1);
    }
    public TreeNode construct(int[] preorder , int start , int end){
        if(start > end)return null;
        int value = preorder[preInd++];
        TreeNode root = new TreeNode(value);
        root.left = construct(preorder , start , inorderInd.get(value) - 1);
        root.right = construct(preorder ,inorderInd.get(value) + 1,end);
        return root;
    }
}












