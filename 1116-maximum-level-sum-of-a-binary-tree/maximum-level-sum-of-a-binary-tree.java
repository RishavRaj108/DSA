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
    public int maxLevelSum(TreeNode root) {
        // we need to return the level
        // root is level 1
        // level order traversat use queue
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            int sum = 0;
            for(int i = 0;i < size;i++){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null)q.add(node.left);
                if(node.right != null)q.add(node.right);
            }
            if(sum > max){
                ans = level;
                max = sum;
            }
        }
        return ans;
    }
}
















