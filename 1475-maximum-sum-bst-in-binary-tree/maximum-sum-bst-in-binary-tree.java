class Solution {
    class Tuple {
        int maxi, mini;
        boolean isBst;
        int sum;    
        int maxiBst; 
        Tuple(int maxi, int mini, boolean isBst, int sum, int maxiBst) {
            this.maxi = maxi;
            this.mini = mini;
            this.isBst = isBst;
            this.sum = sum;
            this.maxiBst = maxiBst;
        }
    }
    public int maxSumBST(TreeNode root) {
        return Math.max(find(root).maxiBst, 0);
    }
    public Tuple find(TreeNode root) {
        if (root == null) {
            return new Tuple(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0, 0);
        }
        if (root.left == null && root.right == null) {
            return new Tuple(root.val, root.val, true, root.val, root.val);
        }
        Tuple left = find(root.left);
        Tuple right = find(root.right);
        int maxi = Math.max(root.val, Math.max(left.maxi, right.maxi));
        int mini = Math.min(root.val, Math.min(left.mini, right.mini));
        if (left.isBst && right.isBst && root.val > left.maxi && root.val < right.mini) {
            int sum = root.val + left.sum + right.sum;       
            int best = Math.max(sum, Math.max(left.maxiBst, right.maxiBst));
            return new Tuple(maxi, mini, true, sum, best);
        } else {
            return new Tuple(maxi, mini, false, 0, Math.max(left.maxiBst, right.maxiBst));
        }
    }
}