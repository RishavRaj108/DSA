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
    public TreeNode replaceValueInTree(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        root.val = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<TreeNode> ls = new ArrayList<>();
            int sum = 0;
            for(int i = 0;i < size;i++){
                TreeNode node = q.poll();
                ls.add(node.left);
                ls.add(node.right);
                if(node.left != null){
                    q.add(node.left);
                    sum += node.left.val;
                }
                if(node.right != null){
                    q.add(node.right);
                    sum += node.right.val;
                }
            }

            for(int i = 0;i < ls.size();i++){
                TreeNode n1 = ls.get(i);
                i++;
                TreeNode n2 = ls.get(i);
                int s = 0;
                if(n1 != null) s += n1.val;
                if(n2 != null) s += n2.val;
                if(n1 != null) n1.val = sum - s;
                if(n2 != null) n2.val = sum - s; 
            }
        }
        return root;
    }
}















