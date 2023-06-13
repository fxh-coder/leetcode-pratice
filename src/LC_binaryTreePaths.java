import java.util.ArrayList;
import java.util.List;

public class LC_binaryTreePaths {
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

    /**
     * 力扣二叉树的所有路径
     */
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode root, String s) {
        if(root != null) {
            StringBuffer path = new StringBuffer(s);
            path.append(Integer.toString(root.val));

            if(root.left == null && root.right == null) {
                res.add(path.toString());
            } else {
                path.append("->");
                dfs(root.left, path.toString());
                dfs(root.right, path.toString());
            }
        }
    }

}
