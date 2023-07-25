/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
/**
 * bfs+利用二叉搜索树的特性
 */
var lowestCommonAncestor = function (root, p, q) {
    let node = root;
    while (true) {
      if (node.val > p.val && node.val > q.val) {
        node = node.left;
      } else if (node.val < p.val && node.val < q.val) {
        node = node.right;
      } else {
        break;
      }
    }
    return node;
  };