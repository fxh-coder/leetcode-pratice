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
 * @param {number} targetSum
 * @return {number}
 */
var pathSum = function(root, targetSum) {
    if (!root) {
        return 0
    }
    let ans = 0
    function dfs (node, need) {
        if (!node) {
            return
        }
        need -= node.val
        if (need === 0) {
            ans ++;
            // 在这不能直接返回，因为后面可能会减到负数，然后再减到正数，最后还是为0
        }
        dfs(node.left, need)
        dfs(node.right, need)
    }
    dfs(root, targetSum)
    // 从每个子树开始尝试，计算累加和
    return ans + pathSum(root.left, targetSum) + pathSum(root.right, targetSum)
};