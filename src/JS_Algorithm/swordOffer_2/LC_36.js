var treeToDoublyList = function (root) {
    function dfs(root) {
        if (root == null) return null; // 递归边界: 叶子结点返回

        dfs(root.left);

        // 当 pre === null 的时候，为最小的叶子节点，设置成链表头结点
        pre != null ? pre.right = root : head = root
        root.left = pre;
        pre = root; // 链表指针向右移动

        dfs(root.right);
    }

    let pre = null, head = null;
    if (root == null) return root;

    dfs(root);
    head.left = pre;
    pre.right = head;

    return head;
};
 