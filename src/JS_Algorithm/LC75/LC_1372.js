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
var longestZigZag = function(root) {
    let res  = 0;

    const dfs = (cur, l, r) => {
        res = Math.max(res, l, r);
        // 只有一个值有值，另一个为0，是因为当前节点只能选择往左或者往右，所以只有一个有值
        if(cur.left)
            dfs(cur.left, r + 1, 0);
        if(cur.right)
            dfs(cur.right, 0, l + 1);
    }

    dfs(root, 0, 0);

    return res;
};