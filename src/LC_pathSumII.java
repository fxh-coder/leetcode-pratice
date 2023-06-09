import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC_pathSumII {
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

    List<List<Integer>> res = new LinkedList<List<Integer>>();
    Deque<Integer> temp = new LinkedList<Integer>();

    /**
     * 力扣路径总和II
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        temp.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new LinkedList<Integer>(temp));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        temp.pollLast();
    }
}
