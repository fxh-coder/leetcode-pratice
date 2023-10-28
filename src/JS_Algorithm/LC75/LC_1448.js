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
 * @return {number}
 */
var goodNodes = function(root) {
    let res = [];
    let max = root.val;

    const dfs = (cur, max, res1) => {
        if(cur == null)
            return;
        if(max <= cur.val)
            res1.push(cur.val);

        max = Math.max(cur.val, max);
        dfs(cur.left, max, res1);
        dfs(cur.right, max, res1);

    }

    dfs(root, max, res);

    return res.length;
};