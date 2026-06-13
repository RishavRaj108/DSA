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
        int smaOEql;
        int greOEql;
        Pair(int n , int m){
            this.smaOEql = n;
            this.greOEql = m;
        } 
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> ls = new ArrayList<>();

        // inorder traversal
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            ls.add(curr.val);
            curr = curr.right;
        }
        List<List<Integer>> res = new ArrayList<>();
        // now i need to find lb and ub for each queriy
        for(int quer : queries){
            Pair p = binarySrch( quer , ls);
            List<Integer> list = new ArrayList<>();
            list.add(p.smaOEql);
            list.add(p.greOEql);
            res.add(list);
        }
        return res;
    }
    public Pair binarySrch(int target , List<Integer> ls){
        int left = 0;
        int right = ls.size() - 1;
        Pair p = new Pair(-1,-1);
        while(left <= right){
           int mid = left + (right - left) / 2;
           if(ls.get(mid) == target){
             p.greOEql = ls.get(mid);
              p.smaOEql = ls.get(mid);
              return p;
           }

           if(ls.get(mid) > target){
            p.greOEql = ls.get(mid);
            right = mid - 1;
           }else{
            p.smaOEql = ls.get(mid);
            left = mid + 1;
           }
        }
        return p;
    }
}











