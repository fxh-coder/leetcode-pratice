public class LC_binaryTreeMaximumPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int maxSum = Integer.MIN_VALUE;

    /**
     * 二叉树中的最大路径和
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if(root == null)
            return 0;

        // 递归计算左右子节点的最大贡献值（使用左右子节点的值与0作比较，
        // 小于则不用当前节点的值，也就是使用0代替）
        int leftVal = Math.max(dfs(root.left), 0);
        int rightVal = Math.max(dfs(root.right), 0);

        // 计算当前路径的和
        int curPathSum = root.val + leftVal + rightVal;

        // 更新答案
        maxSum = Math.max(maxSum, curPathSum);

        // 返回当前节点对于路径的最大贡献值（因为路径相当于是一条线，所以对于
        // 当前节点来说，对于整体路径的最大贡献值，应该是当前节点的值加上左右
        // 子节点中的最大值）
        return root.val + Math.max(leftVal, rightVal);
    }
}
