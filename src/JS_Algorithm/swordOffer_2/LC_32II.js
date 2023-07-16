/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    if(root == null)
        return [];

    let queue = [], res = [];
    queue.push(root);

    while(queue.length) {
        let prc = [];

        let size = queue.length;
        for(let i = 0; i < size; i++) {
            let node = queue.shift();
            prc.push(node.val);
            if(node.left)
                queue.push(node.left);
            if(node.right)
                queue.push(node.right);
        }
        res.push(prc);
    }
    return res;
};