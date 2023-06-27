public class LC_symmetricTree {
    /**
     * 力扣对称二叉树
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
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        // 左右同时为空才正确
        if (p == null && q == null) {
            return true;
        }
        // 左右有一个不为空就错误
        if (p == null || q == null) {
            return false;
        }
        // 递归遍历当前节点的值以及子树是否符合条件
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
