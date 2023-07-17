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
 * @param {number} target
 * @return {number[][]}
 */
var pathSum = function(root, target) {
    let res = [], temp = [];
    dfs(root, target);
    return res;

    function dfs(root, targetSum) {
        if (root == null) {
            return;
        }
        temp.push(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            res.push(Array.from(temp));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        temp = temp.splice(0, temp.length - 1);
    }
};