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
 * @return {number[]}
 */
var rightSideView = function(root) {
    let res = [];

    const dfs = (cur, depth) => {
        if(cur == null)
            return;

        if(depth == res.length)
            res.push(cur.val);

        depth++;
        dfs(cur.right, depth);
        dfs(cur.left, depth);
    }

    dfs(root, 0);

    return res;
};