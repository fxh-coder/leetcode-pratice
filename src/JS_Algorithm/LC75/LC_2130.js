/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {number}
 */
var pairSum = function(head) {
    let res = 0;
    let arr = [];
    let link = head;

    while (link) {
        arr.push(link.val);
        link = link.next;
    };

    let len = arr.length;
    let index  = 0;
    while (index < (len >> 1)) {
        res = Math.max(res, arr[index] + arr[len - 1 - index]);
        index++;
    }
    return res;
};
