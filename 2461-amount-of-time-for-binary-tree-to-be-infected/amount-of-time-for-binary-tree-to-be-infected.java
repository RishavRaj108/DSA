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
    public int amountOfTime(TreeNode root, int start) {
        TreeNode nodee = find(start,root);
        Map<TreeNode , TreeNode> par = new HashMap<>();
        par.put(root , null);
        buildMap(par , root);

        Queue<TreeNode> q = new LinkedList<>();

        q.add(nodee);
        int time = -1;
        Set<Integer> infected = new HashSet<>();
        infected.add(start);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i < size;i++){
                TreeNode node = q.poll();
                if(node.left != null && !infected.contains(node.left.val)){
                    q.add(node.left);
                    infected.add(node.left.val);
                }
                if(node.right != null && !infected.contains(node.right.val)){
                    q.add(node.right);
                    infected.add(node.right.val);
                }
                TreeNode parent = par.get(node);
                if(parent != null && !infected.contains(parent.val)){
                    q.add(parent);
                    infected.add(parent.val);
                }  
            }
            time++;
        }
        return time;
    }
    public void buildMap(Map<TreeNode , TreeNode> par , TreeNode root){
        if(root == null)return;
        if(root.left != null){
          par.put(root.left , root);
          buildMap(par , root.left);
        }
        if(root.right != null){
           par.put(root.right , root);
           buildMap(par , root.right);
        }
    }
    public TreeNode find(int start , TreeNode root){
        if(root == null)return null;
        if(root.val == start)return root;

        TreeNode left = find(start , root.left);
        TreeNode right = find(start , root.right);

        if(left != null)return left;
        return right;
    }
}












