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
    class Pair{
        int node;
        boolean valid;
        Pair(int node , boolean valid){
            this.node = node;
            this.valid = valid;
        }
    }
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        // traverse the tree dfs pass list where we are going to store the perfect tree size
        // in dfs traversal two parametrs left size and right size the moment both equal add it to list
        List<Integer> ls = new ArrayList<>();
        dfs(root,true , ls);
        Collections.sort(ls);
        if(ls.size() < k)return  -1;
        return ls.get(ls.size() - k);
    }
    public Pair dfs(TreeNode node,boolean valid , List<Integer> ls){
        if(node.left == null && node.right == null){
            ls.add(1);
           return new Pair(1 , true);
        } 
        int leftPart = 0;
        boolean check = false;
        if(node.left != null){
            Pair leftPa = dfs(node.left ,valid , ls);
            leftPart = leftPa.node;
            check = leftPa.valid;
        }
        int rightPart = 0;
        if(node.right != null){
            Pair rightPa = dfs(node.right ,valid , ls);
            rightPart = rightPa.node;
            check = check == true? rightPa.valid : false;
        }
        int cnt = rightPart + leftPart + 1;
        if(leftPart == rightPart && check){
            ls.add(cnt);
            return new Pair(cnt , true);
        }
        return new Pair(cnt , false); 
    }
}















