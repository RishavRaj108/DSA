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
        return build(preorder , 0,inorder.length -1);
    }
    public TreeNode build(int[] preorder , int s , int e){
        if(s > e) return null;

        int value = preorder[preInd++];
        TreeNode node = new TreeNode(value);
        int ind = inorderInd.get(value);
        node.left = build(preorder , s , ind - 1);
        node.right = build(preorder , ind + 1 , e);
        return node;
    }
}










