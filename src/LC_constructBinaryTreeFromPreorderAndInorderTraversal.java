import java.util.HashMap;
import java.util.Map;

public class LC_constructBinaryTreeFromPreorderAndInorderTraversal {
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

    // 构建节点值与下标的map
    Map<Integer, Integer> indexMap = new HashMap<>();

    /**
     * 力扣从前序与中序遍历序列构造二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            // 因为后续需要使用map查找每次递归的根节点在中序遍历种的位置，所以使用的是inorder
            indexMap.put(inorder[i], i);
        }

        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
        if(pre_left > pre_right)
            return null;

        // 前序遍历第一个节点就是根节点
        int root_idx = pre_left;
        // 在中序遍历种找到根节点的位置
        int in_root_idx = indexMap.get(preorder[root_idx]);

        // 建立根节点
        TreeNode root = new TreeNode(preorder[root_idx]);
        // 左子树节点的数量
        int size_left = in_root_idx - in_left;
        // 递归的构造左子树
        // 由左子树的节点数量可以确定先序遍历和中序遍历的左子树的起始点
        root.left = myBuildTree(preorder, inorder, pre_left + 1, pre_left + size_left, in_left,  in_root_idx - 1);
        // 递归的构造右子树
        root.right = myBuildTree(preorder, inorder, pre_left + size_left + 1, pre_right, in_root_idx + 1, in_right);

        return root;
    }

}
