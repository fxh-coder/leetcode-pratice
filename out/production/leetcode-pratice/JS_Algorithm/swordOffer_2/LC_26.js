/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} A
 * @param {TreeNode} B
 * @return {boolean}
 */
var isSubStructure = function(A, B) {
    if(A == null || B == null)
        return false;
    let queue = [];

    queue.push(A);

    while(queue.length) {
        let node = queue.shift();
        if(node.val == B.val) {
            if(iter(node, B))
                return true;
        }
        if(node.left)
            queue.push(node.left);
        if(node.right)
            queue.push(node.right);
    }

    return false;

    function iter(n1, n2) {
        let q2 = [], q1 = [];
        q1.push(n1);
        q2.push(n2);



        while(q2.length && q1.length) {
            let node1 = q1.shift();
            let node2 = q2.shift();

            if(node1.val != node2.val) {
                return false;
            }
            if(node1.left)
                q1.push(node1.left);
            if(node1.right)
                q1.push(node1.right);
            if(node2.left)
                q2.push(node2.left);
            if(node2.right)
                q2.push(node2.right);
        }
        if(q2.length == 0)
            return true;
        else
            return false;
    }
};