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
        int size;
        boolean perfect;
        Pair(int size , boolean perfect){
            this.size = size;
            this.perfect = perfect;
        }
    }
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        List<Integer> ls = new ArrayList<>();

        dfs(root , ls);
        Collections.sort(ls , Collections.reverseOrder());
        if(ls.size() < k)return -1;
        return ls.get(k - 1);
    } 
    public Pair dfs(TreeNode node , List<Integer> ls){
        if(node == null)return new Pair(0,true);

        Pair left = dfs(node.left , ls);
        Pair right = dfs(node.right , ls);
        if(left.size == right.size && left.perfect && right.perfect){
            int size = left.size + right.size + 1;
            ls.add(size);
            return new Pair(size , true);
        }
        return new Pair(left.size + right.size + 1 , false);
    }
}