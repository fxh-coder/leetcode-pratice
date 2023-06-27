package stage6_11;

import java.util.ArrayList;
import java.util.List;

public class LC_binaryTreePostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> res = new ArrayList<>();

    /**
     * 力扣二叉树的后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

}
