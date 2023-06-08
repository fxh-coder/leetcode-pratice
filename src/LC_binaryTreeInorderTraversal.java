import java.util.ArrayList;
import java.util.List;

public class LC_binaryTreeInorderTraversal {
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

    List<Integer> res = new ArrayList<>();

    /**
     * 力扣二叉树中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
         dfs(root);
         return res;
    }

    public void dfs(TreeNode root) {
        if(root == null)
            return;
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}
