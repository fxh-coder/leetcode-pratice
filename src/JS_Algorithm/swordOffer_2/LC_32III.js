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
    let cnt = 0;
    while(queue.length) {
        let prc = [];
        cnt++;
        let size = queue.length;
        for(let i = 0; i < size; i++) {
            let node = queue.shift();
            prc.push(node.val);
            if(node.left)
                queue.push(node.left);
            if(node.right)
                queue.push(node.right);
        }
        cnt % 2 == 0 ? res.push(prc.reverse()) : res.push(prc);
    }
    return res;
};