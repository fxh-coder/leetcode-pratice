/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function(root) {
    if (root == null) {
        return 0;
    } else {
        let leftHeight = maxDepth(root.left);
        let rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
};