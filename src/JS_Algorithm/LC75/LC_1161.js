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
var maxLevelSum = function(root) {
    let resArr = [], stack = [];

    stack.push(root);

    while(stack.length > 0) {
        let n = stack.length;
        let sum = 0;

        for(let i = 0; i < n; i++) {
            let cur = stack.shift();
            sum += cur.val;

            if(cur.left)
                stack.push(cur.left);
            if(cur.right)
                stack.push(cur.right);

        }

        resArr.push(sum);
    }

    let max = resArr[0];

    for(let i = 1; i < resArr.length; i++) {
        if(resArr[i] > max)
            max = resArr[i];
    }

    for(let i = 0; i < resArr.length; i++)
        if(resArr[i] == max) {
            return i + 1;
        }

};