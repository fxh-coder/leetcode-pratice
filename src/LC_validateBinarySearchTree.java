public class LC_validateBinarySearchTree {
    /**
     * 力扣验证二叉搜索树
     */
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

    TreeNode pre = null;
    boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        if(!flag)
            return false;
        return true;
    }

    private void dfs(TreeNode root) {
        if(root == null || !flag)
            return;

        dfs(root.left);
        if(pre == null)
            pre = root;
        else{
            if(root.val <= pre.val) {
                flag = false;
                return;
            }
            pre = root;
        }
        dfs(root.right);
    }
}
