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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> mp = new HashMap<>();
        Map<Integer,Integer> parent = new HashMap<>();

        for(int[] desc : descriptions){
            int par = desc[0];
            int child = desc[1];
            int type = desc[2];
            if(!mp.containsKey(par)){
                TreeNode node = new TreeNode(par);
                mp.put(par , node);
            }
            if(!mp.containsKey(child)){
                TreeNode node = new TreeNode(child);
                mp.put(child , node);
            }
            parent.put(child , par);
            TreeNode parentNode = mp.get(par);
            TreeNode childNode = mp.get(child);
            if(type == 0){
              parentNode.right = childNode;
            }else{
              parentNode.left = childNode;
            }
        } 

        for(int node : mp.keySet()){
            if(!parent.containsKey(node)){
                return mp.get(node);
            }
        }
        return null;
    }
}















