var kthLargest = function(root, k) {
    //   中序遍历
    var roots = [];
    //  中序遍历的接口
    var inOrderTraverse = function(node) {
        if(node !== null){
            inOrderTraverse(node.left);
            roots.push(node.val);
            inOrderTraverse(node.right);
        }
    }
    inOrderTraverse(root);
    roots.reverse();
    return roots[--k];
};
    