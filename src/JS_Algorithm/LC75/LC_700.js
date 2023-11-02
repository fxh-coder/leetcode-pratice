/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} val
 * @return {TreeNode}
 */
var searchBST = function(root, val) {
    let res;
    const dfs = (root, val) => {
        if(root == null)
            return;
        if(root.val == val) {
            res = root;
            return;
        }
        if (root.val < val) {
            dfs(root.right, val);
        } else {
            dfs(root.left, val);
        }
    }

    dfs(root, val);

    return res ? res : null;
};