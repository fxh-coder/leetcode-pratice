
/**
 * @param {number[]} postorder
 * @return {boolean}
 */
var verifyPostorder = function(postorder) {
    if (postorder.length <= 2) {
        return true
    }
    // 后序遍历：左、右、根，因为二叉搜索树中序遍历是有序的
    // 后序遍历的话，后边是根元素，只要找到比根元素大的下标
    // 分成左右两部分，左边都小于，右边都大于就可以
    const root = postorder.pop()
    let index = postorder.findIndex(num => num > root)
    index = index === -1 ? postorder.length : index
    const left = postorder.slice(0, index)
    const right = postorder.slice(index) 
    return left.every(num => num < root) && right.every(num => num > root) && verifyPostorder(left) && verifyPostorder(right)
};
 
