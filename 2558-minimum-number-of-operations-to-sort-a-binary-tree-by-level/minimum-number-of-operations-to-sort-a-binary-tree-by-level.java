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
    public int minimumOperations(TreeNode root) {
        int cnt = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> ls = new ArrayList<>();
            Map<Integer , Integer> mp = new HashMap<>();
            for(int i = 0;i < size;i++){
                TreeNode node = q.poll();
                ls.add(node.val);
                mp.put(node.val , ls.size() - 1);
                if(node.left != null) q.add(node.left);
                if(node.right != null)q.add(node.right);
            }
            List<Integer> sorted = new ArrayList<>(ls);
            Collections.sort(sorted);
            for(int i = 0;i < size;i++){
                if(!ls.get(i).equals(sorted.get(i))){
                    int ind = mp.get(sorted.get(i));
                    // swap
                    cnt++;
                    int temp = ls.get(i);
                    ls.set(i , sorted.get(i));
                    ls.set(ind , temp);
                    mp.put(temp,ind);
                }
            }
        }
        return cnt;
    }
}











