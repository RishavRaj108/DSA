class Solution {

    class Tuple {
        int maxi;
        int mini;
        boolean isBst;
        int sum;

        Tuple(int maxi, int mini, boolean isBst, int sum) {
            this.maxi = maxi;
            this.mini = mini;
            this.isBst = isBst;
            this.sum = sum;
        }
    }

    int ans = 0;

    public int maxSumBST(TreeNode root) {
        find(root);
        return ans;
    }

    public Tuple find(TreeNode root) {

        if (root == null) {
            return new Tuple(
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                true,
                0
            );
        }

        Tuple left = find(root.left);
        Tuple right = find(root.right);

        int maxi = Math.max(root.val,
                    Math.max(left.maxi, right.maxi));

        int mini = Math.min(root.val,
                    Math.min(left.mini, right.mini));

        // Current subtree is a BST
        if (left.isBst &&
            right.isBst &&
            root.val > left.maxi &&
            root.val < right.mini) {

            int sum = left.sum + root.val + right.sum;

            ans = Math.max(ans, sum);

            return new Tuple(
                maxi,
                mini,
                true,
                sum
            );
        }

        // Current subtree is NOT a BST
        return new Tuple(
            maxi,
            mini,
            false,
            0
        );
    }
}