/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {boolean}
 */
var leafSimilar = function(root1, root2) {
    let res1 = [], res2 = [];

    const dfs = (root, res) => {
        if(root.left == null && root.right == null) {
            res.push(root.val);
            return;
        }

        if(root.left != null)
            dfs(root.left, res);

        if(root.right != null)
            dfs(root.right, res);
    }

    dfs(root1, res1);
    dfs(root2, res2);

    if(res1.length != res2.length)
        return false;

    for(let i = 0; i < res1.length; i++) {
        if(res1[i] != res2[i])
            return false;
    }

    return true;
};