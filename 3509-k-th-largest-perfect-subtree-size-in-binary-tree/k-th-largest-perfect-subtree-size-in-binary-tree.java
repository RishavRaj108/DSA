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
    class Triple{
        int size;
        int level;
        boolean isBS;
        Triple(int size,int level,boolean isBS){
            this.size = size;
            this.level = level;
            this.isBS = isBS;
        }
    }
    List<Integer> ls;
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        ls = new ArrayList<>();
        find(root);
        Collections.sort(ls);
        if(ls.size() < k)return -1;
        return ls.get(ls.size() - k);
    }
    public Triple find(TreeNode root){
        
        if(root.left == null && root.right == null){
           ls.add(1);
           return new Triple(1,1,true);
        } 
        Triple left = new Triple(-1,-1,false);
        Triple right = new Triple(-1,-1,false);
        if(root.left != null){
            left = find(root.left);
        }
        if(root.right != null){
            right = find(root.right);
        }
        if((left.isBS && right.isBS ) && left.level == right.level){
          int newSize =1 + left.size + right.size;
          ls.add(newSize);
          int level = right.level + 1;
          return new Triple(newSize , level , true);
        }else{
            return new Triple(-1,-1,false);
        }
    }
}























